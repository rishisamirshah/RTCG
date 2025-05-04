-- PostgreSQL-compatible schema

-- Drop existing objects
DROP TABLE IF EXISTS deck_cards CASCADE;
DROP TABLE IF EXISTS decks CASCADE;
DROP TABLE IF EXISTS card CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP SEQUENCE IF EXISTS card_sequence CASCADE;
DROP SEQUENCE IF EXISTS deck_sequence CASCADE;
DROP SEQUENCE IF EXISTS deck_card_sequence CASCADE;

-- Create sequences
CREATE SEQUENCE IF NOT EXISTS card_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS deck_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS deck_card_sequence START WITH 1 INCREMENT BY 1;

-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    username TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create card table
CREATE TABLE IF NOT EXISTS card (
    id BIGINT NOT NULL DEFAULT nextval('card_sequence'),
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
    trigger TEXT,
    PRIMARY KEY (id)
);
ALTER SEQUENCE card_sequence OWNED BY card.id;

-- Create decks table
CREATE TABLE IF NOT EXISTS decks (
    id BIGINT NOT NULL DEFAULT nextval('deck_sequence'),
    name TEXT NOT NULL,
    leader_card_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (leader_card_id) REFERENCES card(id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
ALTER SEQUENCE deck_sequence OWNED BY decks.id;

-- Create deck_cards join table
CREATE TABLE IF NOT EXISTS deck_cards (
    id BIGINT NOT NULL DEFAULT nextval('deck_card_sequence'),
    deck_id BIGINT NOT NULL,
    card_id BIGINT NOT NULL,
    quantity INTEGER NOT NULL CHECK (quantity > 0),
    PRIMARY KEY (id),
    FOREIGN KEY (deck_id) REFERENCES decks(id) ON DELETE CASCADE,
    FOREIGN KEY (card_id) REFERENCES card(id) ON DELETE CASCADE,
    UNIQUE (deck_id, card_id)
);
ALTER SEQUENCE deck_card_sequence OWNED BY deck_cards.id;

-- Update the card_set field based on card_number if needed
-- UPDATE card SET card_set = substring(card_number from 1 for 4) WHERE card_set IS NULL; 