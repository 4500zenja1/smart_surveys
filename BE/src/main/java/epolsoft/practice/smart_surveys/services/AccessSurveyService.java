package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.AccessSurvey;

import java.util.List;

public interface AccessSurveyService {
    List<AccessSurvey> getAccessSurveysByUserId(Long id);
}
