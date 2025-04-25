"use client";

import { useState, useEffect, useMemo } from "react";
import CardGrid from "@/components/card-grid";
import CardModal from "@/components/card-modal";
import type { Card } from "@/lib/types";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import {
  DropdownMenu,
  DropdownMenuCheckboxItem,
  DropdownMenuContent,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu";
import { Search, ChevronDown } from "lucide-react";
import FilterSidebar from "@/components/filter-sidebar";

// Define filter options
const ALL_COLORS = ["Red", "Green", "Blue", "Purple", "Black", "Yellow"];
const ALL_COSTS = Array.from({ length: 10 }, (_, i) => i + 1); // Costs 1-10
const ALL_TYPES = ["Leader", "Character", "Event"];
const ALL_COUNTERS = [0, 1000, 2000]; // Add common counter values
const ALL_SETS = [...Array.from({ length: 10 }, (_, i) => `OP${String(i + 1).padStart(2, '0')}`), "EB01"]; // OP01-OP10 plus EB01
// Define starter decks
const ALL_STARTER_DECKS = [
  ...Array.from({ length: 21 }, (_, i) => `ST${String(i + 1).padStart(2, '0')}`), // ST01-ST21
  "EB01" // Add EB01 set
];
// Define common keywords (adjust as needed)
const ALL_KEYWORDS = ["Rush", "Blocker", "Double Attack", "Banish", "Trigger", "On Play", "When Attacking", "On K.O.", "Counter"];

export default function CardDisplayArea() {
  const [selectedCard, setSelectedCard] = useState<Card | null>(null);
  const [isModalOpen, setIsModalOpen] = useState(false);

  // State for filters and search
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedColors, setSelectedColors] = useState<Set<string>>(new Set());
  const [selectedCosts, setSelectedCosts] = useState<Set<number>>(new Set());
  const [selectedTypes, setSelectedTypes] = useState<Set<string>>(new Set());
  const [selectedCounters, setSelectedCounters] = useState<Set<number>>(new Set());
  const [selectedSets, setSelectedSets] = useState<Set<string>>(new Set());
  const [selectedStarterDecks, setSelectedStarterDecks] = useState<Set<string>>(new Set());
  const [selectedKeywords, setSelectedKeywords] = useState<Set<string>>(new Set());
  const [isLoading, setIsLoading] = useState(true); // Add loading state
  const [error, setError] = useState<string | null>(null); // Add error state

  // State for all cards fetched from backend
  const [allCards, setAllCards] = useState<Card[]>([]); // Initialize empty

  // --- Data Fetching Effect ---
  useEffect(() => {
    const fetchCards = async () => {
      setIsLoading(true);
      setError(null);
      try {
        const res = await fetch('http://localhost:8080/api/cards', { cache: 'no-store' });
        if (!res.ok) {
          throw new Error(`HTTP error! status: ${res.status}`);
        }
        const data: Card[] = await res.json();
        setAllCards(data);
      } catch (e) {
        console.error("Failed to fetch cards:", e);
        setError(e instanceof Error ? e.message : "An unknown error occurred");
        setAllCards([]); // Ensure empty array on error
      } finally {
        setIsLoading(false);
      }
    };

    fetchCards();
  }, []); // Empty dependency array ensures this runs only once on mount

  // --- Filtering Logic (Client-side for now) ---
  const filteredCards = useMemo(() => {
    return allCards.filter((card) => {
      // Search term filter (name or effect text)
      const lowerSearchTerm = searchTerm.toLowerCase();
      const searchMatch = lowerSearchTerm === '' ||
                          card.name.toLowerCase().includes(lowerSearchTerm) ||
                          card.effect?.toLowerCase().includes(lowerSearchTerm);

      // Color filter
      const cardColors = card.color?.split('/').map(c => c.trim()) || [];
      const colorMatch = selectedColors.size === 0 ||
                         cardColors.some(color => selectedColors.has(color));

      // Cost filter
      const costMatch = selectedCosts.size === 0 ||
                        (card.cost !== null && selectedCosts.has(card.cost));

      // Type filter (case-insensitive)
      const typeMatch = selectedTypes.size === 0 ||
                        (card.cardType && // Ensure cardType is not null/undefined
                         selectedTypes.has(card.cardType.toLowerCase())); // Compare lowercase

      // Counter filter (Handle null/undefined and explicit "None" selection)
      const counterMatch = selectedCounters.size === 0 ||
                         (selectedCounters.has(-1) // Check if "None" is selected
                           ? card.counter === null || card.counter === undefined // Match only if counter is null or undefined
                           : (typeof card.counter === 'number' && selectedCounters.has(card.counter)) // Otherwise, match selected values
                         );

      // Set filter
      const setMatch = selectedSets.size === 0 ||
                       (card.set && selectedSets.has(card.set));
                       
      // Starter Deck filter
      const starterDeckMatch = selectedStarterDecks.size === 0 ||
                           (card.set && selectedStarterDecks.has(card.set));

      // Keyword filter (case-insensitive check within effect text)
      const effectText = card.effect?.toLowerCase() || "";
      const keywordMatch = selectedKeywords.size === 0 ||
                           Array.from(selectedKeywords).every(keyword =>
                             effectText.includes(keyword.toLowerCase())
                           );

      // Combine all filters
      return searchMatch && colorMatch && costMatch && typeMatch && counterMatch && setMatch && starterDeckMatch && keywordMatch;
    });
  }, [allCards, searchTerm, selectedColors, selectedCosts, selectedTypes, selectedCounters, selectedSets, selectedStarterDecks, selectedKeywords]);

  // --- Event Handlers ---
  const handleCardClick = (card: Card) => {
    setSelectedCard(card);
    setIsModalOpen(true);
  };

  const handleModalOpenChange = (open: boolean) => {
    setIsModalOpen(open);
    if (!open) {
      setSelectedCard(null);
    }
  };

  const handleFilterChange = (
    value: string | number,
    type: 'color' | 'cost' | 'type' | 'counter' | 'set' | 'starter-deck' | 'keyword'
  ) => {
    switch (type) {
      case 'color':
        setSelectedColors((prev) => {
          const next = new Set(prev);
          if (next.has(value as string)) next.delete(value as string);
          else next.add(value as string);
          return next;
        });
        break;
      case 'cost':
         setSelectedCosts((prev) => {
          const next = new Set(prev);
          const costVal = Number(value);
          if (next.has(costVal)) next.delete(costVal);
          else next.add(costVal);
          return next;
        });
        break;
      case 'type':
         setSelectedTypes((prev) => {
          const next = new Set(prev);
          const lowerValue = (value as string).toLowerCase();
          if (next.has(lowerValue)) next.delete(lowerValue);
          else next.add(lowerValue);
          return next;
        });
        break;
      case 'counter':
        setSelectedCounters((prev) => {
          const next = new Set(prev);
          const counterVal = Number(value);
          if (next.has(counterVal)) next.delete(counterVal);
          else next.add(counterVal);
          return next;
        });
        break;
      case 'set':
        setSelectedSets((prev) => {
          const next = new Set(prev);
          if (next.has(value as string)) next.delete(value as string);
          else next.add(value as string);
          return next;
        });
        break;
      case 'starter-deck':
        setSelectedStarterDecks((prev) => {
          const next = new Set(prev);
          if (next.has(value as string)) next.delete(value as string);
          else next.add(value as string);
          return next;
        });
        break;
      case 'keyword':
        setSelectedKeywords((prev) => {
          const next = new Set(prev);
          if (next.has(value as string)) next.delete(value as string);
          else next.add(value as string);
          return next;
        });
        break;
    }
  };

  // --- Render Logic ---
  return (
    <div className="flex flex-col md:flex-row gap-6">
      <div className="md:w-64 shrink-0">
        <FilterSidebar
          allSets={ALL_SETS}
          selectedSets={selectedSets}
          allStarterDecks={ALL_STARTER_DECKS}
          selectedStarterDecks={selectedStarterDecks}
          allKeywords={ALL_KEYWORDS}
          selectedKeywords={selectedKeywords}
          onFilterChange={handleFilterChange}
        />
      </div>
      <div className="flex-1">
        <div className="mb-6">
          <div className="relative mb-4">
            <Input
              type="text"
              placeholder="Search by card name or text..."
              className="w-full pl-4 pr-10 py-3 rounded-lg border border-gray-200 dark:border-gray-700 focus:outline-none focus:ring-2 focus:ring-red-500 focus:border-transparent"
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              disabled={isLoading}
            />
            <Search className="absolute right-3 top-1/2 transform -translate-y-1/2 text-gray-400 h-5 w-5" />
          </div>
          <div className="flex flex-wrap gap-2">
            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="outline" className="flex items-center gap-2" disabled={isLoading}>
                  Color {selectedColors.size > 0 && `(${selectedColors.size})`}
                  <ChevronDown className="h-4 w-4" />
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent>
                <DropdownMenuLabel>Select Colors</DropdownMenuLabel>
                <DropdownMenuSeparator />
                {ALL_COLORS.map((color) => (
                  <DropdownMenuCheckboxItem
                    key={color}
                    checked={selectedColors.has(color)}
                    onCheckedChange={() => handleFilterChange(color, 'color')}
                  >
                    {color}
                  </DropdownMenuCheckboxItem>
                ))}
              </DropdownMenuContent>
            </DropdownMenu>
            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="outline" className="flex items-center gap-2" disabled={isLoading}>
                  Cost {selectedCosts.size > 0 && `(${selectedCosts.size})`}
                  <ChevronDown className="h-4 w-4" />
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent>
                <DropdownMenuLabel>Select Costs</DropdownMenuLabel>
                <DropdownMenuSeparator />
                {ALL_COSTS.map((cost) => (
                  <DropdownMenuCheckboxItem
                    key={cost}
                    checked={selectedCosts.has(cost)}
                    onCheckedChange={() => handleFilterChange(cost, 'cost')}
                  >
                    {cost}
                  </DropdownMenuCheckboxItem>
                ))}
              </DropdownMenuContent>
            </DropdownMenu>
            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="outline" className="flex items-center gap-2" disabled={isLoading}>
                  Type {selectedTypes.size > 0 && `(${selectedTypes.size})`}
                  <ChevronDown className="h-4 w-4" />
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent>
                <DropdownMenuLabel>Select Types</DropdownMenuLabel>
                <DropdownMenuSeparator />
                {ALL_TYPES.map((type) => (
                  <DropdownMenuCheckboxItem
                    key={type}
                    checked={selectedTypes.has(type.toLowerCase())}
                    onCheckedChange={() => handleFilterChange(type, 'type')}
                  >
                    {type}
                  </DropdownMenuCheckboxItem>
                ))}
              </DropdownMenuContent>
            </DropdownMenu>
            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="outline" className="flex items-center gap-2" disabled={isLoading}>
                  Counter {selectedCounters.size > 0 && `(${selectedCounters.size})`}
                  <ChevronDown className="h-4 w-4" />
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent>
                <DropdownMenuLabel>Select Counter</DropdownMenuLabel>
                <DropdownMenuSeparator />
                {ALL_COUNTERS.map((counter) => (
                  <DropdownMenuCheckboxItem
                    key={`counter-${counter}`}
                    checked={selectedCounters.has(counter)}
                    onCheckedChange={() => handleFilterChange(counter, 'counter')}
                  >
                    {counter}
                  </DropdownMenuCheckboxItem>
                ))}
                <DropdownMenuCheckboxItem
                  key="counter-none"
                  checked={selectedCounters.has(-1)}
                  onCheckedChange={() => handleFilterChange(-1, 'counter')}
                >
                  None
                </DropdownMenuCheckboxItem>
              </DropdownMenuContent>
            </DropdownMenu>
            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="outline" className="flex items-center gap-2" disabled={isLoading}>
                  Set {selectedSets.size > 0 && `(${selectedSets.size})`}
                  <ChevronDown className="h-4 w-4" />
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent className="max-h-60 overflow-y-auto">
                <DropdownMenuLabel>Select Sets</DropdownMenuLabel>
                <DropdownMenuSeparator />
                {ALL_SETS.map((set) => (
                  <DropdownMenuCheckboxItem
                    key={set}
                    checked={selectedSets.has(set)}
                    onCheckedChange={() => handleFilterChange(set, 'set')}
                  >
                    {set}
                  </DropdownMenuCheckboxItem>
                ))}
              </DropdownMenuContent>
            </DropdownMenu>
            
            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="outline" className="flex items-center gap-2" disabled={isLoading}>
                  Starter Deck {selectedStarterDecks.size > 0 && `(${selectedStarterDecks.size})`}
                  <ChevronDown className="h-4 w-4" />
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent className="max-h-60 overflow-y-auto">
                <DropdownMenuLabel>Select Starter Decks</DropdownMenuLabel>
                <DropdownMenuSeparator />
                {ALL_STARTER_DECKS.map((deck) => (
                  <DropdownMenuCheckboxItem
                    key={deck}
                    checked={selectedStarterDecks.has(deck)}
                    onCheckedChange={() => handleFilterChange(deck, 'starter-deck')}
                  >
                    {deck}
                  </DropdownMenuCheckboxItem>
                ))}
              </DropdownMenuContent>
            </DropdownMenu>
          </div>
        </div>

        {isLoading && <div className="text-center text-gray-500 py-4">Loading cards...</div>}
        {error && <div className="text-center text-red-500 py-4">Error loading cards: {error}</div>}
        {!isLoading && !error && (
          <>
            <div className="text-sm text-gray-500 mb-4">
              {filteredCards.length} cards found
            </div>
            <CardGrid cards={filteredCards} onCardClick={handleCardClick} />
          </>
        )}
        <CardModal
          card={selectedCard}
          open={isModalOpen}
          onOpenChange={handleModalOpenChange}
        />
      </div>
    </div>
  );
} 