package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.Poll;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;

public interface PollService {
    void createPoll(Poll poll);

    Poll getPollById(Long pollId);

    void checkById(Long id) throws NotFoundException;

    void updatePoll(Poll poll, Long pollId);

    void deletePoll(Long pollId);
}
