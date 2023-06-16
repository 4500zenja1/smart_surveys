package epolsoft.practice.smart_surveys.mapper;

import epolsoft.practice.smart_surveys.dto.AccessSurveyResponseDto;
import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccessSurveyMapper {
    AccessSurveyResponseDto accessSurveyToAccessSurveyResponseDto(AccessSurvey accessSurvey);
    List<AccessSurveyResponseDto> accessSurveysToAccessSurveyResponseDto(List<AccessSurvey> accessSurveys);
}
