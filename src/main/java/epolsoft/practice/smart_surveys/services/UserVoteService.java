package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.dto.UserVoteRequestDto;
import epolsoft.practice.smart_surveys.dto.UserVoteResponseDto;
import epolsoft.practice.smart_surveys.entity.UserVote;
import java.util.List;

public interface UserVoteService {
    public List<UserVoteResponseDto> createUserVotes(List<UserVoteResponseDto> userVotes);
}
