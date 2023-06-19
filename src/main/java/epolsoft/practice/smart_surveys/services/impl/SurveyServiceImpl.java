package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.entity.Poll;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.repository.SurveyRepository;
import epolsoft.practice.smart_surveys.services.AccessSurveyService;
import epolsoft.practice.smart_surveys.services.AnswerOptionService;
import epolsoft.practice.smart_surveys.services.PollService;
import epolsoft.practice.smart_surveys.services.SurveyService;
import epolsoft.practice.smart_surveys.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AccessSurveyService accessSurveyService;

    @Autowired
    private PollService pollService;

    @Autowired
    private AnswerOptionService answerOptionService;

    @Override
    public void createSurvey(Survey survey) {
    }

    @Override
    @Transactional(readOnly = true)
    public Survey getSurveyById(Long id) {
        checkById(id);
        return surveyRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Survey> getAllSurveysByUserId(Long id) {
        userService.checkById(id);
        return surveyRepository.findAllByAuthorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccessSurvey> getAllAccessSurveysByUserId(Long id) {
        return accessSurveyService.getAccessSurveysByUserId(id);
    }

    @Override
    public List<AnswerOption> getAllAnswersOptionById(Long id) {
        checkById(id);
        List<Poll> polls = pollService.getPollsBySurveyId(id);
        List<AnswerOption> answerOptions = new ArrayList<>();
        for(Poll poll:polls){
            List<AnswerOption> tmp = poll.getAnswers();
            answerOptions.addAll(tmp);
        }
        return answerOptions;
    }

    @Override
    public void updateSurvey(Survey survey, Long id) {
    }

    @Override
    public void deleteSurvey(Long id) {
    }

    @Override
    public void checkById(Long id) throws NotFoundException {
        if (!surveyRepository.existsById(id)) {
            throw new NotFoundException("Не найден опрос с таким id в базе данных");
        }
    }
}
