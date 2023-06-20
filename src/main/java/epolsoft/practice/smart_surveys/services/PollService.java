package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.Poll;
import org.springframework.web.server.ResponseStatusException;

public interface PollService {
    Poll getPollById(Long pollId);

    void checkById(Long id) throws ResponseStatusException;
}
