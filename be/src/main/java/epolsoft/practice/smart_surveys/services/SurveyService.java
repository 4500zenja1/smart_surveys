package epolsoft.practice.smart_surveys.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import epolsoft.practice.smart_surveys.dto.SurveyRequestDto;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;

import java.io.FileNotFoundException;
import java.util.List;

public interface SurveyService {
    Survey createSurvey(SurveyRequestDto surveyRequestDto);

    Survey getSurveyById(Long surveyId);

    List<Survey> getAllSurveysByUserId(Long id);

    Survey getAllAnswersOptionById(Long id);

    void checkById(Long id) throws NotFoundException;

    void updateSurvey(Survey survey, Long surveyId);

    void deleteSurvey(Long surveyId);

    Document getReport(Long id, String path, Survey survey) throws FileNotFoundException, DocumentException, JsonProcessingException;
}
