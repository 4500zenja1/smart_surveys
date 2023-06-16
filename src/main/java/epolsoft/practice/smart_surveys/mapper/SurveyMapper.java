package epolsoft.practice.smart_surveys.mapper;

import epolsoft.practice.smart_surveys.dto.SurveyResponseDto;
import epolsoft.practice.smart_surveys.entity.Survey;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SurveyMapper {
    SurveyResponseDto surveyToSurveyResponseDto(Survey survey);
    List<SurveyResponseDto> surveysToSurveyResponseDto(List<Survey> surveys);
}