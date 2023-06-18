package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.UserVote;

public interface UserVoteService {
    public UserVote createUserVote(UserVote userVote);
    public UserVote getUserVote(Long userVoteId);
}
