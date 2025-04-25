import Image from "next/image"
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
} from "@/components/ui/dialog"
import type { Card } from "@/lib/types"

interface CardModalProps {
  card: Card | null;
  open: boolean;
  onOpenChange: (open: boolean) => void;
}

// Add a utility function for fixing image paths
function fixImagePath(imagePath: string | null | undefined, cardSet: string | undefined, cardNumber: string | undefined): string {
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

export default function CardModal({ card, open, onOpenChange }: CardModalProps) {
  if (!card) return null;

  // Use our utility function to fix the image path
  const imageUrl = fixImagePath(card.imagePath, card.set, card.cardNumber);
  
  // Prepare a fallback URL with alternative extension
  const fallbackUrl = imageUrl.endsWith('.jpg') 
    ? imageUrl.replace('.jpg', '.png') 
    : imageUrl.endsWith('.png') 
      ? imageUrl.replace('.png', '.jpg') 
      : "/placeholder.svg";

  return (
    <Dialog open={open} onOpenChange={onOpenChange}>
      <DialogContent className="sm:max-w-[425px] md:max-w-[600px] lg:max-w-[800px] max-h-[90vh] overflow-y-auto">
        <DialogHeader>
          <DialogTitle className="text-xl font-bold">{card.name} ({card.cardNumber})</DialogTitle>
          <DialogDescription>
            {card.cardType} - {card.color}
          </DialogDescription>
        </DialogHeader>
        <div className="grid gap-4 py-4 md:grid-cols-2">
          <div className="flex justify-center items-start">
            <Image
              src={imageUrl}
              alt={card.name}
              width={300} // Adjust size as needed for modal
              height={420}
              className="rounded-lg border border-gray-300"
              onError={(e) => { 
                // Try the alternative extension first, then fallback to placeholder
                if (e.currentTarget.src !== fallbackUrl && fallbackUrl !== "/placeholder.svg") {
                  console.log(`Modal - Trying alternative format: ${fallbackUrl}`);
                  e.currentTarget.src = fallbackUrl;
                } else {
                  console.log(`Modal - Using placeholder for ${card.cardNumber}`);
                  e.currentTarget.src = "/placeholder.svg";
                }
              }}
            />
          </div>
          <div className="space-y-3 text-sm">
            <p><strong>Set:</strong> {card.set || 'N/A'}</p>
            <p><strong>Cost:</strong> {card.cost ?? 'N/A'}</p>
            <p><strong>Power:</strong> {card.power ?? 'N/A'}</p>
            <p><strong>Counter:</strong> {card.counter ?? 'N/A'}</p>
            <p><strong>Life:</strong> {card.life ?? 'N/A'}</p>
            <p><strong>Attribute:</strong> {card.attribute || 'N/A'}</p>
            <p><strong>Affiliations:</strong> {card.affiliations || 'N/A'}</p>
            <div>
              <strong className="block mb-1">Effect:</strong>
              <p className="whitespace-pre-wrap text-xs bg-gray-100 dark:bg-gray-800 p-2 rounded">{card.effect || 'No effect text.'}</p>
            </div>
             {card.timing && (
                 <div>
                    <strong className="block mb-1">Timing:</strong>
                    <p className="whitespace-pre-wrap text-xs bg-gray-100 dark:bg-gray-800 p-2 rounded">{card.timing}</p>
                 </div>
             )}
          </div>
        </div>
        {/* Optional: Add DialogFooter for actions if needed */}
      </DialogContent>
    </Dialog>
  )
} 