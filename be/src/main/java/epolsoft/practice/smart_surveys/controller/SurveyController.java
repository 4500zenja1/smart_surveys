package epolsoft.practice.smart_surveys.controller;

import epolsoft.practice.smart_surveys.dto.*;
import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.mapper.AccessSurveyMapper;
import epolsoft.practice.smart_surveys.mapper.SurveyAnswerOptionMapper;
import epolsoft.practice.smart_surveys.mapper.SurveyMapper;
import epolsoft.practice.smart_surveys.mapper.UserVoteMapper;
import epolsoft.practice.smart_surveys.services.AccessSurveyService;
import epolsoft.practice.smart_surveys.services.SurveyService;
import epolsoft.practice.smart_surveys.services.UserVoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Опросник", description = "Все методы для работы с опросником")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @Autowired
    private AccessSurveyService accessSurveyService;

    @Autowired
    private UserVoteService userVoteService;

    @Autowired
    private AccessSurveyMapper accessSurveyMapper;

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private UserVoteMapper userVoteMapper;

    @Autowired
    private SurveyAnswerOptionMapper surveyAnswerOptionMapper;

    @Operation(summary = "Создать новый опрос")
    @PreAuthorize("hasAuthority('MODER')")
    @PostMapping()
    public SurveyResponseDto createSurvey(@Valid @RequestBody SurveyRequestDto surveyDto) {
        Survey survey = surveyService.createSurvey(surveyDto);
        return surveyMapper.toResponseDto(survey);
    }

    @Operation(summary = "Создать новый доступ к опросу")
    @PreAuthorize("hasAuthority('MODER')")
    @PostMapping("/access")
    public AccessSurveyResponseDto createAccessSurvey(@Valid @RequestBody AccessSurveyRequestDto accessSurveyDto) {
        AccessSurvey accessSurvey = accessSurveyService.createAccessSurvey(accessSurveyDto);
        return accessSurveyMapper.toResponseDto(accessSurvey);
    }

    @Operation(summary = "Получить опрос по id")
    @PreAuthorize("hasAnyAuthority('USER', 'MODER', 'ADMIN')")
    @GetMapping("/{id}")
    public SurveyResponseDto getById(@PathVariable Long id) {
        Survey survey = surveyService.getSurveyById(id);
        return surveyMapper.toResponseDto(survey);
    }

    @Operation(summary = "Получить список опросов за авторством текущего пользователя")
    @PreAuthorize("hasAuthority('MODER')")
    @GetMapping("/author")
    public List<SurveyResponseDto> getSurveys() {
        List<Survey> surveys = surveyService.getAllSurveysByUser();
        return surveyMapper.toResponseDtos(surveys);
    }

    @Operation(summary = "Получить список доступных текущему пользователю опросов")
    @PreAuthorize("hasAnyAuthority('USER', 'MODER', 'ADMIN')")
    @GetMapping("/available")
    public List<AccessSurveyResponseDto> getAccessSurveys() {
        List<AccessSurvey> accessSurveys = accessSurveyService.getAccessSurveysByUser();
        return accessSurveyMapper.toResponseDtos(accessSurveys);
    }

    @Operation(summary = "Получить данные по id опроса: количество голосов за каждый вариант ответа и процентное соотношение ответов. ")
    @PreAuthorize("hasAnyAuthority('USER', 'MODER', 'ADMIN')")
    @GetMapping("/{id}/answers")
    public SurveyAnswerResponseDto getAnswersOption(@PathVariable Long id) {
        Survey survey = surveyService.getAllAnswersOptionById(id);
        return surveyAnswerOptionMapper.toResponseDto(survey);
    }

    @Operation(summary = "Записать результаты опроса в бд")
    @PreAuthorize("hasAnyAuthority('USER', 'MODER', 'ADMIN')")
    @PostMapping("/submit")
    public List<UserVoteResponseDto> setUserVote(
            @RequestBody List<UserVoteRequestDto> userVoteDtos) {
        List<UserVoteResponseDto> userVoteResponseDto = userVoteMapper.toResponseDtos(userVoteDtos);
        return userVoteService.createUserVotes(userVoteResponseDto);
    }
}
