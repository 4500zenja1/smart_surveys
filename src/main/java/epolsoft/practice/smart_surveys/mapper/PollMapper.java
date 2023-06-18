package epolsoft.practice.smart_surveys.mapper;

import epolsoft.practice.smart_surveys.dto.AnswerOptionRequestDto;
import epolsoft.practice.smart_surveys.dto.PollRequestDto;
import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.entity.Poll;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PollMapper {
    AnswerOptionRequestDto answerToAnswerOptionDto(AnswerOption answerOption);

    PollRequestDto pollToPollRequestDto(Poll poll);

    List<PollRequestDto> pollsToPollRequestDto(List<Poll> polls);
}
