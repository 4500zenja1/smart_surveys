package epolsoft.practice.smart_surveys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollResponseDto {
    private Long id;

    private byte[] pollImage;

    private String question;
}
