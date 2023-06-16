package epolsoft.practice.smart_surveys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionResponseDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("image")
    private byte[] optionImage;
    @JsonProperty("text")
    private String[] optionText;
}
