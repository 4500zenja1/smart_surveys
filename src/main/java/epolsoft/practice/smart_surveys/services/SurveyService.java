package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import epolsoft.practice.smart_surveys.entity.Survey;

import java.util.List;

public interface SurveyService {
    void createSurvey(Survey survey);

    Survey getSurveyById(Long surveyId);

    List<Survey> getAllSurveysByUserId(Long id);

    List<AccessSurvey> getAllAccessSurveysByUserId(Long id);

    void updateSurvey(Survey survey, Long surveyId);

    void deleteSurvey(Long surveyId);
}
