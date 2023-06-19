package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.entity.UserVote;
import epolsoft.practice.smart_surveys.repository.AnswerOptionRepository;
import epolsoft.practice.smart_surveys.repository.UserRepository;
import epolsoft.practice.smart_surveys.repository.UserVoteRepository;
import epolsoft.practice.smart_surveys.services.UserVoteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import epolsoft.practice.smart_surveys.exceptions.*;

@Service
@RequiredArgsConstructor
@Transactional
public class UserVoteServiceImpl implements UserVoteService {
    @Autowired
    private AnswerOptionRepository answerOptionRepository;
    @Autowired
    private UserVoteRepository userVoteRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserVote createUserVote(UserVote userVote) {
        /*
        Long userVoteId = userVote.getId();
        if(userVoteRepository.existsById(userVoteId))
            throw new AlreadyExistsException("Результат голосования с таким ID уже существует");

        AnswerOption answerOption = userVote.getAnswerOption();
        Long answerOptionId = answerOption.getId();
        if(!answerOptionRepository.existsById(answerOptionId))
            throw new NotFoundException("Варианта ответа с таким ID не существует");

        User user = userVote.getUser();
        Long userId = user.getId();
        if(!userRepository.existsById(userId))
            throw new NotFoundException("Пользователя с таким ID не существует");
*/

        AnswerOption answerOption = userVote.getAnswerOption();
        Long answerOptionId = answerOption.getId();
        userVoteRepository.incrementVoteCount(answerOptionId);
        return this.userVoteRepository.save(userVote);
    }

    @Override
    public UserVote getUserVote(Long userVoteId) {
        UserVote userVote = this.userVoteRepository.getById(userVoteId);
        return userVote;
    }
}
