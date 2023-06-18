package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.exceptions.*;
import epolsoft.practice.smart_surveys.repository.SurveyRepository;
import epolsoft.practice.smart_surveys.services.AccessSurveyService;
import epolsoft.practice.smart_surveys.services.AnswerOptionService;
import epolsoft.practice.smart_surveys.services.PollService;
import epolsoft.practice.smart_surveys.services.SurveyService;
import epolsoft.practice.smart_surveys.services.UserService;
import lombok.RequiredArgsConstructor;
import org.postgresql.util.PGInterval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AccessSurveyService accessSurveyService;

    @Autowired
    private PollService pollService;

    @Autowired
    private AnswerOptionService answerOptionService;

    @Override
    @Transactional
    public Survey createSurvey(Survey survey) {
        Long surveyId = survey.getId();
        if (surveyRepository.existsById(surveyId)) {
            throw new AlreadyExistsException("Опросник с таким ID уже существует");
        }

        PGInterval interval = survey.getInterval();
        if (Objects.equals(interval.getValue(), "0 years 0 mons 0 days 0 hours 0 mins 0.0 secs")) {
            throw new IntervalEmptyException("Интервал не может быть пустым");
        }

        LocalDateTime openDate = survey.getOpenSurveyDate();
        LocalDateTime closeDate = survey.getCloseSurveyDate();
        LocalDateTime closeIterableDate = survey.getCloseSurveyIterableDate();
        if (!openDate.isBefore(closeDate)) {
            throw new InvalidDatesException("Дата завершения опроса должна быть строго после даты начала");
        } else if (closeIterableDate.isAfter(closeDate)) {
            throw new InvalidDatesException("Дата завершения итерации опроса не должна быть после даты окончания самого опроса");
        } else if (closeIterableDate.isBefore(openDate)) {
            throw new InvalidDatesException("Дата завершения итерации опроса не должна быть до даты начала самого опроса");
        }

        User author = survey.getAuthor();
        Long authorId = author.getId();
        if (!author.equals(userService.getUserById(authorId))) {
            throw new InvalidUserException(
                    String.format("Данные пользователя с ID=%d не соответствуют введённым полям",
                            authorId)
            );
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
