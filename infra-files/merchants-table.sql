CREATE TABLE merchants (
    id SERIAL PRIMARY KEY,
    name varchar(255),
    min_amount numeric(20,2),
    max_amount numeric(20,2),
    website varchar(255),
    country char(3)
);
