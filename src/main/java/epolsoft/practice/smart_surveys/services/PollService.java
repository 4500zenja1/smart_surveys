package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.entity.Poll;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;

import java.util.List;

public interface PollService {
    void createPoll(Poll poll);
    Poll getPollById(Long pollId);
    List<Poll> getAllPollsBySurveyId(Long id);
    void deletePoll(Long pollId);
    void checkById(Long id) throws NotFoundException;
}
