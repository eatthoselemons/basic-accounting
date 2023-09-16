create table transactions (
    id serial PRIMARY KEY,
    date date NOT NULL ,
    amount_cents int NOT NULL ,
    description text NOT NULL ,
)

create table stores (
    id Serial PRIMARY KEY ,
    name text,
)

create table transaction_store (
    store_id int,
    transaction_id int,
    primary key (store_id, transaction_id)

)

create table type (
    id serial PRIMARY KEY,
    name text
)

create table transaction_type (
    type_id int,
    transaction_id int,
    primary key (type_id, transaction_id)
)
