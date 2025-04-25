# RTCG One Piece Card Library - Task Tracker

## Project Overview
The RTCG One Piece Card Library is a web application that allows users to view and search for cards from the One Piece Card Game. The application provides various search functionalities including filtering by color, cost, set, affiliations, and other card attributes.

## Current Status
- All 10 OP sets (OP01-OP10) imported (via initializers)
- Spring Boot backend with /api/cards endpoint (supports basic filtering)
- Next.js frontend with Shadcn UI created in `/frontend` directory
- Frontend fetches cards and displays them in a grid
- Card modal popup implemented on click
- Client-side filtering implemented for Search, Color, Cost, Type, Counter, Set
- Images are served from `/frontend/public`
- Navbar logo reverted to text and styled
- Modern deck statistics view with improved UI/charting
- Deck export functionality for sharing decklists
- Intelligent tab synchronization between card browser and deck views
- Authentication gating for deck save functionality

## Remaining Tasks
- **Deck Builder Feature (See Section Below)**
- **User Authentication (See Section Below)**
- Complete importing all 21 starter decks (ST01-ST21)
- Implement backend filtering API and integrate with frontend
- Complete remaining UI filtering/sorting functionality (Keywords, Sort, Legality, Power, etc.)
- General UI/UX improvements (see section below)


## Deck Builder Tasks
- **Backend:**
    - [x] Design DB Schema (Decks, DeckCards)
    - [x] Create `Deck`, `DeckCard` Entities (Linked to User)
    - [x] Create `DeckRepository` (With user lookup)
    - [x] Create `DeckController` (Basic CRUD, User-specific operations)
    - [ ] Refine backend validation (deck rules, etc.)
- **Frontend Page:**
    - [x] Create `/deck-builder` route and page component (in separate project)
    - [ ] Integrate Deck Builder into main frontend (`/deck-builder` route)
- **Frontend UI:**
    - [x] Design/Implement two-column layout (Library View | Deck View)
    - [x] Implement Deck View UI (Leader Slot, Main Deck List, Stats, Name, Buttons)
    - [x] Implement Deck Stats display (Charts, Types)
    - [x] Redesign Deck Stats with modern UI and red color theme
- **Frontend Logic:**
    - [x] Implement client-side state management for the current deck
    - [x] Implement Add/Remove card logic (click, drag-out, drag-stack)
    - [x] Implement deck rule validation (1 Leader, 50 cards, 4 copies max)
    - [x] Implement "Import Deck" functionality (text paste)
    - [x] Implement "Export Deck" functionality (text generation)
    - [x] Implement "Clear Deck" functionality
    - [x] Implement "Save Deck" button functionality (calls backend API)
    - [x] Implement "Load Decks" button, dialog, and fetch list logic
    - [x] Implement "Load Deck" specific deck loading logic
    - [x] Implement "Test Hand" button functionality (draw 5 + leader)
    - [x] Implement silent enforcement of 4-card limit (no alerts)
    - [x] Performance Optimizations (Memoization, Infinite Scroll, Animation Reduction, Lazy Loading)
    - [x] Fix case-sensitive color filtering causing duplicates
- **Integration:**
    - [x] Added Navbar from main frontend
    - [x] Integrate/adapt `CardDisplayArea` for the Library View within Deck Builder
    - [x] Implement tab synchronization between card browser and deck view

## User Authentication Tasks (New Section)
- **Backend:**
    - [x] Add Spring Security Dependency
    - [x] Create `User` Entity
    - [x] Create `UserRepository`
    - [x] Configure `SecurityConfig` (PasswordEncoder, UserDetailsService, basic HTTP rules, CORS)
    - [x] Create `UserService` (registration logic)
    - [x] Create `AuthController` (`/register`, `/me` endpoints)
    - [x] Link `Deck` entity to `User`
    - [x] Update `DeckController` for user association & authorization
- **Frontend (Main):**
    - [x] Create `/register` page and form
    - [x] Create `/login` page and form (using Spring Security form login)
    - [x] Create `useAuth` context/hook
    - [x] Wrap layout with `AuthProvider`
    - [x] Update Navbar to display auth state (Username/Logout or Login/Register)
    - [x] Enhance login/register pages with animated One Piece card backgrounds
    - [x] Add responsive card animations with proper aspect ratios
    - [x] Implement fallback mechanisms for image loading 
    - [x] Add subtle visual effects (gradients, shadows, reflections)
- **Frontend (Deckbuilder):**
    - [x] Replicate `useAuth` hook
    - [x] Replicate `ThemeProvider`
    - [x] Create Root Layout with Providers
    - [x] Update Navbar to display auth state
    - [x] Add login/register prompt for non-authenticated users when saving decks
- **TODO:**
    - [ ] Implement shared auth state between frontends OR merge frontends
    - [ ] Add more robust error handling (backend & frontend)
    - [ ] Consider JWT or other token-based auth instead of sessions if preferred
    - [ ] Implement "My Decks" page/functionality
    - [ ] Implement user roles/permissions if needed

## UI Improvement Tasks (General / Card Search Page)
- **Filtering/Searching:**
    - [x] Implement basic client-side filtering for Search, Color, Cost, Type, Counter, Set
    - [ ] Implement backend filtering API (pass all filter params)
    - [ ] Update frontend (`CardDisplayArea`) to use backend filtering API
    - [ ] Implement Set filtering UI (`FilterSidebar`)
    - [ ] Implement Keyword filtering UI (`FilterSidebar` - Rush, Blocker, KO, etc.)
    - [ ] Implement Power filtering UI
    - [ ] Implement functional Sort dropdown
    - [ ] Implement Legality filter
    - [ ] Add a "Reset Filters" button
    - [ ] Debounce search input
- **Card Display:**
    - [ ] Improve layout/styling of `CardGrid` and `CardItem`
    - [ ] Handle multi-color cards more elegantly
    - [ ] Add loading skeletons/placeholders
    - [ ] Add visual indicator for active filters
- **Card Modal (`CardModal`):**
    - [ ] Improve layout and styling
    - [ ] Add links for affiliations/keywords
- **General:**
    - [x] Render distance implementation (infinite scrolling)
    - [ ] Implement pagination
    - [ ] Add proper error handling display
    - [ ] Improve responsiveness
    - [ ] Refine `Navbar` and `FilterSidebar` components

## Top Decks Page Tasks
- **Backend:**
    - [ ] Create `TopDeck` model (name, player, placement, date, leader, cards, etc.)
    - [ ] Create `TopDeckRepository` interface
    - [ ] Create `TopDeckController` with endpoints (GET all, GET by id, etc.)
    - [ ] Add sample data for testing
- **Frontend Page:**
    - [x] Create `/top-decks` route and page component
    - [x] Design page layout similar to TFT meta comps page
    - [ ] Refine featured decks section layout for better balance -> Change to display top 3 equally
- **Frontend UI Components:**
    - [x] Create `DeckSidebar` component (shows leader, deck name, player, placement)
    - [x] Create `DeckDetails` component (expanded view with deck list and stats)
    - [x] Add "Save to Library" and "Copy Deck Code" buttons
    - [ ] Implement filter/search functionality for decks
    - [ ] Increase number of preview cards in `DeckSidebar` header -> Show 6-8 cards
    - [x] Emphasize Win Rate stat in `DeckSidebar` header
    - [x] Remove Top 4% stat from `DeckSidebar` header
    - [ ] Add "View Tier List Analysis" button and modal -> Change to Visual Tier List
    - [ ] Create `TierListVisual` component for modal display
- **Frontend Logic:**
    - [x] Fetch top decks from API (mock data for now)
    - [x] Implement expand/collapse functionality for deck details
    - [x] Implement "Save to Library" functionality (requires auth)
    - [x] Implement "Copy Deck Code" functionality

## Future Enhancements
- Implement deck image generation for sharing on social media
- Add card rarity and pricing information
- Add image recognition to automatically extract card information
- Create a more intuitive UI for browsing and searching cards
- Add pagination for large result sets
- Add tournament legality information
- Implement card collection tracking
- Add price tracking from various marketplaces

## Set Import Progress
| Set | Status | Notes |
|-----|--------|-------|
| OP01 | ✅ Complete | |
| OP02 | ✅ Complete | |
| OP03 | ✅ Complete | |
| OP04 | ✅ Complete | |
| OP05 | ✅ Complete | |
| OP06 | ✅ Complete | |
| OP07 | ✅ Complete | |
| OP08 | ✅ Complete | |
| OP09 | ✅ Complete | |
| OP10 | ✅ Complete | |

## Starter Deck Import Progress
| Starter Deck | Status | Notes |
|--------------|--------|-------|
| ST01 | ❌ Not Started | |
| ST02 | ❌ Not Started | |
| ST03 | ❌ Not Started | |
| ST04 | ❌ Not Started | |
| ST05 | ❌ Not Started | |
| ST06 | ❌ Not Started | |
| ST07 | ✅ Complete | Big Mom Pirates |
| ST08 | ✅ Complete | Straw Hat Crew / East Blue |
| ST09 | ✅ Complete | Land of Wano |
| ST10 | ✅ Complete | Worst Generation (Heart/Kid/Straw Hat Pirates) |
| ST11 | ✅ Complete | Uta/FILM |
| ST12 | ✅ Complete | Zoro & Sanji/East Blue |
| ST13 | ✅ Complete | ASL Brothers (Ace, Sabo, Luffy) |
| ST14 | ✅ Complete | Straw Hat Crew (Cost-boosting theme) |
| ST15 | ✅ Complete | Whitebeard Pirates |
| ST16 | ✅ Complete | FILM Red / Uta |
| ST17 | ✅ Complete | Seven Warlords of the Sea |
| ST18 | ✅ Complete | Straw Hat Crew (Wano / DON!! focused) |
| ST19 | ✅ Complete | Navy / Marines |
| ST20 | ✅ Complete | Big Mom Pirates |
| ST21 | ✅ Complete | Straw Hat Crew / Egghead |

## Project Structure
- **Backend** (`src/main/...`)
  - `CardManagerApplication.java`
  - `config/` (Initializers, WebConfig)
  - `model/` (`Card.java`)
  - `repository/` (`CardRepository.java`)
  - `controller/` (`CardController.java`)
  - `util/` (`CardBulkImporter.java`)
- **Frontend** (`frontend/`)
  - `app/` (Main pages, layout)
  - `components/` (Reusable UI components: Navbar, FilterSidebar, CardGrid, CardModal, ui/)
  - `lib/` (Utilities, type definitions)
  - `public/` (Static assets, including card images)
  - `package.json`, `next.config.mjs`, `tailwind.config.js`, etc.

## Workflow for Adding New Cards
1. Add card images to `frontend/public/images/cards/{SET_CODE}/` directory (using `.jpg`).
2. Create/update the corresponding initializer in `src/main/java/com/onepiece/cardmanager/config/`.
3. Ensure `setImagePath` uses the correct relative path (e.g., `/images/cards/ST01/ST01-001.jpg`).
4. Delete `cardmanager.db`.
5. Restart backend (`mvn spring-boot:run`).
6. Test in frontend (`pnpm run dev` in `frontend/` directory).
7. Update this Task.md file with progress.

## Card Model Structure
```java
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String cardNumber;
    private Integer life;
    private String cardType;
    private String color;
    private Integer cost;
    private String attribute;
    private String timing;
    @Column(length = 1024) // Increase length if effects are long
    private String effect;
    private String affiliations;
    private Integer power;
    private String imagePath;
    private String set;
    private Integer counter;
    // Add boolean flags if needed for easier querying
    // private boolean isLeaderCard;
    // private boolean isCharacterCard;
    // private boolean isEventCard;
    // private boolean isStageCard;
}
```

## Search Functionalities (Backend API)
- `/api/cards` - Get cards (accepts filter parameters: `searchTerm`, `colors`, `costs`, `types`, `sets`)
- `/api/cards/test/{cardNumber}` - Get single card (temporary)
- *(Need to add support for more filter/sort parameters)*

## Template for New Initializer
When creating a new set initializer, follow this template:
```java
package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(X) // Use the appropriate order number
public class OPXXInitializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public OPXXInitializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only initialize if we have no OPXX cards
        if (cardRepository.countBySetAndCardNumberStartingWith("OPXX", "OPXX") > 0) {
            System.out.println("OPXX cards already exist, skipping initialization");
            return;
        }

        System.out.println("Initializing OPXX cards...");
        
        // Add cards here
        Card card1 = new Card();
        card1.setCardNumber("OPXX-001");
        // Set other attributes
        Card savedCard1 = cardRepository.save(card1);
        System.out.println("Saved card " + savedCard1.getCardNumber() + " with set: " + savedCard1.getSet());
        
        System.out.println("Finished initializing OPXX cards");
    }
}
```

## Notes and Observations
- Card images are now served from `frontend/public/images/`. Ensure paths in initializers are correct.
- Database needs to be deleted (`cardmanager.db`) for initializer changes to take effect.
- Frontend uses client-side filtering currently; needs backend integration.

## Future Enhancements (From Old List)
- Implement deck building functionality
- Add card rarity and pricing information
- Implement user accounts for saving favorite cards and decks
- Add image recognition to automatically extract card information

## Future Enhancements
- Add additional search filters
- Implement deck building functionality
- Add card rarity and pricing information
- Implement user accounts for saving favorite cards and decks
- Add image recognition to automatically extract card information
- Create a more intuitive UI for browsing and searching cards
- Add pagination for large result sets 