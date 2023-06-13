-- Table: public.survey

CREATE TABLE IF NOT EXISTS public."survey"
(
    id bigserial PRIMARY KEY,
    survey_title TEXT NOT NULL,
    survey_description TEXT NOT NULL,
    anonymity boolean NOT NULL,
    author_id bigint NOT NULL,
    repeat_survey_interval interval NOT NULL,
    open_survey_date timestamp NOT NULL,
    close_survey_date timestamp NOT NULL,
    close_survey_iterable_date timestamp NOT NULL,
    FOREIGN KEY (author_id) REFERENCES public."users" (id) ON DELETE CASCADE
);