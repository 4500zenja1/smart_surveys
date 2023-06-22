package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.dto.AccessSurveyRequestDto;
import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.mapper.AccessSurveyMapper;
import epolsoft.practice.smart_surveys.repository.AccessSurveyRepository;
import epolsoft.practice.smart_surveys.services.AccessSurveyService;
import epolsoft.practice.smart_surveys.services.SurveyService;
import epolsoft.practice.smart_surveys.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccessSurveyServiceImpl implements AccessSurveyService {

    @Autowired
    private AccessSurveyRepository accessSurveyRepository;

    @Autowired
    private AccessSurveyMapper accessSurveyMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private SurveyService surveyService;

    @Override
    @Transactional
    public AccessSurvey createAccessSurvey(AccessSurveyRequestDto accessSurveyRequestDto) {
        AccessSurvey accessSurvey = accessSurveyMapper.toEntity(accessSurveyRequestDto);

        Long surveyId = accessSurveyRequestDto.getSurveyId();
        Survey survey = surveyService.getSurveyById(surveyId);
        accessSurvey.setSurvey(survey);

        Long userId = accessSurveyRequestDto.getUserId();
        User user = userService.getUserById(userId);
        accessSurvey.setUser(user);

        return accessSurveyRepository.save(accessSurvey);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccessSurvey> getAccessSurveysByUserId(Long id) {
        userService.checkById(id);
        return accessSurveyRepository.findAllByUserId(id);
    }
}
