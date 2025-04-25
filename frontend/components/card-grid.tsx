"use client"; // Add this directive to make it a Client Component

import Image from "next/image"
import type { Card } from "@/lib/types"

interface CardGridProps {
  cards: Card[];
  onCardClick: (card: Card) => void; // Add prop for click handler
}

export default function CardGrid({ cards, onCardClick }: CardGridProps) {
  // Remove placeholder data
  // const cards: Card[] = [...];

  // Handle case where cards might be empty or undefined
  if (!cards || cards.length === 0) {
    return <div className="text-center text-gray-500">No cards found.</div>;
  }

  return (
    <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-3 lg:grid-cols-5 gap-4">
      {cards.map((card) => (
        <CardItem key={card.id} card={card} onClick={() => onCardClick(card)} />
      ))}
    </div>
  )
}

interface CardItemProps {
  card: Card;
  onClick: () => void;
}

// Add a utility function for fixing image paths at the top of the file
function fixImagePath(imagePath: string | null | undefined, cardSet: string, cardNumber: string): string {
  if (!imagePath) return "/placeholder.svg";
  
  // Extract set and number if we need them
  const setCode = cardSet || imagePath.split('/')[3] || '';
  
  // Handle ST06-ST20 cards - force PNG extension
  if (setCode.startsWith('ST') && parseInt(setCode.substring(2)) >= 6 && parseInt(setCode.substring(2)) <= 20) {
    // Force PNG extension
    return imagePath.replace(/\.(jpg|png)$/, '.png');
  }
  
  // For all other cards, return as is but ensure it's a relative path
  if (imagePath.startsWith('C:') || imagePath.startsWith('/C:')) {
    // This is an absolute path, convert to relative
    const parts = imagePath.split('cards/');
    if (parts.length > 1) {
      return `/images/cards/${parts[1]}`;
    }
  }
  
  return imagePath;
}

function CardItem({ card, onClick }: CardItemProps) {
  const primaryColor = card.color?.split('/')[0].toLowerCase() || 'gray';
  const colorClass = getColorClass(primaryColor);
  
  // Fix image path using our utility function
  const imageUrl = fixImagePath(card.imagePath, card.set, card.cardNumber);
  
  // Prepare a fallback URL with alternative extension
  const fallbackUrl = imageUrl.endsWith('.jpg') 
    ? imageUrl.replace('.jpg', '.png') 
    : imageUrl.endsWith('.png') 
      ? imageUrl.replace('.png', '.jpg') 
      : "/placeholder.svg";
  
  return (
    <div className="group cursor-pointer" onClick={onClick}>
      <div
        className={`relative rounded-lg overflow-hidden border-2 ${colorClass} transition-transform transform group-hover:scale-105 dark:bg-black/20`}
      >
        <div className="absolute top-2 left-2 z-10 flex items-center justify-center w-6 h-6 rounded-full bg-white dark:bg-gray-800 text-xs font-bold dark:text-white">
          {/* Assuming getPowerIcon logic remains valid, adjust if needed */}
          {getPowerIcon(card.power)}
        </div>
        <div className="absolute top-2 right-2 z-10 flex items-center justify-center rounded-full bg-white dark:bg-gray-800 px-2 py-1 text-xs font-bold dark:text-white">
          {card.power || 'N/A'} {/* Display power or N/A */}
        </div>
        <div className="w-full h-full overflow-hidden">
          <Image
            src={imageUrl}
            alt={card.name}
            width={300}
            height={400}
            className="w-full h-auto"
            onError={(e) => { 
              // Try the alternative extension first, then fallback to placeholder
              if (e.currentTarget.src !== fallbackUrl && fallbackUrl !== "/placeholder.svg") {
                console.log(`Trying alternative format for ${card.cardNumber}: ${fallbackUrl}`);
                e.currentTarget.src = fallbackUrl;
              } else {
                console.log(`Using placeholder for ${card.cardNumber}`);
                e.currentTarget.src = "/placeholder.svg";
              }
            }}
          />
        </div>
        <div className="absolute bottom-0 left-0 right-0 bg-gradient-to-t from-black/80 to-transparent dark:from-black/90 dark:to-transparent p-3">
          <h3 className="text-white font-medium text-sm truncate">{card.name}</h3>
          {/* Use affiliations from backend */}
          <p className="text-gray-300 text-xs truncate">{card.affiliations || 'No affiliations'}</p>
        </div>
      </div>
    </div>
  )
}

// Keep helper functions, adjust logic if needed based on backend data
function getPowerIcon(power: number | null | undefined): string {
  if (power === null || power === undefined) return '-';
  if (power >= 5000) return "4";
  if (power >= 4000) return "3";
  if (power >= 3000) return "2";
  return "1";
}

function getColorClass(color: string): string {
  switch (color) {
    case "red":
      return "border-red-600 dark:border-red-800";
    case "green":
      return "border-green-600 dark:border-green-800";
    case "blue":
      return "border-blue-600 dark:border-blue-800";
    case "yellow":
      return "border-yellow-600 dark:border-yellow-800";
    case "purple":
      return "border-purple-600 dark:border-purple-800";
    case "black":
      return "border-black dark:border-gray-700";
    default:
      return "border-gray-600 dark:border-gray-700";
  }
}
