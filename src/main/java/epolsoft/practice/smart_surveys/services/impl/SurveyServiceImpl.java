package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import epolsoft.practice.smart_surveys.entity.Poll;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.exceptions.ValidationException;
import epolsoft.practice.smart_surveys.repository.SurveyRepository;
import epolsoft.practice.smart_surveys.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private PollService pollService;

    @Autowired
    private UserService userService;

    @Autowired
    private AccessSurveyService accessSurveyService;

    @Autowired
    private AnswerOptionService answerOptionService;

    @Override
    public Survey createSurvey(Survey survey) {
        LocalDateTime openDate = survey.getOpenSurveyDate();
        LocalDateTime closeDate = survey.getCloseSurveyDate();
        LocalDateTime closeIterableDate = survey.getCloseSurveyIterableDate();
        if (!openDate.isBefore(closeDate)) {
            throw new ValidationException(
                    "Дата завершения опроса должна быть строго после даты начала"
            );
        } else if (closeIterableDate.isAfter(closeDate)) {
            throw new ValidationException(
                    "Дата завершения итерации опроса не должна быть после даты окончания самого опроса"
            );
        } else if (closeIterableDate.isBefore(openDate)) {
            throw new ValidationException(
                    "Дата завершения итерации опроса не должна быть до даты начала самого опроса"
            );
        }

        List<Poll> polls = survey.getPolls();
        for (Poll poll: polls) {
            Long pollId = poll.getId();
            Poll foundPoll = pollService.getPollById(pollId);
            if (!Objects.equals(pollId, foundPoll.getId())
             || !Objects.equals(poll.getQuestion(), foundPoll.getQuestion())
             || !Objects.equals(poll.getPoll_type(), foundPoll.getPoll_type())
            ) {
                throw new ValidationException(
                        String.format("Данные пула с ID=%d не соответствуют введённым полям",
                                pollId)
                );
            }
        }

        return surveyRepository.save(survey);
    }

    @Override
    @Transactional(readOnly = true)
    public Survey getSurveyById(Long id) {
        checkById(id);
        return surveyRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Survey> getAllSurveysByUserId(Long id) {
        userService.checkById(id);
        return surveyRepository.findAllByAuthorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccessSurvey> getAllAccessSurveysByUserId(Long id) {
        return accessSurveyService.getAccessSurveysByUserId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Survey getAllAnswersOptionById(Long id) {
        checkById(id);
        return surveyRepository.findById(id).get();
    }

    @Override
    public void updateSurvey(Survey survey, Long id) {
    }

    @Override
    public void deleteSurvey(Long id) {
    }

    @Override
    @Transactional(readOnly = true)
    public void checkById(Long id) throws NotFoundException {
        if (!surveyRepository.existsById(id)) {
            throw new NotFoundException("Не найден опрос с таким id в базе данных");
        }
    }
}
