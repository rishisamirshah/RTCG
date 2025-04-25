"use client"

import { useState } from "react"
import { ChevronDown, ChevronUp } from "lucide-react"
import { Checkbox } from "@/components/ui/checkbox"
import { Label } from "@/components/ui/label"

// Define props for the sidebar
interface FilterSidebarProps {
  allSets: string[]
  selectedSets: Set<string>
  allStarterDecks?: string[]
  selectedStarterDecks?: Set<string>
  allKeywords: string[]
  selectedKeywords: Set<string>
  onFilterChange: (value: string | number, type: 'color' | 'cost' | 'type' | 'counter' | 'set' | 'starter-deck' | 'keyword') => void
}

export default function FilterSidebar({
  allSets,
  selectedSets,
  allStarterDecks = [],
  selectedStarterDecks = new Set(),
  allKeywords,
  selectedKeywords,
  onFilterChange,
}: FilterSidebarProps) {
  const [expandedSections, setExpandedSections] = useState({
    sets: true,
    starterDecks: true,
    keywords: true,
  })

  const toggleSection = (section: 'sets' | 'starterDecks' | 'keywords') => {
    setExpandedSections((prev) => ({ ...prev, [section]: !prev[section] }))
  }

  return (
    <div className="bg-background rounded-lg border border-gray-200 dark:border-gray-700 overflow-hidden">
      <div className="p-4 border-b border-gray-200 dark:border-gray-700">
        <h2 className="font-bold text-lg text-gray-800 dark:text-gray-200">Filters</h2>
      </div>

      {/* Sets Section - Render dynamically */}
      <FilterSection title="Sets" expanded={expandedSections.sets} onToggle={() => toggleSection("sets")}>
        {allSets.map((set) => (
          <FilterCheckbox
            key={set}
            id={`set-${set}`}
            label={set}
            checked={selectedSets.has(set)}
            onCheckedChange={() => onFilterChange(set, 'set')}
          />
        ))}
      </FilterSection>

      {/* Starter Decks Section - Render dynamically */}
      {allStarterDecks.length > 0 && (
        <FilterSection title="Starter Decks" expanded={expandedSections.starterDecks} onToggle={() => toggleSection("starterDecks")}>
          {allStarterDecks.map((deck) => (
            <FilterCheckbox
              key={deck}
              id={`starter-deck-${deck}`}
              label={deck}
              checked={selectedStarterDecks.has(deck)}
              onCheckedChange={() => onFilterChange(deck, 'starter-deck')}
            />
          ))}
        </FilterSection>
      )}

      {/* Keywords Section - Render dynamically */}
      <FilterSection title="Keywords" expanded={expandedSections.keywords} onToggle={() => toggleSection("keywords")}>
        {allKeywords.map((keyword) => (
          <FilterCheckbox
            key={keyword}
            id={`keyword-${keyword.toLowerCase().replace(/\s+/g, '-')}`}
            label={keyword}
            checked={selectedKeywords.has(keyword)}
            onCheckedChange={() => onFilterChange(keyword, 'keyword')}
          />
        ))}
      </FilterSection>
    </div>
  )
}

// FilterSection component remains largely the same
interface FilterSectionProps {
  title: string
  children: React.ReactNode
  expanded: boolean
  onToggle: () => void
}

function FilterSection({ title, children, expanded, onToggle }: FilterSectionProps) {
  return (
    <div className="border-b border-gray-200 dark:border-gray-700 last:border-b-0">
      <button
        className="flex items-center justify-between w-full p-4 text-left font-medium text-gray-700 dark:text-gray-200 hover:bg-gray-50 dark:hover:bg-gray-800"
        onClick={onToggle}
      >
        {title}
        {expanded ? <ChevronUp className="h-4 w-4" /> : <ChevronDown className="h-4 w-4" />}
      </button>
      {expanded && <div className="px-4 pb-4 space-y-3">{children}</div>}
    </div>
  )
}

// Update FilterCheckbox to use shadcn components and accept props
interface FilterCheckboxProps {
  id: string
  label: string
  checked: boolean
  onCheckedChange: (checked: boolean) => void
}

function FilterCheckbox({ id, label, checked, onCheckedChange }: FilterCheckboxProps) {
  return (
    <div className="flex items-center space-x-2">
      <Checkbox
        id={id}
        checked={checked}
        onCheckedChange={onCheckedChange}
      />
      <Label htmlFor={id} className="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70">
        {label}
      </Label>
    </div>
  )
}
