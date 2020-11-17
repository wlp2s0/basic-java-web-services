CREATE TABLE IF NOT EXISTS books
(
    id     SERIAL PRIMARY KEY,
    title  VARCHAR NOT NULL,
    author VARCHAR NOT NULL,
    rating INT     NOT NULL
)
