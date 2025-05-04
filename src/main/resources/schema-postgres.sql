-- PostgreSQL-compatible schema
DROP TABLE IF EXISTS card CASCADE;

CREATE TABLE IF NOT EXISTS card (
    id SERIAL PRIMARY KEY,
    card_number TEXT UNIQUE,
    name TEXT,
    card_type TEXT,
    color TEXT,
    cost INTEGER,
    power INTEGER,
    life INTEGER,
    affiliations TEXT,
    effect TEXT,
    image_path TEXT,
    card_set TEXT,
    counter INTEGER,
    attribute TEXT,
    timing TEXT,
    trigger TEXT
);

-- Update the card_set field based on card_number if needed
-- UPDATE card SET card_set = substring(card_number from 1 for 4) WHERE card_set IS NULL; 