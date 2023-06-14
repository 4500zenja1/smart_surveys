-- Table: answer_option

CREATE TABLE IF NOT EXISTS public."answer_option"
(
    id bigserial primary key,
    poll_id bigint REFERENCES public."poll" (id) ON DELETE CASCADE,
    option_text varchar(200) NOT NULL,
    voted_count integer NOT NULL
);
