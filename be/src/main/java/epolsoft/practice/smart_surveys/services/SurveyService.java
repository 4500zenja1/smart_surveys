package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.dto.SurveyRequestDto;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;

import java.util.List;

public interface SurveyService {
    Survey createSurvey(SurveyRequestDto surveyRequestDto);

    Survey getSurveyById(Long surveyId);

    List<Survey> getAllSurveysByUser();

    Survey getAllAnswersOptionById(Long id);

    void checkById(Long id) throws NotFoundException;

    void updateSurvey(Survey survey, Long surveyId);

    void deleteSurvey(Long surveyId);
}
