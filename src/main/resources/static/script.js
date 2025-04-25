// Immediately log that the script is loaded
console.log('Script loaded');

// DOM Elements
const cardGrid = document.getElementById('cardGrid');
const modal = document.getElementById('cardModal');
const searchInput = document.getElementById('searchInput');
const colorFilter = document.getElementById('colorFilter');
const costFilter = document.getElementById('costFilter');
const typeFilter = document.getElementById('typeFilter');
const sortFilter = document.getElementById('sortFilter');
const setFilters = document.querySelectorAll('input[type="checkbox"]');

// Log if we found our elements
console.log('Search input found:', searchInput !== null);
console.log('Card grid found:', cardGrid !== null);

// Store all cards for filtering
let allCards = [];

// Show loading indicator
function showLoading() {
    cardGrid.innerHTML = '<div class="loading">Loading cards...</div>';
}

// Hide loading indicator
function hideLoading() {
    const loader = document.querySelector('.loading');
    if (loader) {
        loader.remove();
    }
}

// Fetch cards from the backend with filters
async function fetchCards(filters = {}) {
    showLoading();
    try {
        console.log('Fetching cards with filters:', filters);
        
        // Build query parameters
        const params = new URLSearchParams();
        if (filters.name) params.append('name', filters.name);
        if (filters.cardType) params.append('cardType', filters.cardType);
        if (filters.color) params.append('color', filters.color);
        if (filters.minCost !== undefined) params.append('minCost', filters.minCost);
        if (filters.maxCost !== undefined) params.append('maxCost', filters.maxCost);
        if (filters.effectText) params.append('effectText', filters.effectText);

        const queryString = params.toString();
        console.log('Query string:', queryString);

        // If no filters, use the base endpoint
        const url = queryString ? `/api/cards/search?${queryString}` : '/api/cards';
        console.log('Fetching from URL:', url);

        const response = await fetch(url);
        console.log('Response status:', response.status);
        
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        
        const data = await response.json();
        console.log('Received data:', data);
        
        // Ensure data is an array and contains items
        if (!data || !Array.isArray(data)) {
            throw new Error('Invalid data format received from server');
        }
        
        // Fix image paths for ST06-ST20 cards in the data immediately
        data.forEach(card => {
            if (card.imagePath && card.imagePath.endsWith('.jpg')) {
                // Check if this is an ST06-ST20 card based on the card number or path
                const stMatch = card.imagePath.match(/\/ST(\d+)\/ST\d+-\d+\.jpg$/);
                if (stMatch && stMatch[1] >= 6 && stMatch[1] <= 20) {
                    const originalPath = card.imagePath;
                    card.imagePath = card.imagePath.replace('.jpg', '.png');
                    console.log(`Fixed backend image path for ST${stMatch[1]} card: ${card.cardNumber} - ${originalPath} -> ${card.imagePath}`);
                }
            }
        });
        
        // Store in allCards and display
        allCards = data;
        console.log('Total cards loaded:', allCards.length);
        displayCards(filterCardsLocally());
        
    } catch (error) {
        console.error('Error fetching cards:', error);
        cardGrid.innerHTML = `
            <div class="error-message">
                <h3>Error loading cards</h3>
                <p>${error.message}</p>
                <button onclick="fetchCards()">Try Again</button>
            </div>
        `;
        allCards = [];
    } finally {
        hideLoading();
    }
}

// Local filtering function
function filterCardsLocally() {
    console.log('Filtering cards locally');
    let filteredCards = [...allCards];
    
    const searchText = searchInput.value.toLowerCase().trim();
    console.log('Search text:', searchText);

    if (searchText) {
        console.log('Filtering by search text:', searchText);
        filteredCards = filteredCards.filter(card => {
            const nameMatch = card.name && card.name.toLowerCase().includes(searchText);
            const effectMatch = card.effect && card.effect.toLowerCase().includes(searchText);
            const cardNumberMatch = card.cardNumber && card.cardNumber.toLowerCase().includes(searchText);
            return nameMatch || effectMatch || cardNumberMatch;
        });
    }

    // Apply other filters
    if (colorFilter.value) {
        console.log('Filtering by color:', colorFilter.value);
        filteredCards = filteredCards.filter(card => card.color && card.color.toLowerCase() === colorFilter.value.toLowerCase());
    }

    if (costFilter.value) {
        console.log('Filtering by cost:', costFilter.value);
        if (costFilter.value === '6+') {
            filteredCards = filteredCards.filter(card => card.cost >= 6);
        } else {
            const cost = parseInt(costFilter.value);
            filteredCards = filteredCards.filter(card => card.cost === cost);
        }
    }

    if (typeFilter.value) {
        console.log('Filtering by type:', typeFilter.value);
        filteredCards = filteredCards.filter(card => card.cardType === typeFilter.value);
    }

    // Apply set filters
    const selectedSets = Array.from(setFilters)
        .filter(checkbox => checkbox.checked)
        .map(checkbox => checkbox.value);
    
    if (selectedSets.length > 0) {
        console.log('Filtering by sets:', selectedSets);
        filteredCards = filteredCards.filter(card => 
            selectedSets.some(set => card.cardNumber && card.cardNumber.startsWith(set))
        );
    }

    console.log('Filtered cards count:', filteredCards.length);
    return filteredCards;
}

// Display cards in the grid
function displayCards(cards) {
    console.log('Displaying cards:', cards.length);
    cardGrid.innerHTML = '';
    
    // Apply sorting if selected
    if (sortFilter.value) {
        cards.sort((a, b) => {
            switch(sortFilter.value) {
                case 'name':
                    return a.name.localeCompare(b.name);
                case 'number':
                    return a.cardNumber.localeCompare(b.cardNumber);
                case 'power':
                    return (b.power || 0) - (a.power || 0);
                default:
                    return 0;
            }
        });
    }

    if (!cards || cards.length === 0) {
        cardGrid.innerHTML = `
            <div class="no-results">
                <p>No cards found matching your criteria</p>
                <button onclick="fetchCards()">Reset Filters</button>
            </div>
        `;
        return;
    }

    const cardElements = cards.map(card => {
        if (!card || !card.imagePath) return '';
        
        // Fix image path for ST06-ST20 cards - convert jpg to png
        let imagePath = card.imagePath;
        
        // Fix for OP sets that might be using .jpg when they should use .png or vice versa
        if (imagePath) {
            // For ST06-ST20 cards, ensure .png extension
            if (imagePath.match(/\/ST(\d+)\/ST\d+-\d+\.(jpg|png)$/)) {
                const stMatch = imagePath.match(/\/ST(\d+)\/ST\d+-\d+\.(jpg|png)$/);
                if (stMatch && stMatch[1] >= 6 && stMatch[1] <= 20) {
                    // Force .png extension for ST06-ST20
                    imagePath = imagePath.replace(/\.(jpg|png)$/, '.png');
                    console.log(`Fixed ST${stMatch[1]} image path in grid: ${imagePath}`);
                }
            }
        }
        
        return `
            <div class="card" onclick="showCardDetails(${JSON.stringify(card).replace(/"/g, '&quot;')})">
                <img src="${imagePath}" alt="${card.name || 'Card'}" loading="lazy" 
                     onerror="if(this.src.endsWith('.jpg')) { this.src = this.src.replace('.jpg', '.png'); } else if(this.src.endsWith('.png')) { this.src = this.src.replace('.png', '.jpg'); } else { this.src='/images/cards/card-back.png'; }">
                <div class="card-title">${card.name || 'Unknown Card'}</div>
                <div class="card-info-overlay">
                    <span class="card-number">${card.cardNumber || ''}</span>
                    <span class="card-cost">${card.cost || ''}</span>
                    <span class="card-power">${card.power || ''}</span>
                </div>
            </div>
        `;
    }).join('');

    cardGrid.innerHTML = cardElements;
    updateCardCount(cards.length);
}

// Update card count display
function updateCardCount(count) {
    const countElement = document.getElementById('cardCount') || createCardCountElement();
    countElement.textContent = `${count} cards found`;
}

// Create card count element if it doesn't exist
function createCardCountElement() {
    const countElement = document.createElement('div');
    countElement.id = 'cardCount';
    countElement.className = 'card-count';
    document.querySelector('.main-content').insertBefore(countElement, cardGrid);
    return countElement;
}

// Show card details in modal
function showCardDetails(card) {
    if (!card) return;
    
    console.log("Showing card details for:", card.cardNumber, card);
    
    // Update debug overlay
    const imageDebug = document.getElementById('imageDebug');
    imageDebug.innerHTML = `Original path: ${card.imagePath || 'N/A'}<br>`;
    
    // Get the card set and number from the card number (e.g., "OP01-013" → "OP01", "013")
    const cardNumberParts = card.cardNumber.split('-');
    const cardSet = cardNumberParts[0];
    const cardNum = cardNumberParts[1];
    
    // Construct path directly from card set and number
    let imagePath = `/images/cards/${cardSet}/${cardSet}-${cardNum}`;
    
    console.log("Card set:", cardSet, "Card number:", cardNum);
    imageDebug.innerHTML += `Card set: ${cardSet}, Card number: ${cardNum}<br>`;
    
    // Handle ST06-ST20 differently (always use PNG)
    if (cardSet.startsWith('ST') && parseInt(cardSet.substring(2)) >= 6 && parseInt(cardSet.substring(2)) <= 20) {
        imagePath = `${imagePath}.png`;
        console.log("Using .png extension for ST06-ST20 card:", imagePath);
        imageDebug.innerHTML += `Using .png extension: ${imagePath}<br>`;
    } else {
        // For OP series, try both extensions
        console.log("Will try both extensions for card:", card.cardNumber);
        imageDebug.innerHTML += `Will try both extensions<br>`;
        // Start with the extension in the path, but we'll handle errors if it fails
        imagePath = card.imagePath || `${imagePath}.jpg`;
        imageDebug.innerHTML += `Initial path: ${imagePath}<br>`;
    }
    
    console.log("Attempting to load image:", imagePath);
    
    // Set up the image with fallback handling
    const imgElement = document.getElementById('modalCardImage');
    
    // Clear any previous onload/onerror handlers to avoid stale closures
    imgElement.onload = null;
    imgElement.onerror = null;
    
    // Set up error handling before setting the src
    imgElement.onerror = function() {
        console.log("Error loading image:", this.src);
        imageDebug.innerHTML += `Error loading: ${this.src}<br>`;
        
        // Try the alternative extension
        if (this.src.endsWith('.jpg')) {
            const pngPath = this.src.replace('.jpg', '.png');
            console.log("Trying PNG instead:", pngPath);
            imageDebug.innerHTML += `Trying PNG instead: ${pngPath}<br>`;
            this.src = pngPath;
        } else if (this.src.endsWith('.png')) {
            const jpgPath = this.src.replace('.png', '.jpg');
            console.log("Trying JPG instead:", jpgPath);
            imageDebug.innerHTML += `Trying JPG instead: ${jpgPath}<br>`;
            this.src = jpgPath;
        } else {
            // Last resort fallback
            console.log("Using fallback card back image");
            imageDebug.innerHTML += `Using fallback card back image<br>`;
            this.src = '/images/cards/card-back.png';
        }
    };
    
    imgElement.onload = function() {
        console.log("Successfully loaded image:", this.src);
        imageDebug.innerHTML += `<strong>Successfully loaded: ${this.src}</strong><br>`;
    };
    
    // Now set the src to trigger loading
    imgElement.src = imagePath;
    
    // Fill in the rest of the modal content
    document.getElementById('modalCardName').textContent = card.name || 'Unknown Card';
    document.getElementById('modalCardNumber').textContent = `Card Number: ${card.cardNumber || 'N/A'}`;
    document.getElementById('modalCardType').textContent = `Type: ${card.cardType || 'N/A'}`;
    
    // Only show life if it's a leader card
    if (card.cardType === 'LEADER' && card.life) {
        document.getElementById('modalLife').textContent = `Life: ${card.life}`;
        document.getElementById('modalLife').style.display = 'block';
    } else {
        document.getElementById('modalLife').style.display = 'none';
    }
    
    document.getElementById('modalPower').textContent = `Power: ${card.power || 'N/A'}`;
    document.getElementById('modalAttribute').textContent = `Attribute: ${card.attribute || 'N/A'}`;
    document.getElementById('modalTiming').textContent = `Timing: ${card.timing || 'N/A'}`;
    document.getElementById('modalEffect').textContent = `Effect: ${card.effect || 'N/A'}`;
    document.getElementById('modalAffiliations').textContent = `Affiliations: ${card.affiliations || 'N/A'}`;
    
    modal.style.display = 'block';
}

// Close modal
function closeModal() {
    modal.style.display = 'none';
}

// Close modal when clicking outside
window.onclick = function(event) {
    if (event.target === modal) {
        closeModal();
    }
}

// Handle search input
function handleSearch() {
    console.log('Search handler called');
    console.log('Current search value:', searchInput.value);
    
    // Clear any existing timeout
    if (window.searchTimeout) {
        clearTimeout(window.searchTimeout);
    }
    
    // Set a new timeout
    window.searchTimeout = setTimeout(() => {
        const filteredCards = filterCardsLocally();
        displayCards(filteredCards);
    }, 300);
}

// Event listeners
document.addEventListener('DOMContentLoaded', () => {
    console.log('DOM Content Loaded');
    
    // Initial card load
    fetchCards().then(() => {
        // After initial load, set up search handlers
        searchInput.addEventListener('input', handleSearch);
        colorFilter.addEventListener('change', handleSearch);
        costFilter.addEventListener('change', handleSearch);
        typeFilter.addEventListener('change', handleSearch);
        sortFilter.addEventListener('change', handleSearch);
        setFilters.forEach(checkbox => {
            checkbox.addEventListener('change', handleSearch);
        });

        // Add search button click handler
        const searchButton = document.querySelector('.search-icon');
        if (searchButton) {
            searchButton.addEventListener('click', handleSearch);
        }
    }).catch(error => {
        console.error('Failed to load initial cards:', error);
    });
}); 