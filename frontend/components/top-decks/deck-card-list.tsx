"use client"

import React from "react"
import { ScrollArea } from "@/components/ui/scroll-area"
import { Badge } from "@/components/ui/badge"
import { Separator } from "@/components/ui/separator"

// Define mock card data for our example
const mockDeckCards = [
  { id: 1, quantity: 1, cardNumber: "OP01-001", name: "Luffy", color: "red", cost: 5, type: "Leader" },
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
]

// Helper to get color class for badges
const getColorClass = (color: string) => {
  const colorMap: { [key: string]: string } = {
    red: "bg-red-100 text-red-800 dark:bg-red-900/30 dark:text-red-200",
    blue: "bg-blue-100 text-blue-800 dark:bg-blue-900/30 dark:text-blue-200",
    green: "bg-green-100 text-green-800 dark:bg-green-900/30 dark:text-green-200",
    purple: "bg-purple-100 text-purple-800 dark:bg-purple-900/30 dark:text-purple-200",
    yellow: "bg-yellow-100 text-yellow-800 dark:bg-yellow-900/30 dark:text-yellow-200",
  }
  return colorMap[color.toLowerCase()] || "bg-gray-100 text-gray-800 dark:bg-gray-800/50 dark:text-gray-200"
}

interface DeckLeaderCard {
  id: number
  name: string
  cardNumber: string
  color: string
  imagePath: string
}

interface DeckCardListProps {
  leader: DeckLeaderCard
}

export default function DeckCardList({ leader }: DeckCardListProps) {
  // Group cards by type
  const groupedCards = mockDeckCards.reduce((acc, card) => {
    if (!acc[card.type]) {
      acc[card.type] = []
    }
    acc[card.type].push(card)
    return acc
  }, {} as Record<string, typeof mockDeckCards>)

  // Order of card types to display
  const displayOrder = ["Leader", "DON!!", "Character", "Event", "Stage"]

  // Calculate total cards
  const totalCards = mockDeckCards.reduce((sum, card) => sum + card.quantity, 0)

  return (
    <ScrollArea className="h-[400px] pr-4">
      <div className="space-y-4">
        {/* Total Count */}
        <div className="flex justify-between items-center">
          <h5 className="text-sm font-medium text-gray-500 dark:text-gray-400">Total Cards</h5>
          <Badge variant="outline">{totalCards + 1} cards</Badge> {/* +1 for leader card */}
        </div>

        {/* Card Categories */}
        {displayOrder.map(cardType => {
          const cards = cardType === "Leader" ? [{ id: leader.id, quantity: 1, cardNumber: leader.cardNumber, name: leader.name, color: leader.color, cost: 5, type: "Leader" }] : groupedCards[cardType] || []
          
          if (cards.length === 0) return null

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
          )
        })}
      </div>
    </ScrollArea>
  )
} 