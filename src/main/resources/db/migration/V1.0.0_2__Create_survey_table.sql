-- Table: public.survey

CREATE TABLE IF NOT EXISTS public."survey"
(
    id bigserial PRIMARY KEY,
    survey_title character varying(50) NOT NULL,
    survey_description character varying(200) NOT NULL,
    anonymity boolean NOT NULL,
    author_id bigint NOT NULL REFERENCES public."users" (id),
    repeat_survey_interval interval NOT NULL,
    open_survey_date timestamp NOT NULL,
    close_survey_date timestamp NOT NULL,
    close_survey_iterable_date timestamp NOT NULL
);