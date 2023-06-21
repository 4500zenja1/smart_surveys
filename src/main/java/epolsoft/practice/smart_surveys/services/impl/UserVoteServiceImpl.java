package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.dto.UserVoteRequestDto;
import epolsoft.practice.smart_surveys.dto.UserVoteResponseDto;
import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.entity.UserVote;
import epolsoft.practice.smart_surveys.mapper.UserVoteMapper;
import epolsoft.practice.smart_surveys.repository.AnswerOptionRepository;
import epolsoft.practice.smart_surveys.repository.UserRepository;
import epolsoft.practice.smart_surveys.repository.UserVoteRepository;
import epolsoft.practice.smart_surveys.services.AnswerOptionService;
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
    private UserVoteRepository userVoteRepository;
    @Autowired
    private UserVoteMapper userVoteMapper;
    @Autowired
    private AnswerOptionService answerOptionService;

    @Override
    public List<UserVoteResponseDto> createUserVotes(List<UserVoteResponseDto> userVotes) {
        userService.checkById(userVotes.get(0).getUserId());
        answerOptionService.checkAll(userVotes);
        this.userVoteRepository.saveAll(userVoteMapper.toEntity(userVotes));
        return userVotes;
    }
}
