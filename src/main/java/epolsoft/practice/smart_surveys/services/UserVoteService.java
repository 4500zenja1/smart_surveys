package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.entity.UserVote;

import java.util.List;

public interface UserVoteService {
    public List<UserVote> createUserVotes(List<UserVote> userVotes);
}
