package epolsoft.practice.smart_surveys.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVoteRequestDto {
    @NotNull
    private Long answerOptionId;

    @NotNull
    private String text;
}
