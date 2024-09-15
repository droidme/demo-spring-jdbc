DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users
(
    id              VARCHAR(20) primary key,
    name            VARCHAR(50) NOT NULL,
    description     VARCHAR(250) NOT NULL,
    created         TIMESTAMP,
    active          BOOLEAN
);

insert into users (id, name, description, created, active)
values ('droidme', 'Reinhard Merfeld', 'Administrator', current_timestamp, true);

insert into users (id, name, description, created, active)
values ('duke', 'Maximilian Merfeld', 'User', current_timestamp, true);

