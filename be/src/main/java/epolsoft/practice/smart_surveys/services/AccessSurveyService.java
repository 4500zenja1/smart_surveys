package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.dto.AccessSurveyRequestDto;
import epolsoft.practice.smart_surveys.entity.AccessSurvey;

import java.util.List;

public interface AccessSurveyService {
    AccessSurvey createAccessSurvey(AccessSurveyRequestDto accessSurveyRequestDto);
    List<AccessSurvey> getAccessSurveysByUser();
}
