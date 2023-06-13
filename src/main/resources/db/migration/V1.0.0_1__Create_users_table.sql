-- Table: public.user
DO $$ BEGIN
    CREATE TYPE public.role_enum AS ENUM
        ('USER', 'MODER', 'ADMIN');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

CREATE TABLE IF NOT EXISTS public."users"
(
    id bigserial primary key,
    name character varying(50)  NOT NULL,
    email character varying(30)  NOT NULL,
    password text  NOT NULL,
    role_type role_enum NOT NULL
);
