package epolsoft.practice.smart_surveys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import epolsoft.practice.smart_surveys.entity.Poll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerOptionDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("text")
    private Long text;

    @JsonProperty("poll")
    private Poll poll;
}
