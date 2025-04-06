// DOM Elements
const cardGrid = document.getElementById('cardGrid');
const modal = document.getElementById('cardModal');
const searchInput = document.getElementById('searchInput');
const colorFilter = document.getElementById('colorFilter');
const costFilter = document.getElementById('costFilter');
const typeFilter = document.getElementById('typeFilter');
const sortFilter = document.getElementById('sortFilter');

// Store all cards for filtering
let allCards = [];

// Fetch cards from the backend
async function fetchCards() {
    try {
        const response = await fetch('/api/cards');
        allCards = await response.json();
        displayCards(allCards);
    } catch (error) {
        console.error('Error fetching cards:', error);
    }
}

// Filter cards based on current filters
function filterCards() {
    let filteredCards = [...allCards];
    
    // Text search
    const searchText = searchInput.value.toLowerCase();
    if (searchText) {
        filteredCards = filteredCards.filter(card => 
            card.name.toLowerCase().includes(searchText) ||
            card.effect.toLowerCase().includes(searchText)
        );
    }
    
    // Type filter
    if (typeFilter.value) {
        filteredCards = filteredCards.filter(card => 
            card.cardType === typeFilter.value
        );
    }
    
    // Sort cards
    if (sortFilter.value) {
        filteredCards.sort((a, b) => {
            switch(sortFilter.value) {
                case 'name':
                    return a.name.localeCompare(b.name);
                case 'number':
                    return a.cardNumber.localeCompare(b.cardNumber);
                case 'power':
                    return b.power - a.power;
                default:
                    return 0;
            }
        });
    }
    
    displayCards(filteredCards);
}

// Display cards in the grid
function displayCards(cards) {
    cardGrid.innerHTML = '';
    cards.forEach(card => {
        const cardElement = createCardElement(card);
        cardGrid.appendChild(cardElement);
    });
}

// Create a card element
function createCardElement(card) {
    const cardDiv = document.createElement('div');
    cardDiv.className = 'card';
    cardDiv.innerHTML = `
        <img src="${card.imagePath}" alt="${card.name}" onerror="this.src='https://via.placeholder.com/200x280?text=One+Piece+Card'">
        <div class="card-title">${card.name}</div>
    `;
    cardDiv.onclick = () => showCardDetails(card);
    return cardDiv;
}

// Show card details in modal
function showCardDetails(card) {
    document.getElementById('modalCardImage').src = card.imagePath;
    document.getElementById('modalCardName').textContent = card.name;
    document.getElementById('modalCardNumber').textContent = `Card Number: ${card.cardNumber}`;
    document.getElementById('modalCardType').textContent = `Type: ${card.cardType}`;
    
    // Only show life if it's a leader card
    if (card.cardType === 'LEADER' && card.life) {
        document.getElementById('modalLife').textContent = `Life: ${card.life}`;
        document.getElementById('modalLife').style.display = 'block';
    } else {
        document.getElementById('modalLife').style.display = 'none';
    }
    
    document.getElementById('modalPower').textContent = `Power: ${card.power}`;
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

// Event listeners for filters
searchInput.addEventListener('input', filterCards);
typeFilter.addEventListener('change', filterCards);
sortFilter.addEventListener('change', filterCards);

// Initialize the page
document.addEventListener('DOMContentLoaded', fetchCards); 