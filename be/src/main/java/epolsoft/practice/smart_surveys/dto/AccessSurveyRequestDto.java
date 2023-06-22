package epolsoft.practice.smart_surveys.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessSurveyRequestDto {
    @NotNull
    private Boolean showResult;

    @NotNull
    private Long surveyId;

    @NotNull
    private Long userId;
}
