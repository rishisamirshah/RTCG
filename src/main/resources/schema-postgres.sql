-- PostgreSQL-compatible schema
DROP TABLE IF EXISTS card CASCADE;
DROP SEQUENCE IF EXISTS card_sequence CASCADE;

CREATE SEQUENCE IF NOT EXISTS card_sequence START WITH 1 INCREMENT BY 1;

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

-- Update the card_set field based on card_number if needed
-- UPDATE card SET card_set = substring(card_number from 1 for 4) WHERE card_set IS NULL; 