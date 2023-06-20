package epolsoft.practice.smart_surveys.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerOptionRequestDto {
    @NotEmpty
    @Size(min = 1)
    private String optionText;
}
