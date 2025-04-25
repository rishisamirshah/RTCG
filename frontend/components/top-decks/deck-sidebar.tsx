"use client"

import React from "react"
import { ChevronDown, ChevronUp, Save, Copy, ExternalLink } from "lucide-react"
import { Card, CardContent } from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import { Badge } from "@/components/ui/badge"
import { motion, AnimatePresence } from "framer-motion"
import { DeckStats } from "@/components/deck-stats"
import { Tooltip, TooltipContent, TooltipProvider, TooltipTrigger } from "@/components/ui/tooltip"
import { ScrollArea } from "@/components/ui/scroll-area"
import { Separator } from "@/components/ui/separator"
import { Tabs, TabsList, TabsTrigger, TabsContent } from "@/components/ui/tabs"

// Helper function to determine color style based on color name
const getColorStyle = (color: string) => {
  const colorMap: { [key: string]: string } = {
    red: "bg-red-100 text-red-800 border-red-200 dark:bg-red-900/30 dark:text-red-200 dark:border-red-900",
    blue: "bg-blue-100 text-blue-800 border-blue-200 dark:bg-blue-900/30 dark:text-blue-200 dark:border-blue-900",
    green: "bg-green-100 text-green-800 border-green-200 dark:bg-green-900/30 dark:text-green-200 dark:border-green-900",
    purple: "bg-purple-100 text-purple-800 border-purple-200 dark:bg-purple-900/30 dark:text-purple-200 dark:border-purple-900",
    yellow: "bg-yellow-100 text-yellow-800 border-yellow-200 dark:bg-yellow-900/30 dark:text-yellow-200 dark:border-yellow-900",
    black: "bg-gray-100 text-gray-800 border-gray-200 dark:bg-gray-800/50 dark:text-gray-200 dark:border-gray-800",
  }
  return colorMap[color.toLowerCase()] || colorMap.black
}

// Define card type for the deck list
interface DeckCard {
  id: number
  quantity: number
  cardNumber: string
  name: string
  color: string
  cost: number
  type: string
}

// Simple DeckCardList component (moved inline to avoid import issues)
interface DeckLeaderCard {
  id: number
  name: string
  cardNumber: string
  color: string
  imagePath: string
}

// Define the types for our component props
interface DeckPreviewCard {
  id: number
  cardNumber: string
  imagePath: string
}

interface DeckStats {
  winRate: number
  pickRate: number
  avgPlace: number
  top4: number
}

// Add tier data interface
interface TierData {
  tier: "S" | "A" | "B" | "C" | "Other"
  description: string
}

interface DeckData {
  id: number
  name: string
  player: string
  placement: string
  tournamentName: string
  date: string
  tier?: TierData // Make tier optional to maintain compatibility
  leader: DeckLeaderCard
  stats: DeckStats
  previewCards: DeckPreviewCard[]
  deckList?: DeckCard[] // Make optional to maintain compatibility
}

interface DeckSidebarProps {
  deck: DeckData
  isExpanded: boolean
  onToggleExpand: () => void
  isAuthenticated: boolean
}

// Display the deck card list
function DeckCardList({ deck }: { deck: DeckData }) {
  // Use provided deck list or mock data if not available
  const deckCards = deck.deckList || [
    // Default mock data shown only if no deck list is provided
    { id: 1, quantity: 1, cardNumber: deck.leader.cardNumber, name: deck.leader.name, color: deck.leader.color, cost: 5, type: "Leader" },
    // DON!! cards
    { id: 2, quantity: 4, cardNumber: "OP01-012", name: "Gum-Gum Red Hawk", color: "red", cost: 1, type: "DON!!" },
    { id: 3, quantity: 4, cardNumber: "OP01-013", name: "Gum-Gum King Kong Gun", color: "red", cost: 2, type: "DON!!" },
    // Character cards
    { id: 4, quantity: 4, cardNumber: "OP01-002", name: "Monkey D. Luffy", color: "red", cost: 4, type: "Character" },
    { id: 5, quantity: 4, cardNumber: "OP01-003", name: "Roronoa Zoro", color: "red", cost: 3, type: "Character" },
    { id: 6, quantity: 4, cardNumber: "OP01-004", name: "Nami", color: "red", cost: 2, type: "Character" },
    { id: 7, quantity: 3, cardNumber: "OP01-005", name: "Usopp", color: "red", cost: 3, type: "Character" },
    { id: 8, quantity: 3, cardNumber: "OP01-006", name: "Sanji", color: "red", cost: 4, type: "Character" },
    { id: 9, quantity: 3, cardNumber: "OP01-007", name: "Tony Tony Chopper", color: "red", cost: 1, type: "Character" },
    { id: 10, quantity: 2, cardNumber: "OP01-008", name: "Nico Robin", color: "red", cost: 3, type: "Character" },
    { id: 11, quantity: 2, cardNumber: "OP01-009", name: "Franky", color: "red", cost: 5, type: "Character" },
    { id: 12, quantity: 2, cardNumber: "OP01-010", name: "Brook", color: "red", cost: 4, type: "Character" },
    { id: 13, quantity: 2, cardNumber: "OP01-011", name: "Jinbe", color: "red", cost: 6, type: "Character" },
    // Event cards
    { id: 14, quantity: 4, cardNumber: "OP01-020", name: "Gomu Gomu no Storm", color: "red", cost: 2, type: "Event" },
    { id: 15, quantity: 4, cardNumber: "OP01-021", name: "One Piece", color: "red", cost: 1, type: "Event" },
    { id: 16, quantity: 4, cardNumber: "OP01-022", name: "Straw Hat", color: "red", cost: 0, type: "Event" },
  ];
  
  // Group cards by type
  const groupedCards = deckCards.reduce((acc, card) => {
    if (!acc[card.type]) {
      acc[card.type] = [];
    }
    acc[card.type].push(card);
    return acc;
  }, {} as Record<string, typeof deckCards>);
  
  // Order of card types to display
  const displayOrder = ["Leader", "DON!!", "Character", "Event", "Stage"];
  
  // Calculate total cards
  const totalCards = deckCards.reduce((sum, card) => sum + card.quantity, 0);
  
  // Helper to get color class for badges
  const getColorClass = (color: string) => {
    const colorMap: { [key: string]: string } = {
      red: "bg-red-100 text-red-800 dark:bg-red-900/30 dark:text-red-200",
      blue: "bg-blue-100 text-blue-800 dark:bg-blue-900/30 dark:text-blue-200",
      green: "bg-green-100 text-green-800 dark:bg-green-900/30 dark:text-green-200",
      purple: "bg-purple-100 text-purple-800 dark:bg-purple-900/30 dark:text-purple-200",
      yellow: "bg-yellow-100 text-yellow-800 dark:bg-yellow-900/30 dark:text-yellow-200",
    };
    return colorMap[color.toLowerCase()] || "bg-gray-100 text-gray-800 dark:bg-gray-800/50 dark:text-gray-200";
  };
  
  return (
    <ScrollArea className="h-[400px] pr-4">
      <div className="space-y-4">
        {/* Total Count */}
        <div className="flex justify-between items-center">
          <h5 className="text-sm font-medium text-gray-500 dark:text-gray-400">Total Cards</h5>
          <Badge variant="outline">{totalCards} cards</Badge>
        </div>
        
        {/* Card Categories */}
        {displayOrder.map(cardType => {
          const cards = groupedCards[cardType] || [];
          
          if (cards.length === 0) return null;
          
          return (
            <div key={cardType} className="space-y-2">
              <div className="flex items-center justify-between">
                <h5 className="text-sm font-medium">{cardType}</h5>
                <Badge variant="secondary" className="text-xs">
                  {cards.reduce((sum, card) => sum + card.quantity, 0)} cards
                </Badge>
              </div>
              
              <div className="space-y-1">
                {cards.map(card => (
                  <div 
                    key={card.id} 
                    className="flex items-center justify-between py-1 px-2 rounded-md hover:bg-gray-100 dark:hover:bg-gray-800 transition-colors"
                  >
                    <div className="flex items-center gap-2">
                      <Badge variant="outline" className="w-6 h-6 flex items-center justify-center p-0">
                        {card.quantity}
                      </Badge>
                      <span className="text-sm">{card.name}</span>
                    </div>
                    <div className="flex items-center gap-2">
                      <Badge variant="outline" className={`text-xs ${getColorClass(card.color)}`}>
                        {card.cost}
                      </Badge>
                      <span className="text-xs text-gray-500">{card.cardNumber}</span>
                    </div>
                  </div>
                ))}
              </div>
              
              <Separator className="my-2" />
            </div>
          );
        })}
      </div>
    </ScrollArea>
  );
}

export default function DeckSidebar({ deck, isExpanded, onToggleExpand, isAuthenticated }: DeckSidebarProps) {
  // Generate mock data for stats charts based on deck list
  const costCurveData = React.useMemo(() => {
    const costCounts: Record<string, number> = {
      '0': 0, '1': 0, '2': 0, '3': 0, '4': 0, '5': 0, '6': 0, '7': 0, '8': 0, '9': 0, '10+': 0
    };
    
    if (deck.deckList) {
      deck.deckList.forEach(card => {
        if (card.cost >= 10) {
          costCounts['10+'] += card.quantity;
        } else {
          costCounts[card.cost.toString()] += card.quantity;
        }
      });
    } else {
      // Default mock data if no deck list available
      costCounts['1'] = 4;
      costCounts['2'] = 8;
      costCounts['3'] = 12;
      costCounts['4'] = 10;
      costCounts['5'] = 8;
      costCounts['6'] = 5;
      costCounts['7'] = 2;
      costCounts['8'] = 1;
    }
    
    return Object.entries(costCounts).map(([name, count]) => ({ name, count }));
  }, [deck.deckList]);

  // Helper function to get tier badge color
  const getTierBadgeStyle = (tier?: string) => {
    if (!tier) return "bg-gray-300 text-gray-800";
    
    const tierColorMap: Record<string, string> = {
      "S": "bg-red-500 text-white",
      "A": "bg-orange-500 text-white",
      "B": "bg-blue-500 text-white",
      "C": "bg-green-500 text-white",
      "Other": "bg-gray-500 text-white"
    };
    
    return tierColorMap[tier] || "bg-gray-300 text-gray-800";
  };

  // Mock power curve data (could be calculated from actual cards if we had power values)
  const mockPowerCurveData = [
    { name: '0', count: 8 },
    { name: '1000', count: 0 },
    { name: '2000', count: 4 },
    { name: '3000', count: 6 },
    { name: '4000', count: 8 },
    { name: '5000', count: 12 },
    { name: '6000', count: 6 },
    { name: '7000', count: 4 },
    { name: '8000', count: 2 },
    { name: '9000', count: 0 },
    { name: '10000+', count: 0 },
  ];

  // Calculate attribute data from deck list
  const attributeData = React.useMemo(() => {
    const attributeCounts: Record<string, number> = {};
    
    if (deck.deckList) {
      // This is placeholder - actual attribute data would come from the cards
      attributeCounts['Strike'] = 15;
      attributeCounts['Slash'] = 10;
      attributeCounts['Wisdom'] = 5;
      attributeCounts['Special'] = 20;
    } else {
      attributeCounts['Strike'] = 15;
      attributeCounts['Slash'] = 10;
      attributeCounts['Wisdom'] = 5;
      attributeCounts['Special'] = 20;
    }
    
    return Object.entries(attributeCounts).map(([name, count]) => ({ name, count }));
  }, [deck.deckList]);

  // Calculate type data from deck list
  const typeData = React.useMemo(() => {
    if (deck.name === "Blackbeard Pirates") {
      return [
        { name: 'Blackbeard Pirates', count: 25 },
        { name: 'Marine', count: 4 },
        { name: 'Six Powers', count: 4 },
        { name: 'The Four Emperors', count: 7 },
      ];
    }
    
    return [
      { name: 'Straw Hat Crew', count: 25 },
      { name: 'Supernovas', count: 10 },
      { name: 'East Blue', count: 8 },
      { name: 'Grand Line', count: 7 },
    ];
  }, [deck.name]);

  // Function to handle saving deck to library
  const handleSaveDeck = () => {
    if (!isAuthenticated) {
      alert("Authentication Required: Please log in to save decks to your library");
      return
    }

    alert(`Deck Saved: ${deck.name} has been saved to your library`);
  }

  // Function to handle copying deck code
  const handleCopyDeckCode = () => {
    // Generate deck code from the actual deck list
    let deckCode = `1x${deck.leader.cardNumber}\n`;
    
    if (deck.deckList) {
      // Skip the leader card
      deck.deckList.filter(card => card.type !== "Leader").forEach(card => {
        deckCode += `${card.quantity}x${card.cardNumber}\n`;
      });
    } else {
      // Default mock code
      deckCode += "4xOP01-002\n4xOP01-003\n4xOP01-004\n3xOP01-005";
    }
    
    navigator.clipboard.writeText(deckCode);
    alert("Deck Code Copied: Deck code has been copied to clipboard");
  }

  // Visual deck representation similar to deck builder
  const DeckVisual = () => {
    const cards = deck.deckList || [];
    
    return (
      <div className="mb-6 bg-gray-50 dark:bg-gray-900 p-4 rounded-lg">
        <h4 className="font-semibold text-lg mb-4">Deck Preview</h4>
        <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-5 lg:grid-cols-8 xl:grid-cols-10 gap-2">
          {/* Leader card shown first and slightly larger */}
          <div className="relative transform transition-transform hover:scale-105 cursor-pointer">
            <img 
              src={deck.leader.imagePath}
              alt={deck.leader.name}
              className="w-full h-auto rounded shadow-md border-2 border-gray-800 dark:border-gray-600" 
              onError={(e) => {
                // Try PNG if JPG fails
                const imgElement = e.target as HTMLImageElement;
                const currentSrc = imgElement.src;
                
                if (currentSrc.endsWith('.jpg')) {
                  // Try PNG format
                  imgElement.src = currentSrc.replace('.jpg', '.png');
                } else {
                  // If PNG also fails, show placeholder
                  imgElement.src = "https://via.placeholder.com/100x140?text=Leader+Not+Found";
                  // Add a red border to indicate missing image
                  imgElement.classList.add('border-red-500');
                }
              }}
            />
            <div className="absolute bottom-0 left-0 right-0 bg-gray-800/80 text-white text-xs p-0.5 text-center truncate">
              LEADER
            </div>
          </div>
          
          {/* Other cards in deck */}
          {cards.filter(card => card.type !== "Leader").map((card, index) => (
            <div key={`visual-${card.id}-${index}`} className="relative transform transition-transform hover:scale-105 cursor-pointer group">
              <img 
                src={`/images/cards/${card.cardNumber.split('-')[0]}/${card.cardNumber}.jpg`} 
                alt={card.name}
                className="w-full h-auto rounded shadow-sm border border-gray-200 dark:border-gray-700 group-hover:border-gray-800" 
                onError={(e) => {
                  // Try PNG if JPG fails
                  const imgElement = e.target as HTMLImageElement;
                  const currentSrc = imgElement.src;
                  
                  if (currentSrc.endsWith('.jpg')) {
                    // Try PNG format
                    imgElement.src = currentSrc.replace('.jpg', '.png');
                  } else {
                    // If PNG also fails, show placeholder
                    imgElement.src = "https://via.placeholder.com/50x70?text=Card";
                    // Add a red border to indicate missing image
                    imgElement.classList.add('border-red-500');
                  }
                }}
              />
              {/* Power indicator (top left) */}
              {(card.type === "Character" && card.cost > 0) && (
                <div className="absolute top-0 left-0 bg-white/80 dark:bg-black/80 text-black dark:text-white text-xs px-1 rounded-br">
                  {card.cost * 1000}
                </div>
              )}
              {/* Cost indicator (top left for events) */}
              {card.type === "Event" && (
                <div className="absolute top-0 left-0 bg-white/80 dark:bg-black/80 text-black dark:text-white text-xs px-1 rounded-br">
                  {card.cost}
                </div>
              )}
              {/* Quantity indicator (top right) */}
              {card.quantity > 1 && (
                <div className="absolute top-0 right-0 bg-red-500 text-white rounded-full h-5 w-5 flex items-center justify-center text-xs -mt-1 -mr-1 border border-white shadow-sm">
                  {card.quantity}
                </div>
              )}
              {/* Card name on hover */}
              <div className="absolute bottom-0 left-0 right-0 bg-black/60 text-white text-[10px] px-1 py-0.5 truncate opacity-0 group-hover:opacity-100 transition-opacity">
                {card.name}
              </div>
            </div>
          ))}
        </div>
      </div>
    );
  };

  return (
    <Card className={`overflow-hidden bg-card border border-gray-200 dark:border-gray-800 transition-all duration-300 hover:shadow-md ${isExpanded ? 'shadow-lg' : 'shadow-sm'}`}>
      {/* Header Section (Always Visible) */}
      <div 
        className="relative cursor-pointer" 
        onClick={onToggleExpand}
      >
        {/* Remove direct background style - use Card's default */}
        <div className="absolute inset-0 overflow-hidden">
          {/* Add subtle animated pattern for texture */}
          <div className="absolute inset-0 bg-[url('/images/card-pattern.png')] opacity-5 dark:opacity-10"></div>
          
          {/* Add a subtle gradient overlay */}
          <div className="absolute inset-0 bg-gradient-to-r from-transparent to-gray-200/30 dark:to-gray-700/30"></div>
        </div>

        {/* Content */}
        <CardContent className="relative z-10 flex flex-col md:flex-row items-start md:items-center gap-4 p-4">
          {/* Leader Card Thumbnail */}
          <div className="flex-shrink-0 relative">
            <img 
              src={deck.leader.imagePath}
              alt={deck.leader.name}
              className="w-20 h-28 object-cover rounded-md shadow-md border border-gray-300 dark:border-gray-700"
              onError={(e) => {
                // If JPG fails, try PNG
                const imgElement = e.target as HTMLImageElement;
                const currentSrc = imgElement.src;
                
                if (currentSrc.endsWith('.jpg')) {
                  imgElement.src = currentSrc.replace('.jpg', '.png');
                } else {
                  // If PNG also fails, show placeholder with red border
                  imgElement.src = "https://via.placeholder.com/100x140?text=Leader+Not+Found";
                  imgElement.classList.add('border-red-500');
                }
              }}
            />
            
            {/* Color Badge */}
            <span className={`absolute -top-2 -left-2 px-1.5 py-0.5 text-xs uppercase font-bold rounded ${getColorStyle(deck.leader.color)}`}>
              {deck.leader.color}
            </span>
          </div>
          
          {/* Deck Info Column */}
          <div className="flex-grow">
            <div className="flex flex-col sm:flex-row sm:items-center sm:gap-3 mb-1">
              <div className="flex items-center gap-2">
                <Badge className={`${getColorStyle(deck.leader.color)}`}>
                  {deck.leader.color.toUpperCase()}
                </Badge>
                <h3 className="text-xl font-bold">{deck.name}</h3>
              </div>
              <div className="text-sm text-gray-500 dark:text-gray-400 mt-1 sm:mt-0">
                {deck.player} • {deck.placement}
              </div>
            </div>
            
            <div className="flex flex-wrap items-center gap-4 mt-2">
              <div className="flex items-center gap-1">
                <span className="text-sm uppercase text-purple-800 dark:text-purple-400 font-medium">Leader:</span>
                <span className="font-bold text-purple-900 dark:text-purple-300 uppercase">{deck.leader.name}</span>
              </div>
              
              {/* Updated Win Rate Display */}
              <div className="flex items-center gap-1.5 ml-auto">
                <span className="text-sm font-medium text-gray-600 dark:text-gray-400">Win Rate:</span>
                <span className={`text-lg font-bold ${deck.stats.winRate > 85 ? 'text-green-600 dark:text-green-400' : 'text-gray-800 dark:text-gray-200'}`}>
                  {deck.stats.winRate}%
                </span>
              </div>
              {/* Removed Top 4% Stat */}
            </div>
          </div>

          {/* Preview Cards - Increased count and adjusted styling */}
          <div className="hidden md:flex items-center gap-[-8px] ml-auto mr-4">
            {deck.previewCards.slice(0, 8).map((card, index) => ( 
              <div 
                key={card.id} 
                className="w-12 h-[67px] transform hover:translate-y-[-3px] transition-transform relative shadow-sm hover:shadow-md"
                style={{ marginLeft: index > 0 ? '-8px' : '0', zIndex: 10 - index }}
              >
                <img 
                  src={card.imagePath} 
                  alt={`Card ${card.cardNumber}`} 
                  className="rounded-sm border border-gray-300 dark:border-gray-700 w-full h-full object-cover"
                  onError={(e) => {
                    // If JPG fails, try PNG
                    const imgElement = e.target as HTMLImageElement;
                    const currentSrc = imgElement.src;
                    
                    if (currentSrc.endsWith('.jpg')) {
                      imgElement.src = currentSrc.replace('.jpg', '.png');
                    } else {
                      // If PNG also fails, show placeholder with red border
                      imgElement.src = "https://via.placeholder.com/50x70?text=Card";
                      imgElement.classList.add('border-red-500');
                    }
                  }}
                />
              </div>
            ))}
          </div>

          {/* Action Buttons */}
          <div className="flex items-center gap-2 md:self-center md:ml-0">
            <Button variant="ghost" size="icon" className="text-gray-400 hover:text-red-500 dark:hover:text-red-400" onClick={(e) => {
              e.stopPropagation();
              handleSaveDeck();
            }}>
              <Save className="h-5 w-5" />
            </Button>
            
            <Button variant="ghost" size="icon" className="text-gray-400 hover:text-blue-500 dark:hover:text-blue-400" onClick={(e) => {
              e.stopPropagation();
              handleCopyDeckCode();
            }}>
              <Copy className="h-5 w-5" />
            </Button>
            
            <Button variant="ghost" size="icon" className="text-gray-400">
              {isExpanded ? <ChevronUp className="h-5 w-5" /> : <ChevronDown className="h-5 w-5" />}
            </Button>
          </div>
        </CardContent>
      </div>
      
      {/* Expanded Content */}
      <AnimatePresence>
        {isExpanded && (
          <motion.div
            initial={{ height: 0, opacity: 0 }}
            animate={{ height: 'auto', opacity: 1 }}
            exit={{ height: 0, opacity: 0 }}
            transition={{ duration: 0.3 }}
            className="overflow-hidden"
          >
            <CardContent className="p-0">
              {/* Deck preview visual */}
              <DeckVisual />
              
              {/* Tier description */}
              {deck.tier && (
                <div className="px-6 pb-6">
                  <div className="flex items-center gap-2 mb-2">
                    <Badge className={`${getTierBadgeStyle(deck.tier.tier)} font-bold px-2 py-0.5`}>
                      Tier {deck.tier.tier}
                    </Badge>
                    <h4 className="font-semibold text-lg">Meta Analysis</h4>
                  </div>
                  <p className="text-sm text-gray-700 dark:text-gray-300">
                    {deck.tier.description}
                  </p>
                </div>
              )}
            
              {/* Tabs for different views */}
              <Tabs defaultValue="cards" className="w-full px-6 pb-6">
                <TabsList className="mb-4">
                  <TabsTrigger value="cards">Deck List</TabsTrigger>
                  <TabsTrigger value="stats">Deck Stats</TabsTrigger>
                </TabsList>
                
                <TabsContent value="cards" className="mt-0">
                  <DeckCardList deck={deck} />
                </TabsContent>
                
                <TabsContent value="stats" className="mt-0">
                  <div className="space-y-6">
                    <DeckStats 
                      costCurveData={costCurveData}
                      powerCurveData={mockPowerCurveData}
                      attributeData={attributeData}
                      typeData={typeData}
                    />
                  </div>
                </TabsContent>
              </Tabs>
              
              <div className="px-6 pb-4 flex justify-between">
                <Button variant="ghost" onClick={onToggleExpand} className="text-gray-500">
                  <ChevronUp className="h-4 w-4 mr-2" />
                  Close
                </Button>
                
                <Button variant="outline" className="text-gray-500" onClick={(e) => {
                  e.stopPropagation();
                  window.open(`/deck/${deck.id}`, '_blank');
                }}>
                  <ExternalLink className="h-4 w-4 mr-2" />
                  Full Deck Details
                </Button>
              </div>
            </CardContent>
          </motion.div>
        )}
      </AnimatePresence>
    </Card>
  )
} 