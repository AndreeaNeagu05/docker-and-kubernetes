CREATE TABLE IF NOT EXISTS animals (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL
);

INSERT INTO animals (name, category) VALUES
('Rex', 'dog'),
('Miti', 'cat'),
('Azorel', 'dog'),
('Lola', 'cat'),
('Bunny', 'rabbit');