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
    @JsonProperty("id")
    private Long id;
    @JsonProperty("survey_id")
    private Long surveyId;
    @JsonProperty("image")
    private byte[] pollImage;
    @JsonProperty("question")
    private String question;
    @JsonProperty("type")
    private PollType type;
    @JsonProperty("answers")
    private List<AnswerOption> answers;
}
