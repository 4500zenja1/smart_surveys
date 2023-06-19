package epolsoft.practice.smart_surveys.mapper;

import epolsoft.practice.smart_surveys.dto.PollRequestDto;
import epolsoft.practice.smart_surveys.entity.Poll;

import java.util.List;

public interface PollMapper {
    Poll pollRequestDtoToPoll(PollRequestDto pollDto);
    List<Poll> pollsRequestDtoToPolls(List<PollRequestDto> pollsDto);
}
