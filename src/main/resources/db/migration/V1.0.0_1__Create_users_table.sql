-- Table: public.user
CREATE TYPE public.role_enum AS ENUM
    ('USER', 'MODER', 'ADMIN');

CREATE TABLE IF NOT EXISTS public."users"
(
    id bigserial primary key,
    name text NOT NULL,
    email text NOT NULL,
    password text  NOT NULL,
    role_type public.role_enum NOT NULL
);
