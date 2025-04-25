"use client" // Add this directive as DndProvider uses context

import DeckBuilder from '@/components/deck-builder';
import { DndProvider } from 'react-dnd';
import { HTML5Backend } from 'react-dnd-html5-backend';

// This page needs DndProvider specifically for the deck builder component
export default function DeckBuilderPage() {
  return (
    <DndProvider backend={HTML5Backend}>
      <DeckBuilder />
    </DndProvider>
  );
} 