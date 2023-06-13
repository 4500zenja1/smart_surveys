-- Table: answer_option

CREATE TABLE IF NOT EXISTS public."answer_option"
(
    id bigserial primary key,
    poll_id bigint,
    option_text TEXT NOT NULL,
    voted_count integer NOT NULL,
    FOREIGN KEY (poll_id) REFERENCES public."poll" (id) ON DELETE CASCADE
);
