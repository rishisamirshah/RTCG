DROP TABLE IF EXISTS card;

CREATE TABLE card (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
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
    card_set VARCHAR(10)
);

-- Check if the column exists first
CREATE TABLE IF NOT EXISTS card_temp AS
SELECT 
    id,
    card_number,
    name,
    card_type,
    color,
    cost,
    power,
    life,
    affiliations,
    effect,
    image_path,
    card_set
FROM card;

DROP TABLE IF EXISTS card_temp;

-- Update the card_set field based on card_number
UPDATE card SET card_set = substr(card_number, 1, 4) WHERE card_set IS NULL;

-- Delete duplicate cards, keeping only the one with the lowest ID for each card_number
DELETE FROM card 
WHERE id NOT IN (
    SELECT MIN(id)
    FROM card
    GROUP BY card_number
); 