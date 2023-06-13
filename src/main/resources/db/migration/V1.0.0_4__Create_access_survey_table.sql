-- Table: access_survey

CREATE TABLE IF NOT EXISTS public."access_survey"
(
    id bigserial primary key,
    show_result boolean,
    survey_id bigint,
    user_id bigint,
    FOREIGN KEY (survey_id) REFERENCES public."survey" (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES public."users" (id) ON DELETE CASCADE
);