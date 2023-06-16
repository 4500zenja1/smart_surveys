package epolsoft.practice.smart_surveys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollResponseDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("image")
    private byte[] pollImage;
    @JsonProperty("question")
    private String question;
}
