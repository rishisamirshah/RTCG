"use client"

import { useState } from "react"
import Link from "next/link"
import { Menu, X, User, LogOut } from "lucide-react"
import { useAuth } from "@/hooks/useAuth"
import { Button } from "@/components/ui/button"
import { Sheet, SheetContent, SheetHeader } from "@/components/ui/sheet"
import { ThemeToggle } from "@/components/ui/theme-toggle"

export default function Navbar() {
  const [isMenuOpen, setIsMenuOpen] = useState(false)
  const { user, isLoading } = useAuth()

  const handleLogout = () => {
    const form = document.createElement('form')
    form.method = 'POST'
    form.action = '/api/auth/logout'
    document.body.appendChild(form)
    form.submit()
  }

  return (
    <header className="bg-background border-b border-border sticky top-0 z-10">
      <div className="container mx-auto px-4">
        <div className="flex items-center justify-between h-16">
          <div className="flex items-center">
            <Link href="/" className="font-medium text-sm text-red-600 dark:text-red-400">
              RTCG
            </Link>
          </div>

          <nav className="hidden md:flex items-center space-x-1">
            <NavLink href="/" active>CARD SEARCH</NavLink>
            <NavLink href="/deck-builder" active>DECK BUILDER</NavLink>
            <NavLink href="/top-decks">TOP DECKS</NavLink>
            <div className="flex items-center space-x-2 ml-4">
              <ThemeToggle />
              {isLoading ? (
                <span className="text-sm text-muted-foreground">Loading...</span>
              ) : user ? (
                <>
                  <span className="text-sm font-medium text-foreground flex items-center gap-1">
                    <User className="h-4 w-4" />
                    {user.username}
                  </span>
                  <Button variant="ghost" size="sm" onClick={handleLogout} className="text-foreground hover:text-red-600 dark:hover:text-red-400">
                    <LogOut className="h-4 w-4 mr-1" />
                    Logout
                  </Button>
                </>
              ) : (
                <>
                  <NavLink href="/login">LOGIN</NavLink>
                  <NavLink href="/register">REGISTER</NavLink>
                </>
              )}
            </div>
          </nav>

          <div className="md:hidden flex items-center gap-2">
            <ThemeToggle />
            <button className="p-2" onClick={() => setIsMenuOpen(!isMenuOpen)}>
              {isMenuOpen ? <X className="h-6 w-6" /> : <Menu className="h-6 w-6" />}
            </button>
          </div>
        </div>
      </div>

      {isMenuOpen && (
        <div className="md:hidden">
          <div className="px-2 pt-2 pb-3 space-y-1 sm:px-3 bg-background border-b border-border">
            <MobileNavLink href="/" active>CARD SEARCH</MobileNavLink>
            <MobileNavLink href="/deck-builder" active>DECK BUILDER</MobileNavLink>
            <MobileNavLink href="/top-decks">TOP DECKS</MobileNavLink>
            {isLoading ? (
              <span className="block px-3 py-2 text-base font-medium text-muted-foreground">Loading...</span>
            ) : user ? (
              <>
                <span className="block px-3 py-2 text-base font-medium text-foreground flex items-center gap-1">
                  <User className="h-5 w-5 mr-1" />
                  {user.username}
                </span>
                <button onClick={handleLogout} className="block w-full text-left px-3 py-2 text-base font-medium text-foreground hover:text-red-600 dark:hover:text-red-400">
                  <LogOut className="h-5 w-5 mr-1 inline-block" />
                  Logout
                </button>
              </>
            ) : (
              <>
                <MobileNavLink href="/login">LOGIN</MobileNavLink>
                <MobileNavLink href="/register">REGISTER</MobileNavLink>
              </>
            )}
          </div>
        </div>
      )}
    </header>
  )
}

interface NavLinkProps {
  href: string;
  children: React.ReactNode;
  active?: boolean;
}

function NavLink({ href, children, active = false }: NavLinkProps) {
  return (
    <Link
      href={href}
      className={`px-3 py-2 text-sm font-medium transition-colors ${
        active ? "text-red-600 dark:text-red-400 border-b-2 border-red-600 dark:border-red-400" : "text-foreground hover:text-red-600 dark:hover:text-red-400"
      }`}
    >
      {children}
    </Link>
  )
}

interface MobileNavLinkProps {
  href: string;
  children: React.ReactNode;
  active?: boolean;
}

function MobileNavLink({ href, children, active = false }: MobileNavLinkProps) {
  return (
    <Link
      href={href}
      className={`block px-3 py-2 text-base font-medium ${
        active ? "text-red-600 dark:text-red-400" : "text-foreground hover:text-red-600 dark:hover:text-red-400"
      }`}
    >
      {children}
    </Link>
  )
}
