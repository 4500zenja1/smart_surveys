package epolsoft.practice.smart_surveys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import epolsoft.practice.smart_surveys.entity.enums.PollType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionRequestDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("poll_id")
    private Long pollId;
    @JsonProperty("image")
    private byte[] optionImage;
    @JsonProperty("text")
    private String[] optionText;
    @JsonProperty("voted_count")
    private int votedCount;
    @JsonProperty("type")
    private PollType type;
}
