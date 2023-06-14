package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.Survey;

public interface SurveyService {
    void createSurvey(Survey survey);
    void getSurveyById(Long surveyId);
    void getAllSurveys();
    void updateSurvey(Survey survey, Long surveyId);
    void deleteSurvey(Long surveyId);
}
