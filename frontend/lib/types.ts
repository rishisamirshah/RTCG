export interface Card {
  id: number; // Corresponds to Long in Java
  cardID: string; // Added for text import
  name: string;
  cardNumber: string;
  life?: number | null; // Optional fields
  cardType: string;
  color: string;
  cost?: number | null;
  attribute?: string | null;
  timing?: string | null;
  effect?: string | null;
  affiliations?: string | null;
  power?: number | null;
  imagePath: string; // Corresponds to image in previous CardProps
  set: string;
  counter?: number | null;
} 

// Add other types needed for deckbuilder if any, e.g.:
export interface CardStackGroup {
  id: number
  cards: Card[]
}

// Add the ChartDataPoint interface
export interface ChartDataPoint {
  name: string;
  count: number;
}
