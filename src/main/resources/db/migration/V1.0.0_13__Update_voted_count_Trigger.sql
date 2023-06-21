CREATE OR REPLACE FUNCTION updateVotedCount() RETURNS
    trigger AS '
        BEGIN
        UPDATE answer_option
        SET voted_count = voted_count + 1
        WHERE id = NEW.answer_option_id;
        return NEW;
        END;
        ' LANGUAGE  plpgsql;

        CREATE TRIGGER execute_tranfer
        BEFORE INSERT ON user_vote FOR EACH ROW
        EXECUTE PROCEDURE updateVotedCount();