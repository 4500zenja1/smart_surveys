package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.Poll;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;

public interface PollService {
    Poll getPollById(Long pollId);

    void checkById(Long id) throws NotFoundException;
}
