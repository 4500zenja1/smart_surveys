-- Table: public.user
CREATE TYPE public.role_enum AS ENUM
    ('USER', 'MODER', 'ADMIN');

CREATE TABLE IF NOT EXISTS public."users"
(
    id bigserial primary key,
    name varchar(50) NOT NULL,
    email varchar(320) NOT NULL,
    password text NOT NULL,
    role_type public.role_enum NOT NULL
);
