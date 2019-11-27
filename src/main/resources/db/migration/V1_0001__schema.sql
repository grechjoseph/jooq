create table jooq.author (
    id uuid primary key,
    first_name character varying(255) not null,
    last_name character varying(255) not null
);

create table jooq.book (
    id uuid primary key,
    name character varying(255) not null,
    price numeric(19,2) not null,
    author_id uuid not null references jooq.author(id)
);