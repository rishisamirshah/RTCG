import { Search, ChevronDown } from "lucide-react"
import Navbar from "@/components/navbar"
import { Card } from "@/lib/types"
import CardDisplayArea from "@/components/card-display-area"

// Remove the server-side fetching function for now
/*
async function getCards(): Promise<Card[]> {
  try {
    const res = await fetch('http://localhost:8080/api/cards', { cache: 'no-store' });
    if (!res.ok) {
      console.error(`Error fetching cards: ${res.statusText}`);
      return [];
    }
    return res.json();
  } catch (error) {
    console.error("Failed to fetch cards:", error);
    return [];
  }
}
*/

// Page is no longer async
export default function Home() {
  // No initial data fetching or props needed here anymore
  // const initialCards: Card[] = [];

  return (
    <div className="min-h-screen">
      {/* <Navbar /> Removed redundant Navbar here */}
      <main className="container mx-auto px-4 py-6">
        <CardDisplayArea />
      </main>
    </div>
  )
}
