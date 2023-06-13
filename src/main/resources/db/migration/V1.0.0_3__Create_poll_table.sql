-- Table: public.poll
CREATE TYPE public.poll_enum AS ENUM ('SINGLE', 'VARIABLE');

CREATE TABLE IF NOT EXISTS public."poll"
(
    id bigserial primary key,
    survey_id bigint,
    question_text text NOT NULL,
    poll_type poll_enum NOT NULL,
    FOREIGN KEY (survey_id) REFERENCES public."survey" (id) ON DELETE CASCADE
);