package epolsoft.practice.smart_surveys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.entity.enums.PollType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollRequestDto {
    private Long id;

    private Long surveyId;

    private byte[] pollImage;

    private String question;

    private PollType type;

    private List<AnswerOption> answers;
}
