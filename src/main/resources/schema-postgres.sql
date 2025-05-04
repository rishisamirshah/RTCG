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
    affiliations TEXT,
    effect TEXT,
    image_path TEXT,
    card_set VARCHAR(10),
    counter INTEGER,
    attribute VARCHAR(100),
    timing VARCHAR(100),
    trigger TEXT
);

-- Update the card_set field based on card_number if needed
-- UPDATE card SET card_set = substring(card_number from 1 for 4) WHERE card_set IS NULL; 