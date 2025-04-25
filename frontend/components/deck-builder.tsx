"use client"

import React, { useState, useEffect, useMemo, useRef, useCallback } from "react"
import { Search, Save, Upload, Filter, X, Trash2, FileInput, Play, Library } from "lucide-react"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Checkbox } from "@/components/ui/checkbox"
import { Badge } from "@/components/ui/badge"
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { DropdownMenu, DropdownMenuContent, DropdownMenuTrigger } from "@/components/ui/dropdown-menu"
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog"
import { Label } from "@/components/ui/label"
import { ScrollArea } from "@/components/ui/scroll-area"
import { Textarea } from "@/components/ui/textarea"
import { DndProvider, useDrag, useDrop } from "react-dnd"
import { HTML5Backend } from "react-dnd-html5-backend"
import { motion, AnimatePresence } from "framer-motion"
import { Card as CardType, CardStackGroup } from "@/lib/types"
import { DeckStats } from "@/components/deck-stats"
import { useAuth } from "@/hooks/useAuth"
import DeckImageGenerator from './deck-image-generator'

// Remove sample card data
// const sampleCards = [...]
// const leaderCards = [...]

// Remove old CardProps interface
// interface CardProps { ... }

// Moved colorClasses outside the component
const colorClasses: { [key: string]: string } = {
  red: "bg-red-100 text-red-800 border-red-200 dark:bg-red-900/30 dark:text-red-200 dark:border-red-900",
  blue: "bg-blue-100 text-blue-800 border-blue-200 dark:bg-blue-900/30 dark:text-blue-200 dark:border-blue-900",
  black: "bg-gray-100 text-gray-800 border-gray-200 dark:bg-gray-800/50 dark:text-gray-200 dark:border-gray-800",
  green: "bg-green-100 text-green-800 border-green-200 dark:bg-green-900/30 dark:text-green-200 dark:border-green-900",
  purple: "bg-purple-100 text-purple-800 border-purple-200 dark:bg-purple-900/30 dark:text-purple-200 dark:border-purple-900",
  yellow: "bg-yellow-100 text-yellow-800 border-yellow-200 dark:bg-yellow-900/30 dark:text-yellow-200 dark:border-yellow-900",
}

export default function DeckBuilder() {
  const [allCards, setAllCards] = useState<CardType[]>([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState<string | null>(null)

  // Add separate refs for cards and leader cards
  const [cardsToShow, setCardsToShow] = useState(50)
  const [leaderCardsToShow, setLeaderCardsToShow] = useState(50)
  const cardsLoadMoreRef = useRef<HTMLDivElement>(null)
  const leaderCardsLoadMoreRef = useRef<HTMLDivElement>(null)

  // Add state for tab synchronization
  const [cardBrowserTab, setCardBrowserTab] = useState("all")
  const [deckViewTab, setDeckViewTab] = useState("deck")

  const [searchTerm, setSearchTerm] = useState("")
  const [selectedColors, setSelectedColors] = useState<string[]>([])
  const [selectedCosts, setSelectedCosts] = useState<number[]>([])
  const [selectedTypes, setSelectedTypes] = useState<string[]>([])
  const [selectedSets, setSelectedSets] = useState<string[]>([])
  const [selectedAffiliations, setSelectedAffiliations] = useState<string[]>([])
  const [limitToFour, setLimitToFour] = useState(true)
  const [deck, setDeck] = useState<CardType[]>([])
  const [cardStacks, setCardStacks] = useState<CardStackGroup[]>([])
  const [leader, setLeader] = useState<CardType | null>(null)
  const [deckName, setDeckName] = useState("New Deck")
  const [saveDialogOpen, setSaveDialogOpen] = useState(false)
  const [importDialogOpen, setImportDialogOpen] = useState(false)
  const [importText, setImportText] = useState("")
  const [testHandDialogOpen, setTestHandDialogOpen] = useState(false)
  const [testHandCards, setTestHandCards] = useState<CardType[]>([])
  const [lastAction, setLastAction] = useState<{ type: "add" | "remove"; cardId: number } | null>(null)

  // State for available filter options
  const [availableColors, setAvailableColors] = useState<string[]>([])
  const [availableCosts, setAvailableCosts] = useState<number[]>([])
  const [availableTypes, setAvailableTypes] = useState<string[]>([])
  const [availableSets, setAvailableSets] = useState<string[]>([])

  const colors = ["red", "blue", "black", "green", "purple", "yellow"]

  const { user, isLoading: isAuthLoading } = useAuth(); // Use the actual auth state
  const isLoggedIn = !!user && !isAuthLoading; // Determine logged-in status

  const [loadDialogOpen, setLoadDialogOpen] = useState(false) // State for load dialog
  const [savedDecks, setSavedDecks] = useState<any[]>([]) // State for fetched decks (use specific DTO type later)
  const [loadingDecks, setLoadingDecks] = useState(false)
  const [loadDecksError, setLoadDecksError] = useState<string | null>(null)

  // Add state variable for ignoring color compatibility
  const [authDialogOpen, setAuthDialogOpen] = useState(false)

  // Add back the export dialog state
  const [exportDialogOpen, setExportDialogOpen] = useState(false)

  // Fetch card data from backend
  useEffect(() => {
    const fetchCards = async () => {
      setLoading(true)
      setError(null)
      try {
        // Assuming backend runs on localhost:8080
        // Make sure CORS is configured on the backend
        const response = await fetch("http://localhost:8080/api/cards")
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`)
        }
        const data: CardType[] = await response.json()
        setAllCards(data)

        // Derive filter options from fetched data
        // Normalize color cases by converting all to lowercase first, then capitalize for display
        const normalizedColors = data.flatMap(c => 
          (c.color?.split('/') ?? []).map(color => color.toLowerCase().trim())
        );
        const uniqueColors = Array.from(new Set(normalizedColors))
          .sort()
          .map(c => c.charAt(0).toUpperCase() + c.slice(1)); // Capitalize for display

        const uniqueCosts = Array.from(new Set(data.map(c => c.cost).filter(cost => cost !== null && cost !== undefined) as number[])).sort((a, b) => a - b)
        const uniqueTypes = Array.from(new Set(data.map(c => c.cardType).filter(type => type) as string[])).sort()
        const uniqueSets = Array.from(new Set(data.map(c => c.set).filter(set => set) as string[])).sort()

        setAvailableColors(uniqueColors)
        setAvailableCosts(uniqueCosts)
        setAvailableTypes(uniqueTypes.filter(type => type.toUpperCase() !== 'LEADER')) // Exclude LEADER from general type filter
        setAvailableSets(uniqueSets)

      } catch (e) {
        if (e instanceof Error) {
          setError(`Failed to fetch cards: ${e.message}`)
        } else {
          setError("An unknown error occurred while fetching cards.")
        }
        console.error("Failed to fetch cards:", e)
      } finally {
        setLoading(false)
      }
    }

    fetchCards()
  }, [])

  // Group cards into stacks whenever deck changes
  useEffect(() => {
    const grouped: Record<number, CardType[]> = {}

    deck.forEach((card: CardType) => {
      if (!grouped[card.id]) {
        grouped[card.id] = []
      }
      grouped[card.id].push(card)
    })

    const stacks: CardStackGroup[] = Object.keys(grouped).map((key) => ({
      id: Number.parseInt(key),
      cards: grouped[Number.parseInt(key)],
    }))

    setCardStacks(stacks)
  }, [deck])

  // Memoize filtered cards calculation
  const filteredCards = useMemo(() => {
    return allCards.filter((card: CardType) => {
      const lowerSearchTerm = searchTerm.toLowerCase();
      const cardAffiliationsArray = card.affiliations?.toLowerCase().split('/').map(a => a.trim()).filter(a => a) ?? [];
      const matchesSearch = card.name.toLowerCase().includes(lowerSearchTerm) ||
                            cardAffiliationsArray.some(aff => aff.includes(lowerSearchTerm));
      
      // Case-insensitive color matching
      const cardColors = card.color?.toLowerCase().split('/').map(c => c.trim()) || [];
      const matchesColor = selectedColors.length === 0 || 
                            cardColors.some(cardColor => 
                              selectedColors.map(c => c.toLowerCase()).includes(cardColor));
      
      const isNotLeader = card.cardType && card.cardType.toUpperCase() !== 'LEADER';
      const matchesCost = selectedCosts.length === 0 || (card.cost !== null && card.cost !== undefined && selectedCosts.includes(card.cost));
      const matchesType = selectedTypes.length === 0 || (card.cardType && selectedTypes.includes(card.cardType));
      const matchesSet = selectedSets.length === 0 || (card.set && selectedSets.includes(card.set));
      // Affiliation filter
      const matchesAffiliation = selectedAffiliations.length === 0 || 
                                 cardAffiliationsArray.some(affiliation => selectedAffiliations.map(sa => sa.toLowerCase()).includes(affiliation)); // Compare lowercase

      return matchesSearch && matchesColor && isNotLeader && matchesCost && matchesType && matchesSet && matchesAffiliation;
    });
  }, [allCards, searchTerm, selectedColors, selectedCosts, selectedTypes, selectedSets, selectedAffiliations]);

  // Memoize filtered leader cards calculation
  const filteredLeaderCards = useMemo(() => {
    return allCards.filter((card: CardType) => {
      const lowerSearchTerm = searchTerm.toLowerCase();
      const cardAffiliationsArray = card.affiliations?.toLowerCase().split('/').map(a => a.trim()).filter(a => a) ?? [];
      const matchesSearch = card.name.toLowerCase().includes(lowerSearchTerm) ||
                            cardAffiliationsArray.some(aff => aff.includes(lowerSearchTerm));
      const isLeader = card.cardType && card.cardType.toUpperCase() === 'LEADER';
      if (!isLeader) return false;

      // Case-insensitive color matching
      const cardColors = card.color?.toLowerCase().split('/').map(c => c.trim()) || [];
      const matchesColor = selectedColors.length === 0 || 
                            cardColors.some(cardColor => 
                              selectedColors.map(c => c.toLowerCase()).includes(cardColor));
                            
      const matchesCost = selectedCosts.length === 0 || (card.cost !== null && card.cost !== undefined && selectedCosts.includes(card.cost));
      const matchesSet = selectedSets.length === 0 || (card.set && selectedSets.includes(card.set));

      return matchesSearch && matchesColor && matchesCost && matchesSet;
    });
  }, [allCards, searchTerm, selectedColors, selectedCosts, selectedSets]);

  // Memoize visible cards slices
  const visibleCards = useMemo(() => {
    return filteredCards.slice(0, cardsToShow);
  }, [filteredCards, cardsToShow]);
  
  const visibleLeaderCards = useMemo(() => {
    return filteredLeaderCards.slice(0, leaderCardsToShow);
  }, [filteredLeaderCards, leaderCardsToShow]);

  // Setup intersection observer for infinite scrolling
  useEffect(() => {
    // Create observer for regular cards
    const cardsObserver = new IntersectionObserver(
      (entries) => {
        const target = entries[0];
        if (target.isIntersecting && visibleCards.length < filteredCards.length) {
          setCardsToShow(prev => prev + 50);
        }
      },
      { threshold: 0.1 }
    );

    // Create separate observer for leader cards
    const leaderCardsObserver = new IntersectionObserver(
      (entries) => {
        const target = entries[0];
        if (target.isIntersecting && visibleLeaderCards.length < filteredLeaderCards.length) {
          setLeaderCardsToShow(prev => prev + 50);
        }
      },
      { threshold: 0.1 }
    );

    // Observe both refs if they exist
    if (cardsLoadMoreRef.current) {
      cardsObserver.observe(cardsLoadMoreRef.current);
    }
    
    if (leaderCardsLoadMoreRef.current) {
      leaderCardsObserver.observe(leaderCardsLoadMoreRef.current);
    }

    return () => {
      if (cardsLoadMoreRef.current) {
        cardsObserver.unobserve(cardsLoadMoreRef.current);
      }
      if (leaderCardsLoadMoreRef.current) {
        leaderCardsObserver.unobserve(leaderCardsLoadMoreRef.current);
      }
    };
  }, [filteredCards.length, visibleCards.length, filteredLeaderCards.length, visibleLeaderCards.length]);

  // Reset visible cards count when filters change
  useEffect(() => {
    setCardsToShow(50);
  }, [searchTerm, selectedColors, selectedCosts, selectedTypes, selectedSets, selectedAffiliations]);

  // Reset leader cards count when filters change
  useEffect(() => {
    setLeaderCardsToShow(50);
  }, [searchTerm, selectedColors, selectedCosts, selectedSets]);

  // --- Callbacks for Memoization ---

  const addCardToDeck = useCallback((card: CardType) => {
    const maxDeckSize = 50
    if (deck.length >= maxDeckSize) {
      alert(`Deck is full! Maximum ${maxDeckSize} cards allowed (excluding leader).`)
      return
    }

    if (limitToFour) {
      const cardCount = deck.filter((c: CardType) => c.id === card.id).length
      if (cardCount >= 4) {
        // Silently prevent adding more than 4 copies (removed alert)
        return
      }
    }

    if (leader && !leader.color.split('/').some((lc: string) => card.color?.split('/').includes(lc))) {
      alert(`Card color (${card.color}) does not match leader color (${leader.color})!`)
      return
    }

    setDeck(currentDeck => [...currentDeck, card])
    setLastAction({ type: "add", cardId: card.id })
  }, [deck, leader, limitToFour])

  const removeCardFromDeck = useCallback((cardId: number, index?: number) => {
    setDeck(currentDeck => {
      const cardIndices = currentDeck.map((card: CardType, idx: number) => (card.id === cardId ? idx : -1)).filter((idx: number) => idx !== -1)

    if (cardIndices.length > 0) {
        const newDeck = [...currentDeck]
        const indexToRemove = (index !== undefined && index < cardIndices.length) ? cardIndices[index] : cardIndices[cardIndices.length - 1] // Default remove last added if index invalid/missing
      newDeck.splice(indexToRemove, 1)
      setLastAction({ type: "remove", cardId: cardId })
        return newDeck
    }
      return currentDeck // Return unchanged deck if card not found
    })
  }, []) // No external dependencies needed for this logic if using functional update

  const setLeaderCard = useCallback((card: CardType) => {
    // Check color compatibility *before* setting state
    // Normalize colors to lowercase for comparison
    const leaderColors = card.color?.toLowerCase().split('/').map(c => c.trim()) || [];
    
    const newDeck = deck.filter((deckCard: CardType) => {
      const deckCardColors = deckCard.color?.toLowerCase().split('/').map(c => c.trim()) || [];
      return deckCardColors.some(dc => leaderColors.includes(dc));
    });
    
    if (newDeck.length !== deck.length) {
      alert("Some cards were removed from the deck due to color incompatibility with the new leader.");
    }
    
    setDeck(newDeck); // Update deck based on compatibility
    setLeader(card);
    
    // Set filters based on leader with consistent capitalization
    const normalizedColors = card.color.split('/').map(c => {
      const trimmed = c.trim();
      return trimmed.charAt(0).toUpperCase() + trimmed.slice(1).toLowerCase();
    });
    setSelectedColors(normalizedColors);
    
    // Set affiliations with consistent normalization  
    const normalizedAffiliations = card.affiliations?.split('/').map(a => {
      const trimmed = a.trim();
      return trimmed ? (trimmed.charAt(0).toUpperCase() + trimmed.slice(1).toLowerCase()) : '';
    }).filter(a => a) || [];
    
    setSelectedAffiliations(normalizedAffiliations);
  }, [deck]);

  const removeLeader = useCallback(() => {
    setLeader(null)
    setSelectedColors([])
    setSelectedAffiliations([]) // Clear affiliations
  }, [])

  const moveCardStack = useCallback((dragIndex: number, hoverIndex: number) => {
    setDeck(currentDeck => {
        // Re-calculate stacks based on currentDeck to ensure consistency
        const currentGrouped: Record<number, CardType[]> = {}
        currentDeck.forEach((card: CardType) => {
            if (!currentGrouped[card.id]) { currentGrouped[card.id] = [] }
            currentGrouped[card.id].push(card)
        })
        const currentStacks: CardStackGroup[] = Object.keys(currentGrouped).map((key) => ({
            id: Number.parseInt(key),
            cards: currentGrouped[Number.parseInt(key)],
        }))

        if (dragIndex < 0 || dragIndex >= currentStacks.length || hoverIndex < 0 || hoverIndex >= currentStacks.length) {
            console.error("moveCardStack: Invalid index.");
            return currentDeck; // Return unchanged state on error
        }

        const draggedStack = currentStacks[dragIndex]
        const newCardStacks = [...currentStacks]
        newCardStacks.splice(dragIndex, 1)
        newCardStacks.splice(hoverIndex, 0, draggedStack)

        const newOrderedDeck: CardType[] = []
        newCardStacks.forEach((stack) => {
          stack.cards.forEach((card: CardType) => {
            newOrderedDeck.push(card)
          })
        })
        return newOrderedDeck
    })
  }, []) // No external dependencies needed with functional update

 const handleTestHand = useCallback(() => {
    if (!leader) {
      alert("Please select a leader first.")
      return
    }
    if (deck.length < 5) {
      alert("You need at least 5 cards in your deck to draw a starting hand.")
      return
    }

    const shuffledDeck = [...deck]
    for (let i = shuffledDeck.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [shuffledDeck[i], shuffledDeck[j]] = [shuffledDeck[j], shuffledDeck[i]]
    }

    const drawnHand = shuffledDeck.slice(0, 5)
    setTestHandCards(drawnHand)
    setTestHandDialogOpen(true)
  }, [deck, leader]) // Dependencies: deck, leader

  // --- End Callbacks ---

  // Clear only the filters set by the leader
  const clearLeaderFilters = useCallback(() => {
    setSelectedColors([])
    setSelectedAffiliations([])
  }, [])

  // Toggle color filter
  const toggleColorFilter = (color: string) => {
    if (selectedColors.includes(color)) {
      setSelectedColors(selectedColors.filter(c => c !== color))
    } else {
      setSelectedColors([...selectedColors, color])
    }
  }

  // Toggle cost filter
  const toggleCostFilter = (cost: number) => {
    if (selectedCosts.includes(cost)) {
      setSelectedCosts(selectedCosts.filter(c => c !== cost))
    } else {
      setSelectedCosts([...selectedCosts, cost])
    }
  }

  // Toggle type filter
  const toggleTypeFilter = (type: string) => {
    setSelectedTypes(prev =>
      prev.includes(type) ? prev.filter(t => t !== type) : [...prev, type]
    )
  }

  // Toggle set filter
  const toggleSetFilter = (set: string) => {
    setSelectedSets(prev =>
      prev.includes(set) ? prev.filter(s => s !== set) : [...prev, set]
    )
  }

  // Reset filters
  const resetFilters = () => {
    setSearchTerm("")
    setSelectedColors([])
    setSelectedCosts([])
    setSelectedTypes([])
    setSelectedSets([])
  }

  // Clear deck
  const clearDeck = () => {
    if (window.confirm("Are you sure you want to clear the entire deck and remove the leader?")) {
      setDeck([])
      setLeader(null)
      setSelectedColors([]) // Also clear color filter if leader determined it
    }
  }

  // Save deck (Updated to call backend)
  const saveDeck = async () => { // Made async
    if (!isLoggedIn) {
      setAuthDialogOpen(true);
      return;
    }
    
    if (!leader) {
      alert("Please select a leader before saving.")
      return
    }
    if (!deckName.trim()) {
       alert("Please enter a deck name.")
       return
    }

    // Prepare DTO payload
    const payload = {
      name: deckName.trim(),
      leaderCardNumber: leader.cardNumber,
      cards: cardStacks.map(stack => ({
          cardNumber: stack.cards[0].cardNumber, // Get cardNumber from the first card in stack
          quantity: stack.cards.length
      }))
    }

    try {
      const response = await fetch("http://localhost:8080/api/decks", {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        credentials: 'include',
        body: JSON.stringify(payload),
      })

      if (!response.ok) {
        // Try to parse error message from backend
        const errorData = await response.json().catch(() => null);
        const errorMessage = errorData?.message || `HTTP error! status: ${response.status}`;
        throw new Error(errorMessage);
      }

      const savedDeckData = await response.json(); // Get saved deck data (includes ID)
      console.log("Deck saved successfully:", savedDeckData);
      alert(`Deck "${savedDeckData.name}" saved successfully!`);
      setSaveDialogOpen(false);

    } catch (error) {
       console.error("Failed to save deck:", error);
       alert(`Failed to save deck: ${error instanceof Error ? error.message : String(error)}`);
    }
  }

  // Handle deck import from text
  const handleImportDeck = () => {
     if (!allCards || allCards.length === 0) {
      // Silently return if cards haven't loaded
       return
     }
    
     const lines = importText.trim().split(/\r?\n/)
    const parsedEntries: { quantity: number; cardNumber: string }[] = []
     const errors: string[] = []
    const unfoundCardNumbers: string[] = []
    
    // Regex to match format like "1xOP09-081" or "1x OP09-081" (with optional space)
    const lineRegex = /^(\d+)x\s*([a-zA-Z0-9-]+)$/
    
     lines.forEach((line, index) => {
       const trimmedLine = line.trim()
       if (!trimmedLine) return
      
       const match = trimmedLine.match(lineRegex)
       if (match) {
         const quantity = parseInt(match[1], 10)
        const cardNumber = match[2].toUpperCase() // Normalize to uppercase
        
         if (quantity > 0) {
          parsedEntries.push({ quantity, cardNumber })
         } else {
          errors.push(`Line ${index + 1}: Invalid quantity '${match[1]}' for card ${cardNumber}.`)
         }
       } else {
        errors.push(`Line ${index + 1}: Invalid format '${trimmedLine}'. Expected format: 1xOP09-081`)
       }
     })
    
     if (errors.length > 0) {
      // Skip import due to parsing errors but don't show alert
      console.error("Errors found in decklist:", errors)
       return
     }
    
     let potentialLeader: CardType | null = null
     const newDeck: CardType[] = []
    
     for (const entry of parsedEntries) {
      const foundCard = allCards.find((c) => c.cardNumber === entry.cardNumber)
      
       if (!foundCard) {
        if (!unfoundCardNumbers.includes(entry.cardNumber)) {
          unfoundCardNumbers.push(entry.cardNumber)
         }
         continue
       }
      
       if (foundCard.cardType && foundCard.cardType.toUpperCase() === 'LEADER') {
         if (!potentialLeader) {
           potentialLeader = foundCard
           if (entry.quantity > 1) {
            errors.push(`Warning: Multiple copies of leader ${entry.cardNumber} specified. Only one will be used.`)
           }
        } else if (potentialLeader.cardNumber !== foundCard.cardNumber) {
          errors.push(`Error: Multiple different leaders found (${potentialLeader.cardNumber}, ${entry.cardNumber}). Only one leader allowed.`)
         }
         continue
       }
      
       for (let i = 0; i < entry.quantity; i++) {
         if (newDeck.length >= 50) {
          errors.push(`Warning: Deck limit of 50 cards reached. Could not add all copies of ${entry.cardNumber}.`)
           break
         }
        
        const currentCountInDeck = newDeck.filter((c) => c.cardNumber === entry.cardNumber).length
         if (limitToFour && currentCountInDeck >= 4) {
          if (i === 0) { 
            errors.push(`Warning: Limit of 4 copies reached for ${entry.cardNumber}. Could not add all specified copies.`) 
          }
           break
         }
        
         newDeck.push(foundCard)
       }
     }
    
    if (unfoundCardNumbers.length > 0) { 
      errors.push(`Error: The following card numbers were not found: ${unfoundCardNumbers.join(", ")}`) 
    }
    
    if (!potentialLeader) { 
      errors.push("Error: No leader card found in the decklist.") 
    }
    
    if (newDeck.length > 50) { 
      errors.push(`Error: Deck contains ${newDeck.length} cards, exceeding the limit of 50 (excluding leader).`) 
    }
    
    // Only proceed with importing if no critical errors
    if (!errors.some(e => e.startsWith("Error:"))) {
      if (potentialLeader) {
        setLeaderCard(potentialLeader)
      }
    setDeck(newDeck)
       setImportText("")
       setImportDialogOpen(false)
      
      // Log warnings to console instead of showing alert
      if (errors.length > 0) {
        console.warn("Deck imported with warnings:", errors)
      }
    } else {
      // Log errors to console instead of showing alert
      console.error("Could not import deck due to errors:", errors)
     }
  }

  // Fetch saved decks when load dialog opens
  useEffect(() => {
    const fetchSavedDecks = async () => {
      if (!loadDialogOpen || !isLoggedIn) return; // Only fetch if dialog is open and user is logged in

      setLoadingDecks(true);
      setLoadDecksError(null);
      setSavedDecks([]); // Clear previous decks

      try {
        // Assumes backend is secured and returns decks for the current user
        const response = await fetch("http://localhost:8080/api/decks", {
           method: 'GET',
           headers: {
             'Accept': 'application/json',
           },
           credentials: 'include', // Send session cookies
        });

        if (!response.ok) {
           // Handle specific errors like 401 Unauthorized if needed
           if (response.status === 401 || response.status === 403) {
               throw new Error("Authentication required. Please log in.");
           }
           throw new Error(`Failed to fetch decks: ${response.statusText}`);
        }

        const data = await response.json();
        setSavedDecks(data); // Expects an array of DeckDTO-like objects

      } catch (error: any) {
        console.error("Error fetching saved decks:", error);
        setLoadDecksError(error.message || "An unknown error occurred.");
      } finally {
        setLoadingDecks(false);
      }
    };

    fetchSavedDecks();
  }, [loadDialogOpen, isLoggedIn]); // Re-fetch if dialog opens or login state changes

  // Load a selected deck from the backend
  const handleLoadDeck = async (deckId: number) => {
    setLoadingDecks(true); // Indicate loading within the dialog perhaps
    setLoadDecksError(null);
    try {
      const response = await fetch(`http://localhost:8080/api/decks/${deckId}`, {
        method: 'GET',
        headers: { 'Accept': 'application/json' },
        credentials: 'include',
      });

      if (!response.ok) {
        if (response.status === 401 || response.status === 403) {
          throw new Error("Authentication required or forbidden.");
        }
        if (response.status === 404) {
          throw new Error("Deck not found.");
        }
        throw new Error(`Failed to load deck: ${response.statusText}`);
      }

      const loadedDto = await response.json();

      // --- Reconstruct Deck State from DTO ---

      // Find Leader Card
      const loadedLeader = allCards.find(c => c.cardNumber === loadedDto.leaderCardNumber);
      if (!loadedLeader) {
        throw new Error(`Leader card (${loadedDto.leaderCardNumber}) not found in local card data.`);
      }

      // Find Deck Cards
      const newLoadedDeck: CardType[] = [];
      let cardLookupErrors: string[] = [];
      loadedDto.cards.forEach((entry: { cardNumber: string; quantity: number }) => {
        const foundCard = allCards.find(c => c.cardNumber === entry.cardNumber);
        if (foundCard) {
          for (let i = 0; i < entry.quantity; i++) {
            newLoadedDeck.push(foundCard);
          }
        } else {
          if (!cardLookupErrors.includes(entry.cardNumber)) {
             cardLookupErrors.push(entry.cardNumber);
          }
        }
      });

      if (cardLookupErrors.length > 0) {
         console.warn("Could not find the following cards locally when loading deck:", cardLookupErrors.join(", "))
         // Optionally alert the user
      }

      // Set State
      setLeader(loadedLeader);
      setDeck(newLoadedDeck); // This will trigger useEffect to update cardStacks
      setDeckName(loadedDto.name || 'Loaded Deck');
      setSelectedColors(loadedLeader.color.split('/')); // Update color filter based on leader

      setLoadDialogOpen(false); // Close the dialog on success
      alert(`Deck "${loadedDto.name || 'Loaded Deck'}" loaded successfully!`);

    } catch (error: any) {
      console.error("Error loading deck:", error);
      setLoadDecksError(error.message || "An unknown error occurred.");
      // Keep dialog open to show error
    }
    // Don't set loading to false here, let the error display
    // setLoadingDecks(false);
  };

  // --- Calculate Deck Statistics ---

  const costCurveData = useMemo(() => {
    const counts: { [cost: number]: number } = {};
    for (let i = 0; i <= 10; i++) { counts[i] = 0; } // Initialize 0-10+
    deck.forEach(card => {
      const cost = card.cost ?? -1;
      if (cost >= 0 && cost <= 9) {
        counts[cost] = (counts[cost] || 0) + 1;
      } else if (cost >= 10) {
        counts[10] = (counts[10] || 0) + 1;
      }
    });
    return Object.entries(counts).map(([cost, count]) => ({
      name: cost === '10' ? '10+' : cost,
      count
    }));
  }, [deck]);

  const powerCurveData = useMemo(() => {
    const powerBins = { '0': 0, '1000': 0, '2000': 0, '3000': 0, '4000': 0, '5000': 0, '6000': 0, '7000': 0, '8000': 0, '9000': 0, '10000+': 0 };
    deck.forEach(card => {
      const power = card.power;
      if (power === null || power === undefined) return;
      if (power === 0) powerBins['0']++;
      else if (power <= 1000) powerBins['1000']++;
      else if (power <= 2000) powerBins['2000']++;
      else if (power <= 3000) powerBins['3000']++;
      else if (power <= 4000) powerBins['4000']++;
      else if (power <= 5000) powerBins['5000']++;
      else if (power <= 6000) powerBins['6000']++;
      else if (power <= 7000) powerBins['7000']++;
      else if (power <= 8000) powerBins['8000']++;
      else if (power <= 9000) powerBins['9000']++;
      else powerBins['10000+']++;
    });
    return Object.entries(powerBins).map(([bin, count]) => ({ name: bin, count }));
  }, [deck]);

  const attributeData = useMemo(() => {
    const counts: { [attr: string]: number } = {};
    deck.forEach(card => {
      const attr = card.attribute || 'NA';
      counts[attr] = (counts[attr] || 0) + 1;
    });
    return Object.entries(counts).map(([name, count]) => ({ name, count }));
  }, [deck]);

 const typeData = useMemo(() => {
    const counts: { [type: string]: number } = {};
    deck.forEach(card => {
      const affiliations = card.affiliations?.split(/[/,;]/) ?? [];
      affiliations.forEach(type => {
        const trimmedType = type.trim();
        if (trimmedType) {
          counts[trimmedType] = (counts[trimmedType] || 0) + 1;
        }
      });
    });
    return Object.entries(counts).map(([name, count]) => ({ name, count }));
  }, [deck]);

  // --- End Calculate Deck Statistics ---

  // Function to generate deck export text
  const generateDeckExportText = useCallback(() => {
    let exportText = "";
    
    // Add leader
    if (leader) {
      exportText += `1x${leader.cardNumber}\n`;
    }
    
    // Add all other cards, grouped by cardNumber
    const cardCounts: Record<string, number> = {};
    
    deck.forEach(card => {
      if (card.cardNumber) {
        cardCounts[card.cardNumber] = (cardCounts[card.cardNumber] || 0) + 1;
      }
    });
    
    // Sort by card number for consistent output
    const sortedEntries = Object.entries(cardCounts).sort(([a], [b]) => a.localeCompare(b));
    
    // Add each card to export text
    sortedEntries.forEach(([cardNumber, count]) => {
      exportText += `${count}x${cardNumber}\n`;
    });
    
    return exportText;
  }, [leader, deck]);

  return (
    <DndProvider backend={HTML5Backend}>
      {/* Layout component handles Navbar */}

      {/* Main container for two-column layout */}
      <div className="px-4 py-4 sm:px-6 lg:px-8">
        {/* Top Header - Keep Title, maybe remove buttons later if fully moved */}
        <motion.div
          className="flex justify-between items-center mb-4" // Added mb-4
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            transition={{ delay: 0.2, duration: 0.5 }}
          >
            <h1 className="text-2xl font-bold bg-clip-text text-transparent bg-gradient-to-r from-red-600 to-yellow-500">
              One Piece Card Game Deckbuilder
            </h1>
          {/* Removed Action Buttons from here */}
        </motion.div>

        {/* Grid for main content */}
        <div className="grid grid-cols-1 lg:grid-cols-5 gap-6"> 

          {/* Left Column: Card Browser */}
          <div className="lg:col-span-3">
            {/* Card Browser Section (Restored) */}
            <motion.div
              initial={{ opacity: 0, x: -20 }}
              animate={{ opacity: 1, x: 0 }}
              transition={{ delay: 0.4, duration: 0.5 }}
            >
              <Card className="border border-gray-200 dark:border-gray-700 shadow-lg hover:shadow-xl transition-shadow bg-card">
                <CardHeader className="pb-2">
                   {/* ... Card Browser Header Content (Title, Filters, Leader Filter Display) ... */} 
                    <div className="flex flex-col sm:flex-row justify-between items-start sm:items-center gap-4">
                        <CardTitle>Card Browser</CardTitle>
                        {/* Filter Controls Area */}
                        <div className="flex flex-col sm:flex-row items-stretch sm:items-center gap-2 w-full sm:w-auto">
                            {/* Search Input */}
                            <div className="relative flex-1 sm:flex-initial sm:w-[250px]">
                            <Search className="absolute left-2.5 top-1/2 transform -translate-y-1/2 h-4 w-4 text-gray-400" />
                    <Input
                                placeholder="Search by name..."
                                value={searchTerm}
                                onChange={(e) => setSearchTerm(e.target.value)}
                                className="pl-8 w-full"
                    />
                  </div>
                            {/* Filter Dropdown */}
                            <DropdownMenu>
                            <DropdownMenuTrigger asChild>
                                <Button variant="outline" className="w-full sm:w-auto justify-center">
                                <Filter className="h-4 w-4 mr-2" /> Filters
                    </Button>
                            </DropdownMenuTrigger>
                            <DropdownMenuContent align="end" className="w-72 max-h-[80vh] overflow-y-auto">
                                <ScrollArea className="p-0">
                                    <div className="p-2">
                                    {/* ... Filters Content ... */}
                                     <div className="flex justify-between items-center mb-2">
                                        <h3 className="font-medium">Filters</h3>
                                        <Button variant="ghost" size="sm" onClick={resetFilters} className="text-xs">
                                        Reset All
                                        </Button>
                                    </div>
                                    {/* Color Filter */}
                                    <div className="mb-3">
                                      <h4 className="text-sm font-medium mb-1">Color</h4>
                                      <div className="flex flex-wrap gap-1 mb-2">
                                        {availableColors.map(color => (
                                          <Badge
                                            key={color}
                                            variant={selectedColors.includes(color) ? "default" : "outline"}
                                            className={`filter-badge cursor-pointer select-none ${
                                              selectedColors.includes(color) 
                                                ? "bg-primary hover:bg-primary/80 text-primary-foreground dark:bg-primary dark:text-primary-foreground" 
                                                : "bg-background hover:bg-secondary/80 border-border dark:bg-secondary dark:text-secondary-foreground"
                                            }`}
                                            onClick={() => toggleColorFilter(color)}
                                          >
                                            {color}
                                          </Badge>
                                        ))}
                                      </div>
                                    </div>
                                    {/* Cost Filter */}
                                    <div className="mb-3">
                                      <h4 className="text-sm font-medium mb-1">Cost</h4>
                                      <div className="flex flex-wrap gap-1 mb-2">
                                        {availableCosts.map(cost => (
                                          <Badge
                                            key={cost}
                                            variant={selectedCosts.includes(cost) ? "default" : "outline"}
                                            className={`filter-badge cursor-pointer select-none ${
                                              selectedCosts.includes(cost) 
                                                ? "bg-primary hover:bg-primary/80 text-primary-foreground dark:bg-primary dark:text-primary-foreground" 
                                                : "bg-background hover:bg-secondary/80 border-border dark:bg-secondary dark:text-secondary-foreground"
                                            }`}
                                            onClick={() => toggleCostFilter(cost)}
                                          >
                                            {cost}
                                          </Badge>
                                        ))}
                                      </div>
                                    </div>
                                    {/* Type Filter */}
                                    <div className="mb-3">
                                      <h4 className="text-sm font-medium mb-1">Card Type</h4>
                                      <div className="flex flex-wrap gap-1">
                                        {availableTypes.map(type => (
                                          <Button
                                            key={type}
                                            variant={selectedTypes.includes(type) ? "default" : "outline"}
                                            size="sm"
                                            className="capitalize h-7 px-2 text-xs"
                                            onClick={() => toggleTypeFilter(type)}
                                          >
                                            {type}
                                          </Button>
                                        ))}
                                      </div>
                                    </div>
                                    {/* Set Filter */}
                                    <div className="mb-3">
                                      <h4 className="text-sm font-medium mb-1">Set</h4>
                                      <div className="flex flex-wrap gap-1">
                                        {availableSets.map(set => (
                                          <Button
                                            key={set}
                                            variant={selectedSets.includes(set) ? "default" : "outline"}
                                            size="sm"
                                            className="h-7 px-2 text-xs"
                                            onClick={() => toggleSetFilter(set)}
                                          >
                                            {set}
                                          </Button>
                                        ))}
                                      </div>
                                    </div>
                                    {/* Deck Rules */}
                                    <div className="mt-4 border-t pt-3 flex items-center space-x-2">
                                      <Checkbox
                                        id="limit-four"
                                        checked={limitToFour}
                                        onCheckedChange={(checked) => setLimitToFour(Boolean(checked))}
                                      />
                                      <Label htmlFor="limit-four" className="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70">
                                        Limit 4 copies per card
                                      </Label>
                                    </div>
                                    </div>
                                </ScrollArea>
                            </DropdownMenuContent>
                            </DropdownMenu>
                        </div>
                        {/* Display Active Leader Filters (Restored Here) */}
                        {leader && (selectedColors.length > 0 || selectedAffiliations.length > 0) && (
                             <div className="flex flex-wrap items-center gap-2 mt-2 border-t pt-2 w-full"> {/* Added w-full */} 
                                <span className="text-xs font-medium text-gray-600 mr-1">Leader Filters:</span>
                                {selectedColors.map(color => (
                                    <Badge key={`lcol-${color}`} variant="outline" className={`${colorClasses[color]} border-opacity-50 text-xs capitalize`}>{color}</Badge>
                                ))}
                                {selectedAffiliations.map(aff => (
                                    <Badge key={`laff-${aff}`} variant="secondary" className="text-xs font-normal">{aff}</Badge>
                                ))}
                                <Button variant="ghost" size="sm" onClick={clearLeaderFilters} className="text-xs h-auto px-1 py-0.5 text-red-600 hover:bg-red-50 ml-auto"> {/* Added ml-auto */} 
                                    <X className="h-3 w-3 mr-1"/> Clear
                                </Button>
                            </div>
                        )}
                    </div>
                </CardHeader>
                <CardContent>
                    {/* Active Filters Display */}
                    {(selectedColors.length > 0 || selectedCosts.length > 0 || selectedTypes.length > 0 || selectedSets.length > 0 || selectedAffiliations.length > 0) && (
                        <div className="mb-4 flex flex-wrap items-center gap-2">
                            <span className="text-xs font-medium text-gray-600">Filters:</span>
                            {selectedColors.map(color => (
                                <Badge 
                                    key={`filter-color-${color}`} 
                                    variant="secondary" 
                                    className={`${colorClasses[color.toLowerCase()]} cursor-pointer flex items-center gap-1`}
                                    onClick={() => toggleColorFilter(color)}
                                >
                                    {color}
                                    <X className="h-3 w-3 ml-1" />
                                </Badge>
                            ))}
                            {selectedCosts.map(cost => (
                                <Badge 
                                    key={`filter-cost-${cost}`} 
                                    variant="secondary" 
                                    className="cursor-pointer flex items-center gap-1"
                                    onClick={() => toggleCostFilter(cost)}
                                >
                                    Cost: {cost}
                                    <X className="h-3 w-3 ml-1" />
                                </Badge>
                            ))}
                            {selectedTypes.map(type => (
                                <Badge 
                                    key={`filter-type-${type}`} 
                                    variant="secondary" 
                                    className="cursor-pointer flex items-center gap-1"
                                    onClick={() => toggleTypeFilter(type)}
                                >
                                    {type}
                                    <X className="h-3 w-3 ml-1" />
                                </Badge>
                            ))}
                            {selectedSets.map(set => (
                                <Badge 
                                    key={`filter-set-${set}`} 
                                    variant="secondary" 
                                    className="cursor-pointer flex items-center gap-1"
                                    onClick={() => toggleSetFilter(set)}
                                >
                                    {set}
                                    <X className="h-3 w-3 ml-1" />
                                </Badge>
                            ))}
                            {selectedAffiliations.map(aff => (
                                <Badge 
                                    key={`filter-aff-${aff}`} 
                                    variant="secondary" 
                                    className="cursor-pointer flex items-center gap-1"
                                    onClick={() => {
                                        setSelectedAffiliations(prev => prev.filter(a => a !== aff));
                                    }}
                                >
                                    {aff}
                                    <X className="h-3 w-3 ml-1" />
                                </Badge>
                            ))}
                            <Button 
                                variant="outline"
                                size="sm" 
                                className="text-xs font-medium text-red-600 h-6 px-2 py-0"
                                onClick={resetFilters}
                            >
                                Clear
                            </Button>
                        </div>
                    )}
                    <Tabs value={cardBrowserTab} onValueChange={(value) => {
                      setCardBrowserTab(value);
                      setDeckViewTab(value === "all" ? "deck" : "leader");
                    }}>
                    <TabsList className="mb-4">
                        <TabsTrigger value="all">All Cards</TabsTrigger>
                        <TabsTrigger value="leaders">Leader Cards</TabsTrigger>
                    </TabsList>
                    <TabsContent value="all">
                        <CardBrowserDropZone removeCardFromDeck={removeCardFromDeck}>
                        <ScrollArea className="h-[calc(100vh-250px)]">
                            <div className="grid grid-cols-3 sm:grid-cols-4 md:grid-cols-5 lg:grid-cols-6 xl:grid-cols-7 gap-2">
                            {visibleCards.map((card: CardType) => (
                                <motion.div
                                key={card.id}
                                // ... motion props ...
                                >
                                <DraggableCardSource card={card} addCardToDeck={addCardToDeck}>
                                    {/* Restored card image div as children */}
                                     <div
                                        className="relative group cursor-pointer hover:opacity-90 transition-all"
                                        onClick={() => addCardToDeck(card)}
                                    >
                                        <img
                                        key={card.id}
                                        loading="lazy"
                                        src={card.imagePath}
                                        alt={card.name}
                                        className="rounded-lg border border-gray-200 dark:border-gray-700 w-full h-auto shadow-md hover:shadow-lg transition-shadow"
                                        />
                                    </div>
                                </DraggableCardSource>
                                </motion.div>
                            ))}
                            
                            {/* Load more indicator */}
                            {visibleCards.length < filteredCards.length && (
                              <div 
                                ref={cardsLoadMoreRef}
                                className="flex justify-center py-4 mt-2"
                              >
                                <div className="animate-pulse text-sm text-gray-500">
                                  Loading more cards... ({visibleCards.length} of {filteredCards.length})
                                </div>
                              </div>
                            )}
                            </div>
                        </ScrollArea>
                        </CardBrowserDropZone>
                    </TabsContent>
                    <TabsContent value="leaders">
                         <ScrollArea className="h-[calc(100vh-250px)]">
                           <div className="grid grid-cols-3 sm:grid-cols-4 md:grid-cols-5 lg:grid-cols-6 xl:grid-cols-7 gap-2">
                               {visibleLeaderCards.length > 0 ? (
                                 visibleLeaderCards.map((card: CardType) => (
                                  <motion.div
                                    key={card.id}
                                     // ... motion props ...
                                  >
                                     <DraggableLeaderSource card={card} setLeaderCard={setLeaderCard}>
                                         {/* Restored card image div as children */}
                                         <div
                                             className="relative group cursor-pointer hover:opacity-90 transition-all"
                                             onClick={() => setLeaderCard(card)}
                                         >
                                             <img
                                             key={card.id}
                                             loading="lazy"
                                             src={card.imagePath}
                                             alt={card.name}
                                             className="rounded-lg border border-gray-200 dark:border-gray-700 w-full h-auto shadow-md hover:shadow-lg transition-shadow"
                                             />
                                         </div>
                                     </DraggableLeaderSource>
                                   </motion.div>
                                ))
                               ) : (
                                <p className="col-span-full text-center text-gray-500 py-8">No leader cards found matching filters.</p>
                               )}
                               
                               {/* Load more indicator for leaders - use separate ref */}
                               {visibleLeaderCards.length > 0 && visibleLeaderCards.length < filteredLeaderCards.length && (
                                 <div 
                                   ref={leaderCardsLoadMoreRef}
                                   className="flex justify-center py-4 mt-2"
                                 >
                                   <div className="animate-pulse text-sm text-gray-500">
                                     Loading more leader cards... ({visibleLeaderCards.length} of {filteredLeaderCards.length})
                                   </div>
                                 </div>
                               )}
                           </div>
                         </ScrollArea>
                    </TabsContent>
                    </Tabs>
                </CardContent>
              </Card>
            </motion.div>
          </div>

          {/* Right Column: Deck View, Stats, Actions (Restored) */}
          <div className="lg:col-span-2 flex flex-col gap-6">
            {/* Action Buttons Moved Here */}
             <motion.div
                initial={{ opacity: 0, y: -20 }}
                animate={{ opacity: 1, y: 0 }}
                transition={{ delay: 0.25, duration: 0.5 }}
             >
                 <Card className="p-2 bg-card border border-gray-200 dark:border-gray-700 shadow-sm">
                     <div className="flex flex-wrap items-center justify-center gap-2">
                         {/* Load Decks Button (Conditional) */}
                         {isLoggedIn && (
                            <Dialog open={loadDialogOpen} onOpenChange={setLoadDialogOpen}>
                              <DialogTrigger asChild>
                                <Button variant="outline" size="sm" className="flex items-center gap-1 hover:bg-purple-50 transition-colors">
                                  <Library className="h-4 w-4" /> Load
                                </Button>
                              </DialogTrigger>
                              {/* --- Load DialogContent --- */}
                              <DialogContent className="sm:max-w-[625px]">
                                <DialogHeader>
                                  <DialogTitle>Load Deck</DialogTitle>
                                  <DialogDescription>Select a previously saved deck to load.</DialogDescription>
                                </DialogHeader>
                                <div className="py-4 min-h-[300px] max-h-[60vh] overflow-y-auto">
                                  {loadingDecks ? (
                                    <p>Loading decks...</p>
                                  ) : loadDecksError ? (
                                    <p className="text-red-600">Error: {loadDecksError}</p>
                                  ) : savedDecks.length === 0 ? (
                                    <p>No saved decks found.</p>
                                  ) : (
                                    <ul className="space-y-2">
                                      {savedDecks.map((deck) => (
                                        <li key={deck.id} className="flex justify-between items-center p-2 border rounded hover:bg-gray-50 dark:hover:bg-gray-800 dark:border-gray-700">
                                          <span>{deck.name} (Leader: {deck.leaderCardNumber})</span>
                                          <Button size="sm" onClick={() => handleLoadDeck(deck.id)}>Load</Button>
                                        </li>
                                      ))}
                                    </ul>
                                  )}
                                </div>
                                {/* Optional Footer if needed */}
                                <DialogFooter>
                                  <Button variant="outline" onClick={() => setLoadDialogOpen(false)}>Close</Button>
                                </DialogFooter>
                              </DialogContent>
                              {/* --- End Load DialogContent --- */}
                            </Dialog>
                          )}
                          {/* Save Deck Button */}
                          <Dialog open={saveDialogOpen} onOpenChange={setSaveDialogOpen}>
                             <DialogTrigger asChild>
                               <Button 
                                 variant="outline" 
                                 size="sm" 
                                 className="flex items-center gap-1 hover:bg-red-50 transition-colors" 
                                 disabled={!leader}
                                 onClick={(e) => {
                                   // Prevent the DialogTrigger from automatically opening the dialog
                                   e.preventDefault();
                                   if (!isLoggedIn) {
                                     // Show auth dialog for non-logged in users
                                     setAuthDialogOpen(true);
                                   } else {
                                     // Show save dialog for logged in users
                                     setSaveDialogOpen(true);
                                   }
                                 }}
                               >
                                 <Save className="h-4 w-4" /> Save
                               </Button>
                             </DialogTrigger>
                             {/* --- Save DialogContent --- */}
                             <DialogContent className="sm:max-w-[425px]">
                                <DialogHeader>
                                <DialogTitle>Save Deck</DialogTitle>
                                <DialogDescription>
                                    Enter a name for your deck. The current leader and cards will be saved.
                                </DialogDescription>
                                </DialogHeader>
                                <div className="grid gap-4 py-4">
                                <div className="grid grid-cols-4 items-center gap-4">
                                    <Label htmlFor="deck-name" className="text-right">
                                    Name
                                    </Label>
                                    <Input
                                    id="deck-name"
                                    value={deckName}
                                    onChange={(e) => setDeckName(e.target.value)}
                                    className="col-span-3"
                                    />
                                </div>
                                {/* Display Leader Info */}
                                {leader && (
                                    <div className="grid grid-cols-4 items-center gap-4">
                                    <Label className="text-right">Leader</Label>
                                    <div className="col-span-3 flex items-center gap-2">
                                        <img src={leader.imagePath} alt={leader.name} className="h-10 w-auto rounded border"/>
                                        <span>{leader.name} ({leader.cardNumber})</span>
                                    </div>
                                    </div>
                                )}
                                </div>
                                <DialogFooter>
                                <Button type="button" onClick={saveDeck} disabled={!deckName.trim() || !leader}>Save Deck</Button>
                                <Button variant="outline" onClick={() => setSaveDialogOpen(false)}>Cancel</Button>
                                </DialogFooter>
                            </DialogContent>
                             {/* --- End Save DialogContent --- */}
                          </Dialog>
                          {/* Import Deck Button */}
                          <Dialog open={importDialogOpen} onOpenChange={setImportDialogOpen}>
                             <DialogTrigger asChild>
                               <Button variant="outline" size="sm" className="flex items-center gap-1 hover:bg-blue-50 transition-colors">
                                 <FileInput className="h-4 w-4" /> Import
                               </Button>
                             </DialogTrigger>
                             {/* --- Import DialogContent --- */}
                             <DialogContent className="sm:max-w-[525px]">
                                <DialogHeader>
                                <DialogTitle>Import Decklist</DialogTitle>
                                <DialogDescription>
                                    Paste your decklist below. Use the format "QuantityxCardID" per line (e.g., 4xST01-001). Leader should be included.
                                </DialogDescription>
                                </DialogHeader>
                                <div className="py-4">
                                <Textarea
                                    placeholder="Paste decklist here...
Example:
1xOP01-001
4xST01-013
..."
                                    value={importText}
                                    onChange={(e) => setImportText(e.target.value)}
                                    className="min-h-[250px]"
                                />
                                </div>
                                <DialogFooter>
                                <Button type="button" onClick={handleImportDeck}>Import Deck</Button>
                                <Button variant="outline" onClick={() => setImportDialogOpen(false)}>Cancel</Button>
                                </DialogFooter>
                            </DialogContent>
                            {/* --- End Import DialogContent --- */}
                           </Dialog>
                          {/* Test Hand Button */}
                          <Button variant="outline" size="sm" className="flex items-center gap-1 hover:bg-green-50 transition-colors" onClick={handleTestHand} disabled={!leader || deck.length < 5}>
                             <Play className="h-4 w-4" /> Test Hand
                          </Button>
                         {/* Clear Deck Button */}
                         <Button variant="destructive" size="sm" className="flex items-center gap-1" onClick={clearDeck} disabled={deck.length === 0 && !leader}>
                           <Trash2 className="h-4 w-4" /> Clear
              </Button>
              {/* Export Deck Button */}
              <Dialog open={exportDialogOpen} onOpenChange={setExportDialogOpen}>
                <DialogTrigger asChild>
                  <Button 
                    variant="outline" 
                    size="sm" 
                    className="flex items-center gap-1 hover:bg-green-50 transition-colors"
                  >
                    <Upload className="h-4 w-4" /> Export
                  </Button>
                </DialogTrigger>
                <DialogContent className="sm:max-w-[425px]">
                  <DialogHeader>
                    <DialogTitle>Export Deck</DialogTitle>
                    <DialogDescription>
                      Copy this deck list to share or import later.
                    </DialogDescription>
                  </DialogHeader>
                  <div className="py-4">
                    <div className="flex justify-between items-center mb-2">
                      <span className="text-sm font-medium">
                        {leader ? leader.name : "No Leader"} - {deck.length} cards
                      </span>
                      <Button 
                        variant="ghost" 
                        size="sm" 
                        className="text-xs"
                        onClick={() => {
                          // Generate text list
                          let exportText = "";
                          
                          // Add leader
                          if (leader) {
                            exportText += `1x${leader.cardNumber}\n`;
                          }
                          
                          // Add all other cards, grouped by cardNumber
                          const cardCounts: Record<string, number> = {};
                          
                          deck.forEach(card => {
                            if (card.cardNumber) {
                              cardCounts[card.cardNumber] = (cardCounts[card.cardNumber] || 0) + 1;
                            }
                          });
                          
                          // Sort by card number for consistent output
                          const sortedEntries = Object.entries(cardCounts).sort(([a], [b]) => a.localeCompare(b));
                          
                          // Add each card to export text
                          sortedEntries.forEach(([cardNumber, count]) => {
                            exportText += `${count}x${cardNumber}\n`;
                          });
                          
                          navigator.clipboard.writeText(exportText);
                          alert("Deck list copied to clipboard!");
                        }}
                      >
                        Copy to Clipboard
              </Button>
                    </div>
                    <Textarea
                      value={(() => {
                        // Generate text list inside the component
                        let exportText = "";
                          
                        // Add leader
                        if (leader) {
                          exportText += `1x${leader.cardNumber}\n`;
                        }
                        
                        // Add all other cards, grouped by cardNumber
                        const cardCounts: Record<string, number> = {};
                        
                        deck.forEach(card => {
                          if (card.cardNumber) {
                            cardCounts[card.cardNumber] = (cardCounts[card.cardNumber] || 0) + 1;
                          }
                        });
                        
                        // Sort by card number for consistent output
                        const sortedEntries = Object.entries(cardCounts).sort(([a], [b]) => a.localeCompare(b));
                        
                        // Add each card to export text
                        sortedEntries.forEach(([cardNumber, count]) => {
                          exportText += `${count}x${cardNumber}\n`;
                        });
                        
                        return exportText;
                      })()}
                      readOnly
                      className="min-h-[250px] font-mono text-sm"
                    />
                  </div>
                  <DialogFooter>
                    <Button variant="outline" onClick={() => setExportDialogOpen(false)}>Close</Button>
                  </DialogFooter>
                </DialogContent>
              </Dialog>
            </div>
                 </Card>
          </motion.div>

            {/* Deck Section (Full Restore) */}
          <motion.div
              initial={{ opacity: 0, x: 20 }}
              animate={{ opacity: 1, x: 0 }}
            transition={{ delay: 0.3, duration: 0.5 }}
          >
            <Card className="border border-gray-200 dark:border-gray-700 shadow-lg hover:shadow-xl transition-shadow bg-card">
              <CardHeader className="pb-2">
                    <div className="flex justify-between items-start">
                  <CardTitle>Your Deck ({deck.length}/51)</CardTitle>
                      {leader ? (
                        <img
                          key={leader.id}
                          loading="lazy"
                          src={leader.imagePath}
                          alt={leader.name}
                          className="h-32 w-auto rounded border border-gray-300 shadow-sm"
                        />
                      ) : (
                  <Badge variant="outline" className="animate-pulse">
                          No Leader Selected
                  </Badge>
                      )}
                </div>
                <CardDescription>
                  Drag and drop cards to rearrange. Select a leader card from the leader tab below.
                </CardDescription>
              </CardHeader>
              <CardContent>
                <Tabs value={deckViewTab} onValueChange={(value) => {
                  setDeckViewTab(value);
                  setCardBrowserTab(value === "deck" ? "all" : "leaders");
                }}>
                  <TabsList className="mb-4">
                    <TabsTrigger value="deck">Deck Cards</TabsTrigger>
                    <TabsTrigger value="leader">Leader</TabsTrigger>
                  </TabsList>
                  <TabsContent value="deck" className="min-h-[200px]">
                    {deck.length === 0 ? (
                      <DeckDropZone addCardToDeck={addCardToDeck}>
                        <motion.div
                          className="flex flex-col items-center justify-center h-[250px] text-gray-500 border-2 border-dashed border-gray-300 rounded-lg"
                                // ... animation props ...
                        >
                          <p>Your deck is empty. Drag cards here or click on cards below to add them.</p>
                        </motion.div>
                      </DeckDropZone>
                    ) : (
                      <DeckDropZone addCardToDeck={addCardToDeck}>
                                <ScrollArea className="h-[300px]">
                                <div className="grid grid-cols-4 sm:grid-cols-5 md:grid-cols-6 lg:grid-cols-7 xl:grid-cols-8 gap-4"> {/* Adjusted columns for smaller space */}
                              {cardStacks.map((stack, index) => (
                                <motion.div
                                  key={`stack-${stack.id}-${index}`}
                                  initial={{ opacity: 0, scale: 0.8 }}
                                  animate={{ opacity: 1, scale: 1 }}
                                  exit={{ opacity: 0, scale: 0.8 }}
                                  transition={{ duration: 0.2 }}
                                >
                                        <MemoizedCardStack
                                    stack={stack}
                                    index={index}
                                    moveCardStack={moveCardStack}
                                    removeCardFromDeck={removeCardFromDeck}
                                    colorClasses={colorClasses}
                                    isHighlighted={lastAction?.type === "add" && lastAction.cardId === stack.id}
                                  />
                                </motion.div>
                              ))}
                          </div>
                        </ScrollArea>
                      </DeckDropZone>
                    )}
                  </TabsContent>
                  <TabsContent value="leader" className="min-h-[200px]">
                    {leader ? (
                      <div className="flex flex-col items-center">
                        <LeaderDropZone leader={leader} setLeader={setLeaderCard} removeLeader={removeLeader}>
                          <motion.div
                            className="relative group w-[120px]"
                            transition={{ type: "spring", stiffness: 400, damping: 10 }}
                          >
                            <img
                                    loading="lazy"
                              src={leader.imagePath}
                              alt={leader.name}
                                    className="h-32 w-auto rounded shadow-sm border border-gray-200"
                                    />
                                     <Button variant="destructive" size="icon" className="absolute top-1 right-1 h-5 w-5 opacity-0 group-hover:opacity-100 transition-opacity" onClick={removeLeader}>
                              <X className="h-3 w-3" />
                            </Button>
                                    <div className={`absolute bottom-0 left-0 right-0 text-xs p-1 ${colorClasses[leader.color as keyof typeof colorClasses]} rounded-b-lg text-center truncate`}>
                              {leader.name}
                            </div>
                          </motion.div>
                        </LeaderDropZone>
                        <p className="mt-2 text-sm text-gray-500">Your deck leader</p>
                      </div>
                    ) : (
                      <LeaderDropZone setLeader={setLeaderCard}>
                        <motion.div
                          className="flex flex-col items-center justify-center h-[200px] text-gray-500 border-2 border-dashed border-gray-300 rounded-lg"
                                // ... animation props ...
                        >
                          <p>
                            No leader selected. Drag a leader card here or click on a leader card below to select it.
                          </p>
                        </motion.div>
                      </LeaderDropZone>
                    )}
                  </TabsContent>
                </Tabs>
              </CardContent>
            </Card>
          </motion.div>

            {/* Deck Stats Section (Restored) */}
            {(deck.length > 0 || leader) && (
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
                transition={{ delay: 0.35, duration: 0.5 }}
              >
                <DeckStats
                  costCurveData={costCurveData}
                  powerCurveData={powerCurveData}
                  attributeData={attributeData}
                  typeData={typeData}
                />
              </motion.div>
            )}
                    </div>

                                </div>
                              </div>

      {/* Test Hand Dialog - Remains outside the main layout grid */}
      <Dialog open={testHandDialogOpen} onOpenChange={setTestHandDialogOpen}>
        <DialogContent className="sm:max-w-xl bg-card">
          <DialogHeader>
            <DialogTitle>Test Starting Hand</DialogTitle>
          </DialogHeader>
          <div className="py-4">
            <div className="flex flex-col items-center gap-4">
              {/* Leader Card */}
              {leader && (
                <div>
                  <h3 className="text-sm font-medium text-center mb-1">Leader</h3>
                  <img
                    key={leader.id}
                    loading="lazy"
                    src={leader.imagePath}
                    alt={leader.name}
                    className="h-40 w-auto rounded shadow-md border border-gray-200 dark:border-gray-700"
                  />
                                    </div>
              )}
              {/* Hand Cards */}
              <div className="flex flex-wrap justify-center gap-2">
                 <h3 className="text-sm font-medium text-center w-full mb-1">Hand</h3>
                 {testHandCards.map((card, index) => (
                  <img
                    key={`${card.id}-${index}`}
                    loading="lazy"
                    src={card.imagePath}
                    alt={card.name}
                    className="h-32 w-auto rounded shadow-sm border border-gray-200 dark:border-gray-700"
                  />
                ))}
                        </div>
                                    </div>
                                  </div>
          <DialogFooter>
            <Button onClick={handleTestHand}>Draw Again</Button>
            <Button variant="outline" onClick={() => setTestHandDialogOpen(false)}>
              Close
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>

      {/* Add the authentication dialog component */}
      <Dialog open={authDialogOpen} onOpenChange={setAuthDialogOpen}>
        <DialogContent className="sm:max-w-[425px] bg-card">
          <DialogHeader>
            <DialogTitle>Authentication Required</DialogTitle>
            <DialogDescription>
              You need to be logged in to save decks. Please login or register to continue.
            </DialogDescription>
          </DialogHeader>
          <div className="flex flex-col gap-4 py-4">
            <p className="text-sm text-gray-600">
              Saving decks allows you to access them later from any device.
            </p>
            <div className="flex justify-center gap-4">
              <Button onClick={() => {
                setAuthDialogOpen(false);
                window.location.href = '/login?redirect=/deck-builder';
              }}>
                Login
              </Button>
              <Button variant="outline" onClick={() => {
                setAuthDialogOpen(false);
                window.location.href = '/register?redirect=/deck-builder';
              }}>
                Register
              </Button>
            </div>
          </div>
          <DialogFooter>
            <Button variant="ghost" onClick={() => setAuthDialogOpen(false)}>Cancel</Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>
    </DndProvider>
  )
}

// Deck Drop Zone
const DeckDropZone = React.memo(function DeckDropZone({
  children,
  addCardToDeck,
}: {
  children: React.ReactNode
  addCardToDeck: (card: CardType) => void
}) {
  const [{ isOver, canDrop }, drop] = useDrop({
    accept: "CARD_SOURCE",
    drop: (item: { card: CardType }) => {
      addCardToDeck(item.card)
    },
    collect: (monitor) => ({
      isOver: monitor.isOver(),
      canDrop: monitor.canDrop(),
    }),
  })

  const isActive = isOver && canDrop

  return (
    <div ref={drop} className={`${isActive ? "bg-blue-50" : ""} rounded-lg transition-colors`}>
      {children}
    </div>
  )
})

// Card Stack Component (for solitaire-like stacking)
const MemoizedCardStack = React.memo(function CardStack({
  stack,
  index,
  moveCardStack,
  removeCardFromDeck,
  colorClasses,
  isHighlighted = false,
}: {
  stack: CardStackGroup
  index: number
  moveCardStack: (dragIndex: number, hoverIndex: number) => void
  removeCardFromDeck: (cardId: number, index?: number) => void
  colorClasses: Record<string, string>
  isHighlighted?: boolean
}) {
  const elementRef = useRef<HTMLDivElement>(null)
  const card = stack.cards[0] // Use the first card for display properties
  const topCardIndex = stack.cards.length - 1
  const topCard = stack.cards[topCardIndex]

  const [{ isDragging }, drag] = useDrag({
    type: "CARD_STACK",
    item: { index },
    collect: (monitor) => ({
      isDragging: monitor.isDragging(),
    }),
  })

  const [{ isDraggingCard }, dragCard] = useDrag({
    type: "DECK_CARD",
    item: { card: topCard, index: topCardIndex, stackId: stack.id },
    collect: (monitor) => ({
      isDraggingCard: monitor.isDragging(),
    }),
  })

  const [, drop] = useDrop({
    accept: "CARD_STACK",
    hover(item: { index: number }, monitor) {
      if (!elementRef.current) return
      const dragIndex = item.index
      const hoverIndex = index
      if (dragIndex === hoverIndex) return
      moveCardStack(dragIndex, hoverIndex)
      item.index = hoverIndex
    },
  })

  drag(drop(elementRef))

  const handleCardClick = useCallback(() => {
    removeCardFromDeck(topCard.id, topCardIndex)
  }, [removeCardFromDeck, topCard?.id, topCardIndex])

  return (
    <motion.div
      ref={elementRef}
      className={`relative group ${isDragging ? "opacity-50" : "opacity-100"}`}
      style={{ cursor: "move" }}
      animate={
        isHighlighted
          ? {
              boxShadow: [
                "0px 0px 0px rgba(0,0,0,0)",
                "0px 0px 10px rgba(59, 130, 246, 0.7)",
                "0px 0px 0px rgba(0,0,0,0)",
              ],
            }
          : {}
      }
      transition={{ duration: 0.5 }}
    >
      <div className="relative w-full">
        {stack.cards.map((stackCard, cardIndex) => {
          const isTopCard = cardIndex === stack.cards.length - 1
          const offset = cardIndex * 6 // 6px offset for each card

          return (
            <motion.div
              key={`card-${stackCard.id}-${cardIndex}`}
              className="absolute"
              style={{
                top: `${offset}px`,
                left: `${offset}px`,
                zIndex: cardIndex,
                width: "100%",
              }}
              initial={isTopCard && isHighlighted ? { scale: 1.1 } : { scale: 1 }}
              animate={isTopCard && isHighlighted ? { scale: 1 } : { scale: 1 }}
              transition={{ type: "spring", stiffness: 500, damping: 15 }}
            >
              <div
                className={`relative group ${isTopCard ? "cursor-pointer hover:opacity-80 transition-opacity" : ""}`}
                onClick={isTopCard ? handleCardClick : undefined}
                ref={(node) => { if(isTopCard) dragCard(node); }}
              >
                <img
                  loading="lazy"
                  src={stackCard.imagePath}
                  alt={stackCard.name}
                  className={`rounded-lg border border-gray-200 dark:border-gray-700 w-full h-auto shadow-sm ${isTopCard ? "" : "opacity-95"}`}
                />

                {/* Counter Badge - Positioned relative to the top card's image container */}
                {isTopCard && stack.cards.length >= 2 && (
                  <Badge
                    variant="destructive"
                    className="absolute top-1 right-1 z-20 px-1.5 py-0.5 text-xs rounded-full pointer-events-none"
                  >
                    {stack.cards.length}
                  </Badge>
                )}

                {/* Only show remove button on the top card */}
                {isTopCard && (
                  <Button
                    variant="destructive"
                    size="icon"
                    className="absolute top-1 right-1 h-5 w-5 opacity-0 group-hover:opacity-100 transition-opacity"
                    onClick={(e) => {
                      e.stopPropagation() // Prevent the card click from triggering
                      removeCardFromDeck(stackCard.id, cardIndex)
                    }}
                  >
                    <X className="h-3 w-3" />
                  </Button>
                )}

                {/* Only show the name on the top card */}
                {isTopCard && (
                  <div
                    className={`absolute bottom-0 left-0 right-0 text-[10px] p-0.5 ${colorClasses[card.color.split('/')[0].toLowerCase() as keyof typeof colorClasses] || colorClasses.black} rounded-b-lg text-center truncate`}
                  >
                    {stackCard.name}
                  </div>
                )}
              </div>
            </motion.div>
          )
        })}

        {/* This is a spacer div to maintain the height of the stack container */}
        <div
          className="invisible"
          style={{
            height: `${140 + (stack.cards.length > 0 ? (stack.cards.length - 1) * 6 : 0)}px`, 
          }}
        />
      </div>
    </motion.div>
  )
})

// Draggable Card Source (for card browser)
const DraggableCardSource = React.memo(function DraggableCardSource({
  card,
  addCardToDeck,
  children,
}: {
  card: CardType
  addCardToDeck: (card: CardType) => void
  children: React.ReactNode
}) {
  const [{ isDragging }, drag] = useDrag({
    type: "CARD_SOURCE",
    item: { card },
    end: (item, monitor) => {
      const dropResult = monitor.getDropResult<{ addCard: boolean }>()
      if (item && dropResult && dropResult.addCard) {
        addCardToDeck(card)
      }
    },
    collect: (monitor) => ({
      isDragging: monitor.isDragging(),
    }),
  })

  return (
    <div ref={drag} className={isDragging ? "opacity-50" : "opacity-100"} style={{ cursor: "grab" }}>
      {children}
    </div>
  )
})

// Draggable Leader Source
const DraggableLeaderSource = React.memo(function DraggableLeaderSource({
  card,
  setLeaderCard,
  children,
}: {
  card: CardType
  setLeaderCard: (card: CardType) => void
  children: React.ReactNode
}) {
  const [{ isDragging }, drag] = useDrag({
    type: "LEADER",
    item: { card },
    end: (item, monitor) => {
      const dropResult = monitor.getDropResult<{ setLeader: boolean }>()
      if (item && dropResult && dropResult.setLeader) {
        setLeaderCard(card)
      }
    },
    collect: (monitor) => ({
      isDragging: monitor.isDragging(),
    }),
  })

  return (
    <div ref={drag} className={isDragging ? "opacity-50" : "opacity-100"} style={{ cursor: "grab" }}>
      {children}
    </div>
  )
})

// Leader Drop Zone
const LeaderDropZone = React.memo(function LeaderDropZone({
  children,
  leader = null,
  setLeader,
  removeLeader = () => {},
}: {
  children: React.ReactNode
  leader?: CardType | null
  setLeader: (card: CardType) => void
  removeLeader?: () => void
}) {
  const [{ isOver, canDrop }, drop] = useDrop({
    accept: "LEADER_CARD",
    drop: (item: { card: CardType }) => {
      setLeader(item.card)
    },
    collect: (monitor) => ({
      isOver: monitor.isOver(),
      canDrop: monitor.canDrop(),
    }),
  })

  return (
    <div
      ref={drop}
      className={`relative p-2 border-2 border-dashed rounded-lg transition-colors ${isOver && canDrop ? "border-green-500 bg-green-50" : "border-gray-300"}`}
    >
      {leader && (
        <div className="absolute top-1 right-1">
          <Button
            variant="ghost"
            size="icon"
            className="h-6 w-6 text-red-500 hover:bg-red-100"
            onClick={removeLeader}
          >
            <X className="h-4 w-4" />
          </Button>
        </div>
      )}
      {children}
    </div>
  )
})

// Card Browser Drop Zone
const CardBrowserDropZone = React.memo(function CardBrowserDropZone({
  children,
  removeCardFromDeck,
}: {
  children: React.ReactNode
  removeCardFromDeck: (cardId: number, index?: number) => void
}) {
  const [{ isOver }, drop] = useDrop({
    accept: ["DECK_CARD"],
    drop: (item: { card: CardType; index: number; stackId: number }, monitor) => {
      removeCardFromDeck(item.card.id, item.index)
    },
    collect: (monitor) => ({
      isOver: monitor.isOver(),
    }),
  })

  return (
    <div ref={drop} className={`min-h-[600px] ${isOver ? "bg-red-50" : ""}`}>
      {children}
    </div>
  )
})
