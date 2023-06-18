package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.entity.Poll;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.repository.PollRepository;
import epolsoft.practice.smart_surveys.repository.SurveyRepository;
import epolsoft.practice.smart_surveys.services.PollService;
import epolsoft.practice.smart_surveys.services.SurveyService;
import epolsoft.practice.smart_surveys.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PollServiceImpl implements PollService {
    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private SurveyService SurveyService;

    @Override
    public void createPoll(Poll Poll) {

    }

    @Override
    public Poll getPollById(Long pollId) {
        checkById(pollId);
        return pollRepository.findById(pollId).get();
    }

    @Override
    public List<Poll> getAllPollsBySurveyId(Long id) {
        SurveyService.checkById(id);
        return pollRepository.findAllBySurveyId(id);
    }

    @Override
    public void deletePoll(Long pollId) {}

    @Override
    public void checkById(Long id) throws NotFoundException {
        if (!pollRepository.existsById(id)) {
            throw new NotFoundException("Не найден вопрос с таким id в базе данных");
        }
    }
}
