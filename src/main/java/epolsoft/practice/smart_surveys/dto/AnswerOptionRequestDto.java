package epolsoft.practice.smart_surveys.dto;

import epolsoft.practice.smart_surveys.entity.enums.AnswerType;
import epolsoft.practice.smart_surveys.entity.enums.PollType;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    private String option;

    @Lob
    @Nullable
    private byte[] optionImage;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AnswerType answerType;
}
