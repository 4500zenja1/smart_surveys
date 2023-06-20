package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import epolsoft.practice.smart_surveys.entity.Survey;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface SurveyService {
    Survey createSurvey(Survey survey);

    Survey getSurveyById(Long surveyId);

    List<Survey> getAllSurveysByUserId(Long id);

    List<AccessSurvey> getAllAccessSurveysByUserId(Long id);

    Survey getAllAnswersOptionById(Long id);

    void checkById(Long id) throws ResponseStatusException;

    void updateSurvey(Survey survey, Long surveyId);

    void deleteSurvey(Long surveyId);
}
