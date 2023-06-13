-- Table: public.poll
DO $$ BEGIN
    CREATE TYPE public.poll_enum AS ENUM ('SINGLE', 'VARIABLE');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

CREATE TABLE IF NOT EXISTS public."poll"
(
    id bigserial primary key,
    survey_id bigint,
    question_text character varying(100) NOT NULL,
    poll_type poll_enum NOT NULL,
    FOREIGN KEY (survey_id) REFERENCES public."survey" (id) ON DELETE CASCADE
);

