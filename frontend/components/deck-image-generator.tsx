"use client"

import React, { useRef } from 'react';
import html2canvas from 'html2canvas';
import { Card as CardType } from '@/lib/types';
import { ChartDataPoint } from '@/lib/types';
import { CardHeader, CardContent, CardTitle } from './ui/card';
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  CartesianGrid,
  Cell,
  ResponsiveContainer,
} from 'recharts';
import Image from 'next/image';

interface DeckImageGeneratorProps {
  deckName: string;
  leader: CardType | null;
  deck: CardType[];
  cardStacks: Array<{ cards: CardType[] }>;
  costCurveData: ChartDataPoint[];
  powerCurveData: ChartDataPoint[];
}

const DeckImageGenerator: React.FC<DeckImageGeneratorProps> = ({
  deckName,
  leader,
  deck,
  cardStacks,
  costCurveData,
  powerCurveData,
}) => {
  const componentRef = useRef<HTMLDivElement>(null);

  const generateImage = async () => {
    if (!componentRef.current) return;

    try {
      const canvas = await html2canvas(componentRef.current, {
        allowTaint: true,
        useCORS: true,
        scale: 2, // Higher quality
        backgroundColor: '#f5f5f5',
      });

      const image = canvas.toDataURL('image/jpeg', 0.9);
      
      // Create a download link
      const link = document.createElement('a');
      link.href = image;
      link.download = `${deckName.replace(/\s+/g, '-').toLowerCase()}.jpg`;
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);
    } catch (error) {
      console.error('Error generating image:', error);
      alert('Failed to generate deck image. Please try again.');
    }
  };

  return (
    <div className="flex flex-col space-y-4">
      <button
        className="bg-red-600 hover:bg-red-700 text-white font-bold py-2 px-4 rounded flex items-center justify-center"
        onClick={generateImage}
      >
        <svg className="w-4 h-4 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
          <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M4 16l4.586-4.586a2 2 0 012.828 0L16 16m-2-2l1.586-1.586a2 2 0 012.828 0L20 14m-6-6h.01M6 20h12a2 2 0 002-2V6a2 2 0 00-2-2H6a2 2 0 00-2 2v12a2 2 0 002 2z" />
        </svg>
        Generate Deck Image
      </button>

      {/* Deck Image Preview (will be converted to JPG) */}
      <div 
        ref={componentRef} 
        className="bg-white p-6 rounded-xl shadow-lg max-w-4xl"
        style={{ width: '1200px', height: 'auto' }}
      >
        {/* Deck Header */}
        <div className="flex justify-between items-center mb-6 border-b border-gray-200 pb-4">
          <div>
            <h1 className="text-3xl font-bold text-red-700">{deckName}</h1>
            <p className="text-gray-600">{deck.length} cards + 1 Leader • Generated with RTCG Deckbuilder</p>
          </div>
          <div className="bg-red-50 p-1 rounded-lg border border-red-200 flex items-center">
            <img src="/images/logo.png" alt="RTCG Logo" className="h-10 w-auto" />
          </div>
        </div>

        {/* Leader & Deck Content */}
        <div className="grid grid-cols-5 gap-6">
          {/* Left column: Leader & Stats */}
          <div className="col-span-1">
            {/* Leader Card */}
            {leader && (
              <div className="bg-gradient-to-br from-red-50 to-red-100 p-3 rounded-lg shadow-sm mb-4">
                <h3 className="text-center font-bold mb-2 text-red-800">Leader</h3>
                <div className="flex justify-center">
                  <img 
                    src={leader.imagePath} 
                    alt={leader.name} 
                    className="rounded-lg shadow-md max-w-full h-auto border-2 border-red-300"
                    style={{ maxHeight: "300px" }}
                  />
                </div>
                <div className="mt-2 text-center">
                  <p className="font-semibold text-sm">{leader.name}</p>
                  <p className="text-xs text-gray-600">{leader.cardNumber}</p>
                </div>
              </div>
            )}

            {/* Stats Mini Charts */}
            <div className="bg-gradient-to-br from-red-50 to-red-100 p-3 rounded-lg shadow-sm">
              <h3 className="text-center font-bold mb-2 text-red-800">Stats</h3>
              
              {/* Cost Curve */}
              <div className="mb-4">
                <p className="text-xs font-semibold mb-1 text-gray-700">Cost Distribution</p>
                <div className="h-20">
                  <ResponsiveContainer width="100%" height="100%">
                    <BarChart data={costCurveData} margin={{ top: 5, right: 5, left: -15, bottom: 5 }}>
                      <CartesianGrid strokeDasharray="3 3" stroke="#e5e7eb" opacity={0.5} />
                      <XAxis dataKey="name" fontSize={8} tickLine={false} axisLine={false} />
                      <YAxis allowDecimals={false} fontSize={8} tickLine={false} axisLine={false} />
                      <Bar dataKey="count" fill="#ef4444" radius={[2, 2, 0, 0]}>
                        {costCurveData.map((_, index) => (
                          <Cell key={`cell-${index}`} fill={`#ef4444`} />
                        ))}
                      </Bar>
                    </BarChart>
                  </ResponsiveContainer>
                </div>
              </div>

              {/* Power Curve */}
              <div>
                <p className="text-xs font-semibold mb-1 text-gray-700">Power Distribution</p>
                <div className="h-20">
                  <ResponsiveContainer width="100%" height="100%">
                    <BarChart data={powerCurveData} margin={{ top: 5, right: 5, left: -15, bottom: 5 }}>
                      <CartesianGrid strokeDasharray="3 3" stroke="#e5e7eb" opacity={0.5} />
                      <XAxis dataKey="name" fontSize={8} tickLine={false} axisLine={false} />
                      <YAxis allowDecimals={false} fontSize={8} tickLine={false} axisLine={false} />
                      <Bar dataKey="count" fill="#dc2626" radius={[2, 2, 0, 0]}>
                        {powerCurveData.map((_, index) => (
                          <Cell key={`cell-${index}`} fill={`#dc2626`} />
                        ))}
                      </Bar>
                    </BarChart>
                  </ResponsiveContainer>
                </div>
              </div>
            </div>
          </div>

          {/* Right column: Deck Cards Grid */}
          <div className="col-span-4">
            <div className="bg-gradient-to-br from-white to-red-50 p-4 rounded-lg shadow-sm">
              <h3 className="text-xl font-bold mb-4 text-red-800">Deck Cards</h3>
              
              <div className="grid grid-cols-6 gap-2">
                {cardStacks.map((stack, index) => (
                  <div key={index} className="relative">
                    <img 
                      src={stack.cards[0].imagePath} 
                      alt={stack.cards[0].name} 
                      className="rounded border border-gray-200 w-full h-auto shadow-sm hover:shadow-md transition-shadow"
                    />
                    <div className="absolute top-0 right-0 bg-red-600 text-white text-xs font-bold rounded-full w-6 h-6 flex items-center justify-center transform translate-x-1/4 -translate-y-1/4">
                      {stack.cards.length}x
                    </div>
                    <div className="mt-1 px-1">
                      <p className="text-xs font-medium truncate">{stack.cards[0].name}</p>
                      <p className="text-xs text-gray-500">{stack.cards[0].cardNumber}</p>
                    </div>
                  </div>
                ))}
              </div>
            </div>
          </div>
        </div>

        {/* Footer */}
        <div className="mt-6 pt-4 border-t border-gray-200 flex justify-between text-xs text-gray-500">
          <span>Generated on {new Date().toLocaleDateString()}</span>
          <span>RTCG Deckbuilder • onepiececardgame.rtcg.app</span>
        </div>
      </div>
    </div>
  );
};

export default DeckImageGenerator; 