package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.repository.AnswerOptionRepository;
import epolsoft.practice.smart_surveys.services.AnswerOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerOptionServiceImpl implements AnswerOptionService {

    @Autowired
    private AnswerOptionRepository answerOptionRepository;

    @Override
    public List<AnswerOption> getAnswersOptionByPollId(Long id) {
        checkById(id);
        return answerOptionRepository.findAllByPollId(id);
    }

    @Override
    public void checkById(Long id) throws NotFoundException {
        if (!answerOptionRepository.existsById(id)) {
            throw new NotFoundException(
                    "Не найден вариант ответа с таким id в базе данных"
            );
        }
    }
}
