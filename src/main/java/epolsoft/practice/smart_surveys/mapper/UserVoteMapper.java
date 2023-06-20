package epolsoft.practice.smart_surveys.mapper;

import epolsoft.practice.smart_surveys.dto.UserVoteRequestDto;
import epolsoft.practice.smart_surveys.dto.UserVoteResponseDto;
import epolsoft.practice.smart_surveys.entity.UserVote;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserVoteMapper {
    List<UserVote> toEntity(List<UserVoteRequestDto> userVoteDto);
    UserVoteResponseDto toResponseDto(UserVote userVote);
    List<UserVoteResponseDto> toResponseDtos(List<UserVote> userVotes);
}
