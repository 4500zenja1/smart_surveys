package epolsoft.practice.smart_surveys.controller;

import epolsoft.practice.smart_surveys.dto.AccessSurveyRequestDto;
import epolsoft.practice.smart_surveys.dto.AccessSurveyResponseDto;
import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import epolsoft.practice.smart_surveys.mapper.AccessSurveyMapper;
import epolsoft.practice.smart_surveys.services.AccessSurveyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/access_survey")
@Tag(name = "Доступы к опросам", description = "Все методы для работы с доступами к опросам")
public class AccessSurveyController {
    @Autowired
    private AccessSurveyService accessSurveyService;

    @Autowired
    private AccessSurveyMapper accessSurveyMapper;

    @Operation(summary = "Создать новый доступ к опросу")
    @PostMapping()
    public AccessSurveyResponseDto createAccessSurvey(@Valid @RequestBody AccessSurveyRequestDto accessSurveyDto) {
        AccessSurvey accessSurvey = accessSurveyService.createAccessSurvey(accessSurveyDto);
        return accessSurveyMapper.toResponseDto(accessSurvey);
    }
}
