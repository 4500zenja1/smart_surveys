-- Table: answer_option
DO $$ BEGIN
    CREATE TYPE public.answer_type AS ENUM ('OPEN', 'CLOSED');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

CREATE TABLE IF NOT EXISTS public."answer_option"
(
    id bigserial primary key,
    poll_id bigint,
    option_text TEXT NOT NULL,
    voted_count integer NOT NULL,
    type public.answer_type NOT NULL,
    FOREIGN KEY (poll_id) REFERENCES public."poll" (id) ON DELETE CASCADE
);
