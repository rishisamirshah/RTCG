"use client"

import React from 'react'
import { Tooltip, TooltipContent, TooltipProvider, TooltipTrigger } from "@/components/ui/tooltip"

// Define types directly here for simplicity
interface DeckLeaderCard {
  id: number
  name: string
  cardNumber: string
  color: string
  imagePath: string
}

interface TierData {
  tier: "S" | "A" | "B" | "C" | "Other"
  description: string
}

interface TierDeck {
  id: number
  name: string
  tier?: TierData
  leader: DeckLeaderCard
}

interface TierListVisualProps {
  decks: TierDeck[]
}

// Helper function to get tier badge color
const getTierBadgeStyle = (tier?: string) => {
  if (!tier) return "bg-gray-300 text-gray-800 dark:bg-gray-700 dark:text-gray-300";
  
  const tierColorMap: Record<string, string> = {
    "S": "bg-red-500 text-white",
    "A": "bg-orange-500 text-white",
    "B": "bg-blue-500 text-white",
    "C": "bg-green-500 text-white",
    "Other": "bg-gray-500 text-white"
  };
  
  return tierColorMap[tier] || "bg-gray-300 text-gray-800 dark:bg-gray-700 dark:text-gray-300";
};

export default function TierListVisual({ decks }: TierListVisualProps) {
  const tiers: ("S" | "A" | "B" | "C")[] = ["S", "A", "B", "C"]; // Define the tiers to display

  const groupedDecks = tiers.map(tier => ({
    tier,
    decks: decks.filter(deck => deck.tier?.tier === tier)
               .sort((a, b) => a.name.localeCompare(b.name)) // Sort alphabetically within tier
  }));

  return (
    <div className="space-y-3">
      {groupedDecks.map(({ tier, decks: tierDecks }) => {
        if (tierDecks.length === 0) return null;

        return (
          <div key={tier} className="flex items-start gap-3 mb-3">
            {/* Tier Label - Adjusted size and styling */}
            <div 
              className={`w-14 h-14 flex-shrink-0 flex items-center justify-center rounded-lg shadow-md font-bold text-2xl ${getTierBadgeStyle(tier)}`}
            >
              {tier}
            </div>
            
            {/* Decks in Tier - Horizontal Flexbox */}
            <div className="flex-1 flex flex-wrap gap-2">
              {tierDecks.map(deck => (
                <TooltipProvider key={deck.id} delayDuration={100}>
                  <Tooltip>
                    <TooltipTrigger asChild>
                      <div className="relative group cursor-pointer w-20 h-[112px]" > 
                        <img 
                          src={deck.leader.imagePath}
                          alt={deck.leader.name}
                          className="w-full h-full rounded-md shadow-sm border border-gray-300 dark:border-gray-700 object-cover transform transition-transform group-hover:scale-105"
                          onError={(e) => {
                            const imgElement = e.target as HTMLImageElement;
                            const currentSrc = imgElement.src;
                            
                            if (currentSrc.endsWith('.jpg')) {
                              imgElement.src = currentSrc.replace('.jpg', '.png');
                            } else {
                              imgElement.src = "https://via.placeholder.com/100x140?text=Card";
                              imgElement.classList.add('border-red-500');
                            }
                          }}
                        />
                      </div>
                    </TooltipTrigger>
                    <TooltipContent>
                      <p className="text-xs">{deck.name}</p>
                    </TooltipContent>
                  </Tooltip>
                </TooltipProvider>
              ))}
            </div>
          </div>
        );
      })}
    </div>
  );
} 