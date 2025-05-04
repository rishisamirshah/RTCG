-- PostgreSQL-compatible schema
CREATE TABLE IF NOT EXISTS card (
    id SERIAL PRIMARY KEY,
    card_number VARCHAR(10) UNIQUE,
    name VARCHAR(100),
    card_type VARCHAR(20),
    color VARCHAR(20),
    cost INTEGER,
    power INTEGER,
    life INTEGER,
    affiliations VARCHAR(100),
    effect TEXT,
    image_path VARCHAR(255),
    card_set VARCHAR(10),
    counter INTEGER
);

-- Update the card_set field based on card_number if needed
-- UPDATE card SET card_set = substring(card_number from 1 for 4) WHERE card_set IS NULL; 