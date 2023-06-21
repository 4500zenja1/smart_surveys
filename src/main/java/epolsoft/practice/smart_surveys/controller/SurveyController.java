package epolsoft.practice.smart_surveys.controller;

import epolsoft.practice.smart_surveys.dto.AccessSurveyResponseDto;
import epolsoft.practice.smart_surveys.dto.SurveyAnswerResponseDto;
import epolsoft.practice.smart_surveys.dto.SurveyResponseDto;
import epolsoft.practice.smart_surveys.dto.UserVoteRequestDto;
import epolsoft.practice.smart_surveys.dto.UserVoteResponseDto;
import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.entity.UserVote;
import epolsoft.practice.smart_surveys.mapper.AccessSurveyMapper;
import epolsoft.practice.smart_surveys.mapper.SurveyAnswerOptionMapper;
import epolsoft.practice.smart_surveys.mapper.SurveyMapper;
import epolsoft.practice.smart_surveys.mapper.UserVoteMapper;
import epolsoft.practice.smart_surveys.services.SurveyService;
import epolsoft.practice.smart_surveys.services.UserVoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
@Tag(name = "Опросник", description = "Все методы для работы с опросником")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

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

    @Operation(summary = "Получить опрос по id")
    @GetMapping("/{id}")
    public SurveyResponseDto getById(@PathVariable Long id) {
        Survey survey = surveyService.getSurveyById(id);
        return surveyMapper.toResponseDto(survey);
    }

    @Operation(summary = "Получить список опросов по id автора")
    @GetMapping("/author/{id}")
    public List<SurveyResponseDto> getSurveys(@PathVariable Long id) {
        List<Survey> surveys = surveyService.getAllSurveysByUserId(id);
        return surveyMapper.toResponseDtos(surveys);
    }

    @Operation(summary = "Получить список доступных опросов пользователю по его id")
    @GetMapping("/available/{id}")
    public List<AccessSurveyResponseDto> getAccessSurveys(@PathVariable Long id) {
        List<AccessSurvey> accessSurveys = surveyService.getAllAccessSurveysByUserId(id);
        return accessSurveyMapper.toResponseDtos(accessSurveys);
    }

    @Operation(summary = "Получить данные по id опроса: количество голосов за каждый вариант ответа и процентное соотношение ответов. ")
    @GetMapping("/{id}/answers")
    public SurveyAnswerResponseDto getAnswersOption(@PathVariable Long id) {
        Survey survey = surveyService.getAllAnswersOptionById(id);
        return surveyAnswerOptionMapper.toResponseDto(survey);
    }




    @Operation(summary = "записать результаты опроса в бд")
    @PostMapping("/{id}/submit")
    public List<UserVoteResponseDto> setUserVote(
            @PathVariable Long id,
            @RequestBody List<UserVoteRequestDto> userVoteDtos,
            @RequestParam(value = "user_id") Long userId) {
        for (UserVoteRequestDto userVoteDto : userVoteDtos) userVoteDto.setUserId(userId);
        return userVoteMapper.toResponseDtos(userVoteService.createUserVotes(userVoteDtos));
    }
}
