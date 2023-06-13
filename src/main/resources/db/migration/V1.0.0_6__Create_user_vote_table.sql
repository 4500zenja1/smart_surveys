-- Table: user_vote

CREATE TABLE IF NOT EXISTS public."user_vote"
(
    id bigserial primary key,
    answer_option_id bigint,
    user_id bigint,
    FOREIGN KEY (answer_option_id) REFERENCES public."answer_option" (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES public."users" (id) ON DELETE CASCADE
);