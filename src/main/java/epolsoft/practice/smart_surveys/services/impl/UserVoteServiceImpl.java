package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.UserVote;
import epolsoft.practice.smart_surveys.repository.UserVoteRepository;
import epolsoft.practice.smart_surveys.services.UserVoteService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserVoteServiceImpl implements UserVoteService {
    @Autowired
    private UserVoteRepository userVoteRepository;
    @Override
    public UserVote createUserVote(UserVote userVote) {
        UserVote userSavedToDB = this.userVoteRepository.save(userVote);
        return userSavedToDB;
    }

    @Override
    public UserVote getUserVote(Long userVoteId) {
        UserVote userVote = this.userVoteRepository.getById(userVoteId);
        return userVote;
    }
}
