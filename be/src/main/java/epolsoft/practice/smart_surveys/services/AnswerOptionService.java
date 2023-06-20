package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.AnswerOption;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface AnswerOptionService {
    List<AnswerOption> getAnswersOptionByPollId(Long id);
    void checkById(Long id) throws ResponseStatusException;
}
