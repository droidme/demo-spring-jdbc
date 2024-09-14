CREATE TABLE IF NOT EXISTS users
(
    id              VARCHAR(20) primary key,
    name            VARCHAR(50) NOT NULL,
    description     VARCHAR(250) NOT NULL,
    created         TIMESTAMP,
    active          BOOLEAN
);