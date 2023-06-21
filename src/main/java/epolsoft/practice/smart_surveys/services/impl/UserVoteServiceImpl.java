package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.dto.UserVoteRequestDto;
import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.entity.UserVote;
import epolsoft.practice.smart_surveys.mapper.UserVoteMapper;
import epolsoft.practice.smart_surveys.repository.AnswerOptionRepository;
import epolsoft.practice.smart_surveys.repository.UserRepository;
import epolsoft.practice.smart_surveys.repository.UserVoteRepository;
import epolsoft.practice.smart_surveys.services.UserService;
import epolsoft.practice.smart_surveys.services.UserVoteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import epolsoft.practice.smart_surveys.exceptions.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserVoteServiceImpl implements UserVoteService {
    @Autowired
    private UserService userService;
    @Autowired
    private AnswerOptionRepository answerOptionRepository;
    @Autowired
    private UserVoteRepository userVoteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserVoteMapper userVoteMapper;

    @Override
    public List<UserVoteRequestDto> createUserVotes(List<UserVoteRequestDto> userVotes) {
        for (UserVoteRequestDto userVote : userVotes) {
            if (!answerOptionRepository.existsById(userVote.getAnswerOptionId()))
                throw new NotFoundException("Варианта ответа с таким ID не существует");

            userService.checkById(userVote.getUserId());

            AnswerOption answerOption = answerOptionRepository.getReferenceById(userVote.getAnswerOptionId());
            answerOption.setId(userVote.getAnswerOptionId());
            answerOption.setVotedCount();

            this.userVoteRepository.save(userVoteMapper.toSingleEntity(userVote));
        }
        return userVotes;
    }
}
