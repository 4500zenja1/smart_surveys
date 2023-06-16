package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.repository.AccessSurveyRepository;
import epolsoft.practice.smart_surveys.services.AccessSurveyService;
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
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public List<AccessSurvey> getAccessSurveysByUserId(Long id) {
        try {
            userService.checkById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return accessSurveyRepository.findAllByUserId(id);
    }
}
