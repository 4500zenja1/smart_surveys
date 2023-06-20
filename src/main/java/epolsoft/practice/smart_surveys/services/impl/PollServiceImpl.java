package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.entity.Poll;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.repository.PollRepository;
import epolsoft.practice.smart_surveys.services.AnswerOptionService;
import epolsoft.practice.smart_surveys.services.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PollServiceImpl implements PollService {
    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private AnswerOptionService answerOptionService;

    @Override
    @Transactional
    public Poll createPoll(Poll poll) {
        List<AnswerOption> answers = poll.getAnswers();
        for (AnswerOption answerOption: answers) {
            answerOptionService.createAnswerOption(answerOption);
        }
        return pollRepository.save(poll);
    }
}
