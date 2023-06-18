/*package epolsoft.practice.smart_surveys.controller;

import epolsoft.practice.smart_surveys.dto.PollRequestDto;
import epolsoft.practice.smart_surveys.dto.SurveyResponseDto;
import epolsoft.practice.smart_surveys.entity.Poll;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.mapper.AccessSurveyMapper;
import epolsoft.practice.smart_surveys.mapper.PollMapper;
import epolsoft.practice.smart_surveys.mapper.SurveyMapper;
import epolsoft.practice.smart_surveys.services.PollService;
import epolsoft.practice.smart_surveys.services.SurveyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/surveyy/{id}")
@Tag(name = "вопрос", description = "Все методы для работы с вопросом и его ответами")
public class PollController {
    @Autowired
    private SurveyService surveyService;

    @Autowired
    private PollService pollService;

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private PollMapper pollMapper;

    @Operation(summary = "Получить список ответов по id опроса")
    @PostMapping("/submitt")
    public List<PollRequestDto> getPolls(@PathVariable Long id) {
        List<Poll> polls = pollService.getAllPollsBySurveyId(id);
        return pollMapper.pollsToPollRequestDto(polls);
    }
}


 */