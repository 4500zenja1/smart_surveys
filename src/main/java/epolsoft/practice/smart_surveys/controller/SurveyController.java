package epolsoft.practice.smart_surveys.controller;

import epolsoft.practice.smart_surveys.dto.AccessSurveyResponseDto;
import epolsoft.practice.smart_surveys.dto.SurveyResponseDto;
import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.mapper.AccessSurveyMapper;
import epolsoft.practice.smart_surveys.mapper.SurveyMapper;
import epolsoft.practice.smart_surveys.services.SurveyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
@Tag(name = "Опросник", description = "Все методы для работы с опросником")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @Autowired
    private AccessSurveyMapper accessSurveyMapper;

    @Autowired
    private SurveyMapper surveyMapper;

    @Operation(summary = "Получить опрос по id")
    @GetMapping("/{id}")
    public SurveyResponseDto getById(@PathVariable Long id) {
        Survey survey = surveyService.getSurveyById(id);
        return surveyMapper.surveyToSurveyGetDto(survey);
    }

    @Operation(summary = "Получить список опросов по id автора")
    @GetMapping("/author/{id}")
    public List<SurveyResponseDto> getSurveys(@PathVariable Long id) {
        List<Survey> surveys = surveyService.getAllSurveysByUserId(id);
        return surveyMapper.surveysToSurveyGetDto(surveys);
    }

    @Operation(summary = "Получить список доступных опросов автору по его id")
    @GetMapping("/available/{id}")
    public List<AccessSurveyResponseDto> getAccessSurveys(@PathVariable Long id){
        List<AccessSurvey> accessSurveys = surveyService.getAllAccessSurveysByUserId(id);
        return accessSurveyMapper.accessSurveysToAccessSurveyGetDto(accessSurveys);
    }
}
