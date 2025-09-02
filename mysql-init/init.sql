-- utf8mb4 を明示的に指定
CREATE DATABASE IF NOT EXISTS typinggame CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE typinggame;

CREATE TABLE IF NOT EXISTS words (
    id INT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
);

INSERT INTO words (text) VALUES ('おはよう'), ('こんにちは'), ('こんばんは'), ('ただいま'), ('おかえり');