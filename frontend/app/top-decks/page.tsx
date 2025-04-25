"use client"

import React, { useState, useEffect } from "react"
import { Search, Filter, Download, SortDesc, ChevronUp } from "lucide-react"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { ScrollArea } from "@/components/ui/scroll-area"
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs"
import { DropdownMenu, DropdownMenuContent, DropdownMenuTrigger, DropdownMenuItem } from "@/components/ui/dropdown-menu"
import { Badge } from "@/components/ui/badge"
import { motion, AnimatePresence } from "framer-motion"
import DeckSidebar from "../../components/top-decks/deck-sidebar"
import { useAuth } from "@/hooks/useAuth"
import { Dialog, DialogContent, DialogDescription, DialogFooter, DialogHeader, DialogTitle, DialogTrigger } from "@/components/ui/dialog"
import TierListVisual from "@/components/top-decks/tier-list-visual"

// Define the card type for deck list
interface DeckCard {
  id: number
  quantity: number
  cardNumber: string
  name: string
  color: string
  cost: number
  type: string
}

// Tier data interface
interface TierData {
  tier: "S" | "A" | "B" | "C" | "Other"
  description: string
}

// Single deck data for the Blackbeard deck
const mockTopDecks = [
  {
    id: 1,
    name: "Blackbeard Pirates",
    player: "Vincent",
    placement: "8th Place (8-1)",
    tournamentName: "Pasadena OP10 Post Regional",
    date: "2024-04-01",
    tier: {
      tier: "S",
      description: "OP10 is a huge buff to Blackbeard as he gains OP10-Kuzan, which solves Blackbeard's draw problem. Additionally, he makes your gameplan extremely more flexible as he can grab any card you need in that situation. You can grab Van Auger when you need the cost reduction, Shiryu when you need that KO, Burgess when you want to establish a beefy character, or even Vasco Shot/Catarina Devon when you need a spot blocker. Although OP10 seems like a meta with a lot of variety where many decks can do well, if I had to choose 1 deck that is the most meta-defining, it would be Blackbeard."
    } as TierData,
    leader: {
      id: 101,
      name: "MARSHALL D. TEACH",
      cardNumber: "OP09-081",
      color: "black",
      imagePath: "/images/cards/OP09/OP09-081.jpg"
    },
    stats: {
      winRate: 88.9,
      pickRate: 0.15,
      avgPlace: 2.4,
      top4: 78.5
    },
    previewCards: [
      { id: 102, cardNumber: "OP09-093", imagePath: "/images/cards/OP09/OP09-093.jpg" },
      { id: 103, cardNumber: "OP10-082", imagePath: "/images/cards/OP10/OP10-082.jpg" },
      { id: 104, cardNumber: "OP09-086", imagePath: "/images/cards/OP09/OP09-086.jpg" },
      { id: 105, cardNumber: "OP09-098", imagePath: "/images/cards/OP09/OP09-098.jpg" }
    ],
    deckList: [
      { id: 1, quantity: 1, cardNumber: "OP09-081", name: "Marshall D. Teach", color: "black", cost: 5, type: "Leader" },
      { id: 2, quantity: 4, cardNumber: "OP09-089", name: "Stronger", color: "black", cost: 2, type: "Character" },
      { id: 3, quantity: 4, cardNumber: "OP09-095", name: "Laffitte", color: "black", cost: 3, type: "Character" },
      { id: 4, quantity: 4, cardNumber: "OP09-090", name: "Doc Q", color: "black", cost: 4, type: "Character" },
      { id: 5, quantity: 2, cardNumber: "OP09-091", name: "Vasco Shot", color: "black", cost: 5, type: "Character" },
      { id: 6, quantity: 3, cardNumber: "OP09-088", name: "Shiryu", color: "black", cost: 4, type: "Character" },
      { id: 7, quantity: 3, cardNumber: "OP10-086", name: "Shiryu", color: "black", cost: 4, type: "Character" },
      { id: 8, quantity: 4, cardNumber: "OP09-086", name: "Jesus Burgess", color: "black", cost: 5, type: "Character" },
      { id: 9, quantity: 4, cardNumber: "OP10-082", name: "Kuzan", color: "black", cost: 5, type: "Character" },
      { id: 10, quantity: 4, cardNumber: "OP09-083", name: "Van Augur", color: "black", cost: 3, type: "Character" },
      { id: 11, quantity: 4, cardNumber: "OP09-093", name: "Marshall D. Teach", color: "black", cost: 7, type: "Character" },
      { id: 12, quantity: 3, cardNumber: "OP09-096", name: "My Era...Begins!!", color: "black", cost: 1, type: "Event" },
      { id: 13, quantity: 3, cardNumber: "OP09-098", name: "Black Hole", color: "black", cost: 2, type: "Event" },
      { id: 14, quantity: 4, cardNumber: "EB01-051", name: "Six Powers: Shigan", color: "black", cost: 4, type: "Event" },
      { id: 15, quantity: 4, cardNumber: "OP09-099", name: "Fullalead", color: "black", cost: 3, type: "Stage" }
    ] as DeckCard[]
  },
  {
    id: 2,
    name: "Blue Control",
    player: "UnlikelyHero",
    placement: "1st Place (9-0)",
    tournamentName: "Pasadena Regional",
    date: "2024-04-01",
    tier: {
      tier: "S",
      description: "Blue Control decks have been a consistent force in the meta with their powerful disruption and strong counter play. Nami's ability to generate card advantage combined with Blue's powerful removal and counter spells makes this deck extremely difficult to overcome."
    } as TierData,
    leader: {
      id: 201,
      name: "Nami",
      cardNumber: "OP03-040",
      color: "blue",
      imagePath: "/images/cards/OP03/OP03-040.jpg"
    },
    stats: {
      winRate: 95.0,
      pickRate: 0.22,
      avgPlace: 1.5,
      top4: 85.7
    },
    previewCards: [
      { id: 202, cardNumber: "OP04-041", imagePath: "/images/cards/OP04/OP04-041.jpg" },
      { id: 203, cardNumber: "OP09-050", imagePath: "/images/cards/OP09/OP09-050.jpg" },
      { id: 204, cardNumber: "OP01-088", imagePath: "/images/cards/OP01/OP01-088.jpg" },
      { id: 205, cardNumber: "OP06-059", imagePath: "/images/cards/OP06/OP06-059.jpg" }
    ],
    deckList: [
      { id: 201, quantity: 1, cardNumber: "OP03-040", name: "Nami", color: "blue", cost: 5, type: "Leader" },
      { id: 202, quantity: 4, cardNumber: "OP04-041", name: "Apis", color: "blue", cost: 2, type: "Character" },
      { id: 203, quantity: 4, cardNumber: "OP03-044", name: "Kaya", color: "blue", cost: 2, type: "Character" },
      { id: 204, quantity: 4, cardNumber: "OP09-050", name: "Nami", color: "blue", cost: 3, type: "Character" },
      { id: 205, quantity: 2, cardNumber: "OP04-050", name: "Hanger", color: "blue", cost: 4, type: "Character" },
      { id: 206, quantity: 2, cardNumber: "OP03-048", name: "Nojiko", color: "blue", cost: 3, type: "Character" },
      { id: 207, quantity: 4, cardNumber: "OP01-088", name: "Desert Spada", color: "blue", cost: 1, type: "Event" },
      { id: 208, quantity: 4, cardNumber: "OP03-054", name: "Usopp's Rubber Band of Doom!!!", color: "blue", cost: 1, type: "Event" },
      { id: 209, quantity: 4, cardNumber: "OP03-055", name: "Gum-Gum Giant Gavel", color: "blue", cost: 1, type: "Event" },
      { id: 210, quantity: 4, cardNumber: "OP02-066", name: "Impel Down All Stars", color: "blue", cost: 2, type: "Event" },
      { id: 211, quantity: 2, cardNumber: "OP07-055", name: "Snake Dance", color: "blue", cost: 2, type: "Event" },
      { id: 212, quantity: 4, cardNumber: "ST03-017", name: "Love-Love Mellow", color: "blue", cost: 3, type: "Event" },
      { id: 213, quantity: 4, cardNumber: "OP06-059", name: "White Snake", color: "blue", cost: 3, type: "Event" },
      { id: 214, quantity: 2, cardNumber: "OP02-067", name: "Arabesque Brick Fist", color: "blue", cost: 4, type: "Event" },
      { id: 215, quantity: 4, cardNumber: "OP03-056", name: "Sanji's Pilaf", color: "blue", cost: 3, type: "Event" },
      { id: 216, quantity: 1, cardNumber: "OP02-069", name: "DEATH WINK", color: "blue", cost: 5, type: "Event" },
      { id: 217, quantity: 1, cardNumber: "OP06-058", name: "Gravity Blade Raging Tiger", color: "blue", cost: 5, type: "Event" }
    ] as DeckCard[]
  },
  {
    id: 3,
    name: "Wano Country",
    player: "Egoist",
    placement: "2nd Place (8-1)",
    tournamentName: "Pasadena Regional",
    date: "2024-04-01",
    tier: {
      tier: "S",
      description: "Purple Luffy borderline makes S tier mostly because of its strong Blackbeard matchup. Being the fastest deck in the meta gives you a win condition even against your bad matchups. Purple Luffy may no longer be the fastest deck but it can still end the game quicker than most decks."
    } as TierData,
    leader: {
      id: 301,
      name: "Monkey D. Luffy",
      cardNumber: "OP05-060",
      color: "purple",
      imagePath: "/images/cards/OP05/OP05-060.jpg"
    },
    stats: {
      winRate: 90.2,
      pickRate: 0.18,
      avgPlace: 2.1,
      top4: 82.3
    },
    previewCards: [
      { id: 302, cardNumber: "OP09-069", imagePath: "/images/cards/OP09/OP09-069.jpg" },
      { id: 303, cardNumber: "ST18-005", imagePath: "/images/cards/ST18/ST18-005.jpg" },
      { id: 304, cardNumber: "OP09-078", imagePath: "/images/cards/OP09/OP09-078.jpg" },
      { id: 305, cardNumber: "OP02-085", imagePath: "/images/cards/OP02/OP02-085.jpg" }
    ],
    deckList: [
      { id: 301, quantity: 1, cardNumber: "OP05-060", name: "Monkey D. Luffy", color: "purple", cost: 6, type: "Leader" },
      { id: 302, quantity: 4, cardNumber: "OP09-069", name: "Trafalgar Law", color: "purple", cost: 4, type: "Character" },
      { id: 303, quantity: 4, cardNumber: "ST18-001", name: "Uso-Hachi", color: "purple", cost: 2, type: "Character" },
      { id: 304, quantity: 2, cardNumber: "EB01-061", name: "Mr.2 Bon Kurei (Bentham)", color: "purple", cost: 4, type: "Character" },
      { id: 305, quantity: 2, cardNumber: "ST18-002", name: "O-Nami", color: "purple", cost: 2, type: "Character" },
      { id: 306, quantity: 3, cardNumber: "OP06-076", name: "Hitokiri Kamazo", color: "purple", cost: 5, type: "Character" },
      { id: 307, quantity: 4, cardNumber: "ST18-004", name: "Zoro-Juurou", color: "purple", cost: 3, type: "Character" },
      { id: 308, quantity: 4, cardNumber: "ST18-003", name: "San-Gorou", color: "purple", cost: 3, type: "Character" },
      { id: 309, quantity: 4, cardNumber: "OP02-085", name: "Magellan", color: "purple", cost: 7, type: "Character" },
      { id: 310, quantity: 2, cardNumber: "OP09-068", name: "Tony Tony Chopper", color: "purple", cost: 2, type: "Character" },
      { id: 311, quantity: 4, cardNumber: "OP07-064", name: "Sanji", color: "purple", cost: 4, type: "Character" },
      { id: 312, quantity: 3, cardNumber: "OP09-065", name: "Sanji", color: "purple", cost: 3, type: "Character" },
      { id: 313, quantity: 4, cardNumber: "ST18-005", name: "Luffy-Tarou", color: "purple", cost: 5, type: "Character" },
      { id: 314, quantity: 2, cardNumber: "OP08-069", name: "Charlotte Linlin", color: "purple", cost: 7, type: "Character" },
      { id: 315, quantity: 2, cardNumber: "OP09-119", name: "Monkey D. Luffy", color: "purple", cost: 8, type: "Character" },
      { id: 316, quantity: 4, cardNumber: "OP09-078", name: "Gum-Gum Giant", color: "purple", cost: 2, type: "Event" },
      { id: 317, quantity: 2, cardNumber: "OP05-077", name: "Gamma Knife", color: "purple", cost: 3, type: "Event" }
    ] as DeckCard[]
  },
  {
    id: 4,
    name: "Warlord Control",
    player: "Asa's Laptop",
    placement: "3rd Place (8-1)",
    tournamentName: "Pasadena Regional",
    date: "2024-04-01",
    tier: {
      tier: "A",
      description: "Blue Doflamingo was an S tier deck that gets bumped down to the top of A tier because although it's much weaker due to recent bans, it's still a strong deck that will top tournaments. It has a strong Blackbeard matchup but can be poor into the field, losing to random decks like Buggy or Red/Green Smoker."
    } as TierData,
    leader: {
      id: 401,
      name: "Donquixote Doflamingo",
      cardNumber: "OP01-060",
      color: "blue",
      imagePath: "/images/cards/OP01/OP01-060.jpg"
    },
    stats: {
      winRate: 87.5,
      pickRate: 0.12,
      avgPlace: 2.8,
      top4: 76.9
    },
    previewCards: [
      { id: 402, cardNumber: "OP07-046", imagePath: "/images/cards/OP07/OP07-046.jpg" },
      { id: 403, cardNumber: "ST03-004", imagePath: "/images/cards/ST03/ST03-004.jpg" },
      { id: 404, cardNumber: "ST03-005", imagePath: "/images/cards/ST03/ST03-005.jpg" },
      { id: 405, cardNumber: "EB01-023", imagePath: "/images/cards/EB01/EB01-023.jpg" }
    ],
    deckList: [
      { id: 401, quantity: 1, cardNumber: "OP01-060", name: "Donquixote Doflamingo", color: "blue", cost: 6, type: "Leader" },
      { id: 402, quantity: 4, cardNumber: "OP07-046", name: "Sengoku", color: "blue", cost: 5, type: "Character" },
      { id: 403, quantity: 4, cardNumber: "OP01-077", name: "Perona", color: "blue", cost: 3, type: "Character" },
      { id: 404, quantity: 4, cardNumber: "ST17-003", name: "Buggy", color: "blue", cost: 2, type: "Character" },
      { id: 405, quantity: 4, cardNumber: "ST17-005", name: "Marshall D. Teach", color: "blue", cost: 4, type: "Character" },
      { id: 406, quantity: 2, cardNumber: "OP06-047", name: "Charlotte Pudding", color: "blue", cost: 3, type: "Character" },
      { id: 407, quantity: 3, cardNumber: "OP07-040", name: "Crocodile", color: "blue", cost: 3, type: "Character" },
      { id: 408, quantity: 4, cardNumber: "ST03-004", name: "Gecko Moria", color: "blue", cost: 4, type: "Character" },
      { id: 409, quantity: 4, cardNumber: "ST17-002", name: "Trafalgar Law", color: "blue", cost: 4, type: "Character" },
      { id: 410, quantity: 4, cardNumber: "ST03-005", name: "Dracule Mihawk", color: "blue", cost: 5, type: "Character" },
      { id: 411, quantity: 4, cardNumber: "EB01-023", name: "Edward Weevil", color: "blue", cost: 6, type: "Character" },
      { id: 412, quantity: 4, cardNumber: "ST17-004", name: "Boa Hancock", color: "blue", cost: 6, type: "Character" },
      { id: 413, quantity: 4, cardNumber: "OP08-047", name: "Jozu", color: "blue", cost: 5, type: "Character" },
      { id: 414, quantity: 3, cardNumber: "OP04-056", name: "Gum-Gum Red Roc", color: "blue", cost: 4, type: "Event" },
      { id: 415, quantity: 2, cardNumber: "OP06-058", name: "Gravity Blade Raging Tiger", color: "blue", cost: 5, type: "Event" }
    ] as DeckCard[]
  },
  {
    id: 5,
    name: "Supernovas",
    player: "Mr Mexicant",
    placement: "4th Place (8-1)",
    tournamentName: "Pasadena Regional",
    date: "2024-04-01",
    tier: {
      tier: "B",
      description: "Kid is joining the meta as one of the new powerful leaders from OP10. The deck features a synergistic collection of Supernovas that create powerful combos and board states."
    } as TierData,
    leader: {
      id: 501,
      name: "Eustass \"Captain\" Kid",
      cardNumber: "OP10-099",
      color: "purple",
      imagePath: "/images/cards/OP10/OP10-099.jpg"
    },
    stats: {
      winRate: 85.2,
      pickRate: 0.16,
      avgPlace: 3.1,
      top4: 75.0
    },
    previewCards: [
      { id: 502, cardNumber: "OP10-108", imagePath: "/images/cards/OP10/OP10-108.jpg" },
      { id: 503, cardNumber: "OP10-111", imagePath: "/images/cards/OP10/OP10-111.jpg" },
      { id: 504, cardNumber: "OP10-114", imagePath: "/images/cards/OP10/OP10-114.jpg" },
      { id: 505, cardNumber: "OP10-119", imagePath: "/images/cards/OP10/OP10-119.jpg" }
    ],
    deckList: [
      { id: 501, quantity: 1, cardNumber: "OP10-099", name: "Eustass \"Captain\" Kid", color: "purple", cost: 5, type: "Leader" },
      { id: 502, quantity: 4, cardNumber: "OP10-108", name: "Scratchmen Apoo", color: "purple", cost: 4, type: "Character" },
      { id: 503, quantity: 4, cardNumber: "OP10-111", name: "Monkey D. Luffy", color: "purple", cost: 5, type: "Character" },
      { id: 504, quantity: 4, cardNumber: "OP10-114", name: "X Drake", color: "purple", cost: 4, type: "Character" },
      { id: 505, quantity: 4, cardNumber: "OP04-100", name: "Capone \"Gang\" Bege", color: "purple", cost: 4, type: "Character" },
      { id: 506, quantity: 2, cardNumber: "OP08-105", name: "Jewelry Bonney", color: "purple", cost: 3, type: "Character" },
      { id: 507, quantity: 4, cardNumber: "OP10-109", name: "Basil Hawkins", color: "purple", cost: 3, type: "Character" },
      { id: 508, quantity: 2, cardNumber: "OP07-107", name: "Franky", color: "purple", cost: 4, type: "Character" },
      { id: 509, quantity: 4, cardNumber: "OP08-106", name: "Nami", color: "purple", cost: 3, type: "Character" },
      { id: 510, quantity: 4, cardNumber: "OP05-105", name: "Satori", color: "purple", cost: 2, type: "Character" },
      { id: 511, quantity: 3, cardNumber: "OP10-101", name: "Urouge", color: "purple", cost: 4, type: "Character" },
      { id: 512, quantity: 2, cardNumber: "OP10-105", name: "Cavendish", color: "purple", cost: 5, type: "Character" },
      { id: 513, quantity: 4, cardNumber: "OP10-119", name: "Trafalgar Law", color: "purple", cost: 5, type: "Character" },
      { id: 514, quantity: 2, cardNumber: "OP03-123", name: "Charlotte Katakuri", color: "purple", cost: 7, type: "Character" },
      { id: 515, quantity: 4, cardNumber: "OP10-112", name: "Eustass \"Captain\" Kid", color: "purple", cost: 3, type: "Event" },
      { id: 516, quantity: 3, cardNumber: "OP07-119", name: "Portgas D. Ace", color: "purple", cost: 5, type: "Event" }
    ] as DeckCard[]
  },
  {
    id: 6,
    name: "Straw Hat Pirates",
    player: "Phillip Vu",
    placement: "5th Place (8-1)",
    tournamentName: "Pasadena Regional",
    date: "2024-04-01",
    tier: {
      tier: "S",
      description: "Zoro's back! As a former Zoro grinder, I'm extremely excited to see that one of my favorite characters/leaders is meta-relevant again. The main reasons are: Blackbeard is predicted to be a force in the meta and Zoro's aggressiveness makes it a favorable matchup, the 8c Moria bans have hindered Black decks, and the addition of Gum-Gum Mole Gun gives Zoro cheap removal."
    } as TierData,
    leader: {
      id: 601,
      name: "Roronoa Zoro",
      cardNumber: "OP01-001",
      color: "red",
      imagePath: "/images/cards/OP01/OP01-001.jpg"
    },
    stats: {
      winRate: 84.8,
      pickRate: 0.14,
      avgPlace: 3.4,
      top4: 72.0
    },
    previewCards: [
      { id: 602, cardNumber: "OP01-016", imagePath: "/images/cards/OP01/OP01-016.jpg" },
      { id: 603, cardNumber: "OP01-025", imagePath: "/images/cards/OP01/OP01-025.jpg" },
      { id: 604, cardNumber: "ST21-014", imagePath: "/images/cards/ST21/ST21-014.jpg" },
      { id: 605, cardNumber: "OP01-029", imagePath: "/images/cards/OP01/OP01-029.jpg" }
    ],
    deckList: [
      { id: 601, quantity: 1, cardNumber: "OP01-001", name: "Roronoa Zoro", color: "red", cost: 5, type: "Leader" },
      { id: 602, quantity: 4, cardNumber: "OP02-015", name: "Makino", color: "red", cost: 2, type: "Character" },
      { id: 603, quantity: 2, cardNumber: "ST01-006", name: "Tony Tony Chopper", color: "red", cost: 2, type: "Character" },
      { id: 604, quantity: 4, cardNumber: "OP02-016", name: "Magura", color: "red", cost: 3, type: "Character" },
      { id: 605, quantity: 4, cardNumber: "OP01-016", name: "Nami", color: "red", cost: 3, type: "Character" },
      { id: 606, quantity: 4, cardNumber: "OP03-008", name: "Buggy", color: "red", cost: 3, type: "Character" },
      { id: 607, quantity: 4, cardNumber: "OP02-005", name: "Curly Dadan", color: "red", cost: 2, type: "Character" },
      { id: 608, quantity: 3, cardNumber: "ST01-011", name: "Brook", color: "red", cost: 4, type: "Character" },
      { id: 609, quantity: 3, cardNumber: "OP01-013", name: "Sanji", color: "red", cost: 3, type: "Character" },
      { id: 610, quantity: 4, cardNumber: "OP10-005", name: "Sanji", color: "red", cost: 3, type: "Character" },
      { id: 611, quantity: 4, cardNumber: "OP01-025", name: "Roronoa Zoro", color: "red", cost: 4, type: "Character" },
      { id: 612, quantity: 4, cardNumber: "ST21-014", name: "Monkey D. Luffy", color: "red", cost: 5, type: "Character" },
      { id: 613, quantity: 2, cardNumber: "OP04-016", name: "Bad Manners Kick Course", color: "red", cost: 1, type: "Event" },
      { id: 614, quantity: 4, cardNumber: "OP01-029", name: "Radical Beam!!", color: "red", cost: 2, type: "Event" },
      { id: 615, quantity: 2, cardNumber: "ST01-016", name: "Diable Jambe", color: "red", cost: 2, type: "Event" },
      { id: 616, quantity: 2, cardNumber: "ST21-017", name: "Gum-Gum Mole Pistol", color: "red", cost: 2, type: "Event" }
    ] as DeckCard[]
  },
  {
    id: 7,
    name: "Red Power",
    player: "Nicky Goldman's biggest fan",
    placement: "6th Place (8-1)",
    tournamentName: "Pasadena Regional",
    date: "2024-04-01",
    tier: {
      tier: "S",
      description: "Bonney benefits from the ban to 8c Moria as Black decks (like Lucci) were traditionally Bonney's worst matchup. The deck doesn't have to tech hard for that matchup by running cards like 6c Hawkins anymore."
    } as TierData,
    leader: {
      id: 701,
      name: "Jewelry Bonney",
      cardNumber: "OP07-019",
      color: "red",
      imagePath: "/images/cards/OP07/OP07-019.jpg"
    },
    stats: {
      winRate: 83.5,
      pickRate: 0.13,
      avgPlace: 3.6,
      top4: 70.0
    },
    previewCards: [
      { id: 702, cardNumber: "ST02-007", imagePath: "/images/cards/ST02/ST02-007.jpg" },
      { id: 703, cardNumber: "OP05-030", imagePath: "/images/cards/OP05/OP05-030.jpg" },
      { id: 704, cardNumber: "OP10-032", imagePath: "/images/cards/OP10/OP10-032.jpg" },
      { id: 705, cardNumber: "OP01-051", imagePath: "/images/cards/OP01/OP01-051.jpg" }
    ],
    deckList: [
      { id: 701, quantity: 1, cardNumber: "OP07-019", name: "Jewelry Bonney", color: "red", cost: 5, type: "Leader" },
      { id: 702, quantity: 4, cardNumber: "EB01-015", name: "Scratchmen Apoo", color: "red", cost: 3, type: "Character" },
      { id: 703, quantity: 4, cardNumber: "ST02-007", name: "Jewelry Bonney", color: "red", cost: 4, type: "Character" },
      { id: 704, quantity: 4, cardNumber: "OP05-030", name: "Donquixote Rosinante", color: "red", cost: 4, type: "Character" },
      { id: 705, quantity: 2, cardNumber: "OP01-039", name: "Killer", color: "red", cost: 2, type: "Character" },
      { id: 706, quantity: 3, cardNumber: "ST02-008", name: "Scratchmen Apoo", color: "red", cost: 3, type: "Character" },
      { id: 707, quantity: 4, cardNumber: "OP10-032", name: "Tashigi", color: "red", cost: 3, type: "Character" },
      { id: 708, quantity: 2, cardNumber: "OP07-031", name: "Bartolomeo", color: "red", cost: 4, type: "Character" },
      { id: 709, quantity: 4, cardNumber: "OP08-023", name: "Carrot", color: "red", cost: 3, type: "Character" },
      { id: 710, quantity: 1, cardNumber: "OP07-026", name: "Jewelry Bonney", color: "red", cost: 3, type: "Character" },
      { id: 711, quantity: 4, cardNumber: "EB01-012", name: "Cavendish", color: "red", cost: 4, type: "Character" },
      { id: 712, quantity: 3, cardNumber: "OP10-030", name: "Smoker", color: "red", cost: 5, type: "Character" },
      { id: 713, quantity: 4, cardNumber: "OP06-035", name: "Hody Jones", color: "red", cost: 7, type: "Character" },
      { id: 714, quantity: 1, cardNumber: "OP04-119", name: "Donquixote Rosinante", color: "red", cost: 8, type: "Character" },
      { id: 715, quantity: 3, cardNumber: "OP01-051", name: "Eustass \"Captain\" Kid", color: "red", cost: 8, type: "Character" },
      { id: 716, quantity: 1, cardNumber: "OP06-118", name: "Roronoa Zoro", color: "red", cost: 7, type: "Character" },
      { id: 717, quantity: 4, cardNumber: "ST16-004", name: "Shanks", color: "red", cost: 5, type: "Character" },
      { id: 718, quantity: 2, cardNumber: "OP05-037", name: "Because the Side of Justice Will Be Whichever Side Wins!!", color: "red", cost: 1, type: "Event" }
    ] as DeckCard[]
  },
  {
    id: 8,
    name: "Lim Control",
    player: "Thomas",
    placement: "9th Place (8-1)",
    tournamentName: "Pasadena Regional",
    date: "2024-04-01",
    tier: {
      tier: "B",
      description: "A cool aggro version of Lim that forgoes any top-end characters. Instead, you lean into your leader's ability to cheat out characters and swarm the board with 5c/6k characters. You may struggle into 8c Kid decks but can tech for that with cards like Gamma Knife."
    } as TierData,
    leader: {
      id: 801,
      name: "Lim",
      cardNumber: "OP09-022",
      color: "green",
      imagePath: "/images/cards/OP09/OP09-022.jpg"
    },
    stats: {
      winRate: 82.0,
      pickRate: 0.11,
      avgPlace: 4.1,
      top4: 68.5
    },
    previewCards: [
      { id: 802, cardNumber: "OP10-037", imagePath: "/images/cards/OP10/OP10-037.jpg" },
      { id: 803, cardNumber: "OP09-037", imagePath: "/images/cards/OP09/OP09-037.jpg" },
      { id: 804, cardNumber: "OP10-024", imagePath: "/images/cards/OP10/OP10-024.jpg" },
      { id: 805, cardNumber: "OP09-027", imagePath: "/images/cards/OP09/OP09-027.jpg" }
    ],
    deckList: [
      { id: 801, quantity: 1, cardNumber: "OP09-022", name: "Lim", color: "green", cost: 5, type: "Leader" },
      { id: 802, quantity: 4, cardNumber: "OP10-037", name: "Lim", color: "green", cost: 3, type: "Character" },
      { id: 803, quantity: 4, cardNumber: "EB01-015", name: "Scratchmen Apoo", color: "green", cost: 3, type: "Character" },
      { id: 804, quantity: 4, cardNumber: "OP10-033", name: "Nami", color: "green", cost: 2, type: "Character" },
      { id: 805, quantity: 3, cardNumber: "ST18-001", name: "Uso-Hachi", color: "green", cost: 2, type: "Character" },
      { id: 806, quantity: 4, cardNumber: "OP09-037", name: "Lim", color: "green", cost: 4, type: "Character" },
      { id: 807, quantity: 3, cardNumber: "OP09-035", name: "Portgas D. Ace", color: "green", cost: 5, type: "Character" },
      { id: 808, quantity: 4, cardNumber: "OP10-024", name: "Edward Newgate", color: "green", cost: 4, type: "Character" },
      { id: 809, quantity: 4, cardNumber: "OP10-025", name: "Enel", color: "green", cost: 4, type: "Character" },
      { id: 810, quantity: 4, cardNumber: "OP10-029", name: "Dracule Mihawk", color: "green", cost: 5, type: "Character" },
      { id: 811, quantity: 4, cardNumber: "OP09-027", name: "Sabo", color: "green", cost: 4, type: "Character" },
      { id: 812, quantity: 4, cardNumber: "OP09-031", name: "Donquixote Doflamingo", color: "green", cost: 5, type: "Character" },
      { id: 813, quantity: 3, cardNumber: "OP09-026", name: "Sakazuki", color: "green", cost: 5, type: "Character" },
      { id: 814, quantity: 2, cardNumber: "OP09-023", name: "Adio", color: "green", cost: 3, type: "Character" },
      { id: 815, quantity: 3, cardNumber: "ST16-004", name: "Shanks", color: "green", cost: 5, type: "Character" }
    ] as DeckCard[]
  },
  {
    id: 9,
    name: "Red Hair Pirates",
    player: "Airborn",
    placement: "11th Place (7-2)",
    tournamentName: "Pasadena Regional",
    date: "2024-04-01",
    tier: {
      tier: "S",
      description: "Shanks was one of the biggest winners of the ban list. The ban list nerfed some of his bad matchups like Blue Doflamingo, Black Lucci, and Black/Yellow Luffy. Additionally, the decks that are now more relevant (like Bonney) have an unfavorable matchup into Shanks."
    } as TierData,
    leader: {
      id: 901,
      name: "Shanks",
      cardNumber: "OP09-001",
      color: "red",
      imagePath: "/images/cards/OP09/OP09-001.jpg"
    },
    stats: {
      winRate: 80.5,
      pickRate: 0.10,
      avgPlace: 4.5,
      top4: 65.0
    },
    previewCards: [
      { id: 902, cardNumber: "OP09-015", imagePath: "/images/cards/OP09/OP09-015.jpg" },
      { id: 903, cardNumber: "OP09-009", imagePath: "/images/cards/OP09/OP09-009.jpg" },
      { id: 904, cardNumber: "OP09-004", imagePath: "/images/cards/OP09/OP09-004.jpg" },
      { id: 905, cardNumber: "OP09-118", imagePath: "/images/cards/OP09/OP09-118.jpg" }
    ],
    deckList: [
      { id: 901, quantity: 1, cardNumber: "OP09-001", name: "Shanks", color: "red", cost: 6, type: "Leader" },
      { id: 902, quantity: 4, cardNumber: "OP01-006", name: "Otama", color: "red", cost: 2, type: "Character" },
      { id: 903, quantity: 3, cardNumber: "OP09-002", name: "Uta", color: "red", cost: 3, type: "Character" },
      { id: 904, quantity: 3, cardNumber: "OP09-011", name: "Hongo", color: "red", cost: 4, type: "Character" },
      { id: 905, quantity: 3, cardNumber: "OP09-014", name: "Limejuice", color: "red", cost: 4, type: "Character" },
      { id: 906, quantity: 4, cardNumber: "OP10-005", name: "Sanji", color: "red", cost: 3, type: "Character" },
      { id: 907, quantity: 4, cardNumber: "OP10-011", name: "Tony Tony Chopper", color: "red", cost: 2, type: "Character" },
      { id: 908, quantity: 4, cardNumber: "OP09-015", name: "Lucky Roux", color: "red", cost: 5, type: "Character" },
      { id: 909, quantity: 3, cardNumber: "OP09-013", name: "Yasopp", color: "red", cost: 4, type: "Character" },
      { id: 910, quantity: 3, cardNumber: "ST21-014", name: "Monkey D. Luffy", color: "red", cost: 5, type: "Character" },
      { id: 911, quantity: 4, cardNumber: "OP09-009", name: "Benn Beckman", color: "red", cost: 6, type: "Character" },
      { id: 912, quantity: 3, cardNumber: "OP08-118", name: "Silvers Rayleigh", color: "red", cost: 8, type: "Character" },
      { id: 913, quantity: 4, cardNumber: "OP07-015", name: "Monkey D. Dragon", color: "red", cost: 6, type: "Character" },
      { id: 914, quantity: 3, cardNumber: "OP09-004", name: "Shanks", color: "red", cost: 7, type: "Character" },
      { id: 915, quantity: 1, cardNumber: "OP09-118", name: "Gol D. Roger", color: "red", cost: 8, type: "Character" },
      { id: 916, quantity: 2, cardNumber: "OP04-016", name: "Bad Manners Kick Course", color: "red", cost: 1, type: "Event" },
      { id: 917, quantity: 2, cardNumber: "OP01-026", name: "Gum-Gum Fire-Fist Pistol Red Hawk", color: "red", cost: 3, type: "Event" }
    ] as DeckCard[]
  },
  {
    id: 10,
    name: "Charlotte Family",
    player: "Nobu",
    placement: "17th Place (7-2)",
    tournamentName: "Pasadena Regional",
    date: "2024-04-01",
    tier: {
      tier: "B",
      description: "Charlotte Katakuri leads a powerful family-themed deck with multiple combo pieces. The deck has good board presence but struggles against more aggressive strategies."
    } as TierData,
    leader: {
      id: 1001,
      name: "Charlotte Katakuri",
      cardNumber: "OP03-099",
      color: "purple",
      imagePath: "/images/cards/OP03/OP03-099.jpg"
    },
    stats: {
      winRate: 78.0,
      pickRate: 0.09,
      avgPlace: 5.1,
      top4: 60.0
    },
    previewCards: [
      { id: 1002, cardNumber: "OP03-112", imagePath: "/images/cards/OP03/OP03-112.jpg" },
      { id: 1003, cardNumber: "OP03-113", imagePath: "/images/cards/OP03/OP03-113.jpg" },
      { id: 1004, cardNumber: "ST07-010", imagePath: "/images/cards/ST07/ST07-010.jpg" },
      { id: 1005, cardNumber: "OP03-114", imagePath: "/images/cards/OP03/OP03-114.jpg" }
    ],
    deckList: [
      { id: 1001, quantity: 1, cardNumber: "OP03-099", name: "Charlotte Katakuri", color: "purple", cost: 6, type: "Leader" },
      { id: 1002, quantity: 4, cardNumber: "OP03-112", name: "Charlotte Pudding", color: "purple", cost: 3, type: "Character" },
      { id: 1003, quantity: 4, cardNumber: "OP06-101", name: "O-Nami", color: "purple", cost: 3, type: "Character" },
      { id: 1004, quantity: 4, cardNumber: "OP04-100", name: "Capone \"Gang\" Bege", color: "purple", cost: 4, type: "Character" },
      { id: 1005, quantity: 4, cardNumber: "ST20-003", name: "Charlotte Brulee", color: "purple", cost: 3, type: "Character" },
      { id: 1006, quantity: 4, cardNumber: "OP03-113", name: "Charlotte Perospero", color: "purple", cost: 4, type: "Character" },
      { id: 1007, quantity: 4, cardNumber: "OP06-104", name: "Kikunojo", color: "purple", cost: 4, type: "Character" },
      { id: 1008, quantity: 4, cardNumber: "OP08-106", name: "Nami", color: "purple", cost: 3, type: "Character" },
      { id: 1009, quantity: 4, cardNumber: "OP05-105", name: "Satori", color: "purple", cost: 2, type: "Character" },
      { id: 1010, quantity: 4, cardNumber: "OP05-102", name: "Gedatsu", color: "purple", cost: 3, type: "Character" },
      { id: 1011, quantity: 2, cardNumber: "ST07-010", name: "Charlotte Linlin", color: "purple", cost: 7, type: "Character" },
      { id: 1012, quantity: 2, cardNumber: "OP03-123", name: "Charlotte Katakuri", color: "purple", cost: 7, type: "Character" },
      { id: 1013, quantity: 4, cardNumber: "OP03-114", name: "Charlotte Linlin", color: "purple", cost: 6, type: "Character" },
      { id: 1014, quantity: 4, cardNumber: "OP06-115", name: "You're the One Who Should Disappear.", color: "purple", cost: 2, type: "Event" },
      { id: 1015, quantity: 2, cardNumber: "OP03-121", name: "Thunder Bolt", color: "purple", cost: 5, type: "Event" }
    ] as DeckCard[]
  },
  {
    id: 11,
    name: "CP9",
    player: "Squadofturtles",
    placement: "23rd Place (7-2)",
    tournamentName: "Pasadena Regional",
    date: "2024-04-01",
    tier: {
      tier: "A",
      description: "Lucci was an S tier deck that gets bumped down to the top of A tier because of the bans, but it's still a strong deck. It has a poor Blackbeard matchup but is pretty good into the field. This deck can be strong and may be slightly underrated."
    } as TierData,
    leader: {
      id: 1101,
      name: "Rob Lucci",
      cardNumber: "OP07-079",
      color: "black",
      imagePath: "/images/cards/OP07/OP07-079.jpg"
    },
    stats: {
      winRate: 76.0,
      pickRate: 0.08,
      avgPlace: 5.5,
      top4: 55.0
    },
    previewCards: [
      { id: 1102, cardNumber: "OP03-081", imagePath: "/images/cards/OP03/OP03-081.jpg" },
      { id: 1103, cardNumber: "OP05-093", imagePath: "/images/cards/OP05/OP05-093.jpg" },
      { id: 1104, cardNumber: "OP08-091", imagePath: "/images/cards/OP08/OP08-091.jpg" },
      { id: 1105, cardNumber: "OP07-096", imagePath: "/images/cards/OP07/OP07-096.jpg" }
    ],
    deckList: [
      { id: 1101, quantity: 1, cardNumber: "OP07-079", name: "Rob Lucci", color: "black", cost: 6, type: "Leader" },
      { id: 1102, quantity: 2, cardNumber: "OP05-088", name: "Mansherry", color: "black", cost: 2, type: "Character" },
      { id: 1103, quantity: 4, cardNumber: "ST08-002", name: "Uta", color: "black", cost: 3, type: "Character" },
      { id: 1104, quantity: 2, cardNumber: "EB01-043", name: "Spandine", color: "black", cost: 3, type: "Character" },
      { id: 1105, quantity: 4, cardNumber: "EB01-046", name: "Brook", color: "black", cost: 3, type: "Character" },
      { id: 1106, quantity: 1, cardNumber: "OP02-098", name: "Koby", color: "black", cost: 3, type: "Character" },
      { id: 1107, quantity: 3, cardNumber: "ST06-008", name: "Hina", color: "black", cost: 3, type: "Character" },
      { id: 1108, quantity: 4, cardNumber: "OP05-091", name: "Rebecca", color: "black", cost: 3, type: "Character" },
      { id: 1109, quantity: 4, cardNumber: "OP03-081", name: "Kalifa", color: "black", cost: 3, type: "Character" },
      { id: 1110, quantity: 3, cardNumber: "EB01-048", name: "Laboon", color: "black", cost: 3, type: "Character" },
      { id: 1111, quantity: 3, cardNumber: "OP02-096", name: "Kuzan", color: "black", cost: 6, type: "Character" },
      { id: 1112, quantity: 4, cardNumber: "OP05-093", name: "Rob Lucci", color: "black", cost: 5, type: "Character" },
      { id: 1113, quantity: 4, cardNumber: "OP08-091", name: "Who's Who", color: "black", cost: 5, type: "Character" },
      { id: 1114, quantity: 1, cardNumber: "OP04-083", name: "Sabo", color: "black", cost: 5, type: "Character" },
      { id: 1115, quantity: 2, cardNumber: "OP06-092", name: "Brook", color: "black", cost: 5, type: "Character" },
      { id: 1116, quantity: 2, cardNumber: "OP08-084", name: "Jack", color: "black", cost: 6, type: "Character" },
      { id: 1117, quantity: 3, cardNumber: "OP08-079", name: "Kaido", color: "black", cost: 8, type: "Character" },
      { id: 1118, quantity: 4, cardNumber: "OP07-096", name: "Tempest Kick", color: "black", cost: 1, type: "Event" }
    ] as DeckCard[]
  },
  {
    id: 12,
    name: "Sky Island",
    player: "Melon",
    placement: "24th Place (7-2)",
    tournamentName: "Pasadena Regional",
    date: "2024-04-01",
    tier: {
      tier: "C",
      description: "The Raigo/Kingdom Come ban puts Enel in a pretty undesirable spot. Raigo was the biggest reason why Enel could compete with the super-late game decks. The ban hurts Enel, but having a good matchup into aggro decks may still make it viable enough."
    } as TierData,
    leader: {
      id: 1201,
      name: "Enel",
      cardNumber: "OP05-098",
      color: "yellow",
      imagePath: "/images/cards/OP05/OP05-098.jpg"
    },
    stats: {
      winRate: 75.0,
      pickRate: 0.07,
      avgPlace: 5.8,
      top4: 52.0
    },
    previewCards: [
      { id: 1202, cardNumber: "OP05-100", imagePath: "/images/cards/OP05/OP05-100.jpg" },
      { id: 1203, cardNumber: "OP07-119", imagePath: "/images/cards/OP07/OP07-119.jpg" },
      { id: 1204, cardNumber: "OP10-116", imagePath: "/images/cards/OP10/OP10-116.jpg" },
      { id: 1205, cardNumber: "EB01-060", imagePath: "/images/cards/EB01/EB01-060.jpg" }
    ],
    deckList: [
      { id: 1201, quantity: 1, cardNumber: "OP05-098", name: "Enel", color: "yellow", cost: 6, type: "Leader" },
      { id: 1202, quantity: 3, cardNumber: "EB01-056", name: "Charlotte Flampe", color: "yellow", cost: 1, type: "Character" },
      { id: 1203, quantity: 2, cardNumber: "EB01-057", name: "Shirahoshi", color: "yellow", cost: 2, type: "Character" },
      { id: 1204, quantity: 4, cardNumber: "OP10-114", name: "X Drake", color: "yellow", cost: 4, type: "Character" },
      { id: 1205, quantity: 4, cardNumber: "OP04-100", name: "Capone \"Gang\" Bege", color: "yellow", cost: 4, type: "Character" },
      { id: 1206, quantity: 2, cardNumber: "OP07-107", name: "Franky", color: "yellow", cost: 4, type: "Character" },
      { id: 1207, quantity: 4, cardNumber: "OP07-109", name: "Monkey D. Luffy", color: "yellow", cost: 5, type: "Character" },
      { id: 1208, quantity: 2, cardNumber: "ST13-011", name: "Portgas D. Ace", color: "yellow", cost: 5, type: "Character" },
      { id: 1209, quantity: 4, cardNumber: "OP05-100", name: "Enel", color: "yellow", cost: 5, type: "Character" },
      { id: 1210, quantity: 4, cardNumber: "OP03-123", name: "Charlotte Katakuri", color: "yellow", cost: 7, type: "Character" },
      { id: 1211, quantity: 2, cardNumber: "OP10-112", name: "Eustass \"Captain\" Kid", color: "yellow", cost: 3, type: "Event" },
      { id: 1212, quantity: 3, cardNumber: "OP04-112", name: "Yamato", color: "yellow", cost: 7, type: "Character" },
      { id: 1213, quantity: 4, cardNumber: "OP07-119", name: "Portgas D. Ace", color: "yellow", cost: 5, type: "Event" },
      { id: 1214, quantity: 4, cardNumber: "OP06-115", name: "You're the One Who Should Disappear.", color: "yellow", cost: 2, type: "Event" },
      { id: 1215, quantity: 4, cardNumber: "OP10-116", name: "Damned Punk", color: "yellow", cost: 5, type: "Event" },
      { id: 1216, quantity: 4, cardNumber: "EB01-060", name: "Did Someone Say...Kami?", color: "yellow", cost: 4, type: "Event" }
    ] as DeckCard[]
  }
];

// Define DeckData interface used by TierListVisual
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

export default function TopDecksPage() {
  const [activeTab, setActiveTab] = useState("top")
  const [searchTerm, setSearchTerm] = useState("")
  const [expandedDeckId, setExpandedDeckId] = useState<number | null>(null)
  const [filteredDecks, setFilteredDecks] = useState(mockTopDecks)
  const { user } = useAuth()
  const [tierListDialogOpen, setTierListDialogOpen] = useState(false);

  // Get S-tier decks for featured section (limit to 3)
  const featuredDecks = React.useMemo(() => {
    return mockTopDecks
      .filter(deck => deck.tier?.tier === "S")
      .sort((a, b) => b.stats.winRate - a.stats.winRate)
      .slice(0, 3);
  }, []);
  
  // Get remaining decks for the normal list
  const remainingDecks = React.useMemo(() => {
    const featuredIds = featuredDecks.map(deck => deck.id);
    return mockTopDecks.filter(deck => !featuredIds.includes(deck.id));
  }, [featuredDecks]);
  
  // Filter decks based on search term
  useEffect(() => {
    if (!searchTerm.trim()) {
      setFilteredDecks(remainingDecks)
    } else {
      const lowerCaseSearch = searchTerm.toLowerCase()
      const filtered = mockTopDecks.filter(deck => 
        deck.name.toLowerCase().includes(lowerCaseSearch) ||
        deck.player.toLowerCase().includes(lowerCaseSearch) ||
        deck.leader.name.toLowerCase().includes(lowerCaseSearch)
      )
      setFilteredDecks(filtered)
    }
  }, [searchTerm, remainingDecks])

  // Toggle expanded deck
  const toggleDeckExpanded = (deckId: number) => {
    setExpandedDeckId(expandedDeckId === deckId ? null : deckId)
  }

  // Helper function to get tier badge style
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

  return (
    <div className="w-full max-w-7xl">
      <motion.div
        className="flex flex-col gap-6"
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ duration: 0.5 }}
      >
        {/* Header Section */}
        <div className="flex justify-between items-center">
          <div className="flex flex-col gap-1">
            <h1 className="text-3xl font-bold text-red-600 dark:text-red-500">
              One Piece TCG Meta Decks
            </h1>
            <p className="text-gray-600 dark:text-gray-400">
              Discover the best One Piece TCG decks in the current meta, updated regularly with tournament results.
            </p>
          </div>
          
          {/* Updated button to open visual tier list */}
          <Dialog open={tierListDialogOpen} onOpenChange={setTierListDialogOpen}>
            <DialogTrigger asChild>
              <Button variant="outline" className="whitespace-nowrap">
                View Tier List
              </Button>
            </DialogTrigger>
            <DialogContent className="max-w-6xl max-h-[90vh]">
              <DialogHeader>
                <DialogTitle>OP10 Post Ban Meta - Tier List</DialogTitle>
                <DialogDescription>
                  Visual tier list based on recent tournament performance.
                </DialogDescription>
              </DialogHeader>
              <ScrollArea className="pr-4">
                <TierListVisual decks={mockTopDecks as TierDeck[]} />
              </ScrollArea>
              <DialogFooter>
                <Button variant="outline" onClick={() => setTierListDialogOpen(false)}>Close</Button>
              </DialogFooter>
            </DialogContent>
          </Dialog>
        </div>

        {/* Tabs and Search Controls */}
        <div className="flex flex-col md:flex-row gap-4 justify-between items-start md:items-center bg-white dark:bg-gray-900 p-3 rounded-lg shadow-sm">
          <Tabs value={activeTab} onValueChange={setActiveTab} className="w-full md:w-auto">
            <TabsList className="bg-gray-100 dark:bg-gray-800">
              <TabsTrigger value="top" className="data-[state=active]:bg-white dark:data-[state=active]:bg-gray-700">Top Decks</TabsTrigger>
              <TabsTrigger value="tournaments" className="data-[state=active]:bg-white dark:data-[state=active]:bg-gray-700">Tournaments</TabsTrigger>
            </TabsList>
          </Tabs>

          <div className="flex flex-col sm:flex-row w-full md:w-auto gap-2">
            <div className="relative flex-1 sm:w-[250px]">
              <Search className="absolute left-2.5 top-1/2 transform -translate-y-1/2 h-4 w-4 text-gray-400" />
              <Input 
                placeholder="Search decks..." 
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                className="pl-8 w-full"
              />
            </div>

            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="outline" className="w-full sm:w-auto">
                  <Filter className="h-4 w-4 mr-2" /> Filter
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent>
                <DropdownMenuItem>All Colors</DropdownMenuItem>
                <DropdownMenuItem>Red Decks (3)</DropdownMenuItem>
                <DropdownMenuItem>Blue Decks (2)</DropdownMenuItem>
                <DropdownMenuItem>Green Decks (1)</DropdownMenuItem>
                <DropdownMenuItem>Purple Decks (3)</DropdownMenuItem>
                <DropdownMenuItem>Black Decks (2)</DropdownMenuItem>
                <DropdownMenuItem>Yellow Decks (1)</DropdownMenuItem>
              </DropdownMenuContent>
            </DropdownMenu>

            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="outline" className="w-full sm:w-auto">
                  <SortDesc className="h-4 w-4 mr-2" /> Sort
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent>
                <DropdownMenuItem>Tournament Placement</DropdownMenuItem>
                <DropdownMenuItem>Win Rate</DropdownMenuItem>
                <DropdownMenuItem>Color</DropdownMenuItem>
                <DropdownMenuItem>Player Name</DropdownMenuItem>
              </DropdownMenuContent>
            </DropdownMenu>
          </div>
        </div>

        {/* Meta Stats Banner */}
        <Card className="bg-gradient-to-r from-gray-950 to-gray-900 text-white border-none shadow-md overflow-hidden">
          <CardContent className="p-4">
            <div className="flex flex-wrap justify-between items-center">
              <div className="flex flex-col">
                <h3 className="text-lg font-bold">Current Format</h3>
                <p className="text-gray-300">OP 09-10 Meta</p>
              </div>
              <Badge variant="secondary" className="bg-yellow-500 text-black hover:bg-yellow-600 font-medium">
                Last Updated: April 1, 2024
              </Badge>
              <div className="flex flex-col text-right">
                <span className="text-sm text-gray-300">Top Meta Decks</span>
                <span className="text-3xl font-bold">12</span>
              </div>
            </div>
          </CardContent>
        </Card>

        {/* Featured S-Tier Decks */}
        {featuredDecks.length > 0 && (
          <div className="mb-8">
            <div className="flex items-center gap-2 mb-4">
              <Badge className={`${getTierBadgeStyle("S")} font-bold px-2 py-1`}>S Tier</Badge>
              <h2 className="text-xl font-bold">Top Meta Decks</h2>
            </div>
            
            <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
              {featuredDecks.map((deck, index) => (
                <Card 
                  key={deck.id} 
                  className={`overflow-hidden bg-white dark:bg-gray-900 border border-gray-200 dark:border-gray-800 shadow-md hover:shadow-lg transition-shadow duration-300 ${index === 0 ? 'md:col-span-1' : 'md:col-span-1'}`}
                >
                  <div 
                    className="cursor-pointer h-full flex flex-col" 
                    onClick={() => toggleDeckExpanded(deck.id)}
                  >
                    <div className="relative">
                      {/* Card header with gradient background */}
                      <div className={`h-20 bg-gradient-to-r ${
                        deck.leader.color === 'red' ? 'from-red-600 to-red-800' :
                        deck.leader.color === 'blue' ? 'from-blue-600 to-blue-800' :
                        deck.leader.color === 'green' ? 'from-green-600 to-green-800' :
                        deck.leader.color === 'purple' ? 'from-purple-600 to-purple-800' :
                        deck.leader.color === 'yellow' ? 'from-yellow-600 to-yellow-800' :
                        deck.leader.color === 'black' ? 'from-gray-600 to-gray-800' :
                        'from-gray-600 to-gray-800'
                      }`}>
                        {/* Decorative pattern */}
                        <div className="absolute inset-0 opacity-10 bg-[url('/images/card-pattern.png')]"></div>
                      </div>
                      
                      {/* Leader card positioned over the gradient */}
                      <div className="absolute top-4 left-4 w-24 h-34 rounded-lg overflow-hidden shadow-xl border-2 border-white transform transition-transform hover:scale-105">
                        <img
                          src={deck.leader.imagePath}
                          alt={deck.leader.name}
                          className="w-full h-full object-cover"
                          onError={(e) => {
                            const imgElement = e.target as HTMLImageElement;
                            const currentSrc = imgElement.src;
                            
                            if (currentSrc.endsWith('.jpg')) {
                              imgElement.src = currentSrc.replace('.jpg', '.png');
                            } else {
                              imgElement.src = "https://via.placeholder.com/100x140?text=Leader+Not+Found";
                              imgElement.classList.add('border-red-500');
                            }
                          }}
                        />
                      </div>
                    </div>
                    
                    <div className="flex-grow p-4 flex flex-col">
                      <div className="mt-16">
                        <h3 className="text-lg font-bold">{deck.name}</h3>
                        <p className="text-sm text-gray-500 dark:text-gray-400 mt-1">{deck.player} • {deck.placement}</p>
                        
                        <div className="mt-3 flex flex-wrap items-center gap-3">
                          <div className="flex items-center gap-1.5">
                            <span className="text-sm font-medium">Win Rate:</span>
                            <span className="text-lg font-bold text-green-600">{deck.stats.winRate}%</span>
                          </div>
                          
                          <div className="flex items-center gap-1.5">
                            <span className="text-sm font-medium">Top 4:</span>
                            <span className="text-lg font-bold text-blue-600">{deck.stats.top4}%</span>
                          </div>
                        </div>
                      </div>
                      
                      <div className="mt-4 flex justify-center">
                        <div className="flex gap-1">
                          {deck.previewCards.map(card => (
                            <div key={card.id} className="w-14 h-20 rounded-sm overflow-hidden border border-gray-200 dark:border-gray-700 shadow-sm transform transition-transform hover:translate-y-[-5px]">
                              <img 
                                src={card.imagePath} 
                                alt={`Card ${card.cardNumber}`}
                                className="w-full h-full object-cover"
                                onError={(e) => {
                                  const imgElement = e.target as HTMLImageElement;
                                  const currentSrc = imgElement.src;
                                  
                                  if (currentSrc.endsWith('.jpg')) {
                                    imgElement.src = currentSrc.replace('.jpg', '.png');
                                  } else {
                                    imgElement.src = "https://via.placeholder.com/50x70?text=Card";
                                    imgElement.classList.add('border-red-500');
                                  }
                                }}
                              />
                            </div>
                          ))}
                        </div>
                      </div>
                    </div>
                  </div>
                  
                  {/* Expanded Content */}
                  <AnimatePresence>
                    {expandedDeckId === deck.id && (
                      <motion.div
                        initial={{ height: 0, opacity: 0 }}
                        animate={{ height: 'auto', opacity: 1 }}
                        exit={{ height: 0, opacity: 0 }}
                        transition={{ duration: 0.3 }}
                        className="overflow-hidden"
                      >
                        <CardContent className="p-4 border-t border-gray-200 dark:border-gray-800">
                          <p className="text-sm text-gray-700 dark:text-gray-300 mb-4">
                            {deck.tier?.description}
                          </p>
                          
                          <Button 
                            variant="outline" 
                            className="w-full"
                            onClick={() => setExpandedDeckId(null)}
                          >
                            <ChevronUp className="h-4 w-4 mr-2" />
                            Close
                          </Button>
                        </CardContent>
                      </motion.div>
                    )}
                  </AnimatePresence>
                </Card>
              ))}
            </div>
          </div>
        )}

        {/* All Decks List */}
        <div>
          <h2 className="text-xl font-bold mb-4">All Tournament Decks</h2>
          <ScrollArea className="h-full pr-4 pb-16">
            <div className="space-y-4">
              <AnimatePresence>
                {filteredDecks.map(deck => (
                  <DeckSidebar 
                    key={deck.id}
                    deck={deck}
                    isExpanded={expandedDeckId === deck.id}
                    onToggleExpand={() => toggleDeckExpanded(deck.id)}
                    isAuthenticated={!!user}
                  />
                ))}
              </AnimatePresence>

              {filteredDecks.length === 0 && (
                <Card className="p-8 text-center">
                  <CardContent>
                    <p className="text-gray-500 dark:text-gray-400">No decks found matching your search criteria.</p>
                  </CardContent>
                </Card>
              )}
            </div>
          </ScrollArea>
        </div>
      </motion.div>
    </div>
  )
} 