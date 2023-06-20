package epolsoft.practice.smart_surveys.dto;

import epolsoft.practice.smart_surveys.entity.enums.PollType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollRequestDto {
    @NotEmpty
    @Size(min = 1)
    private String question;

    @Lob
    @Nullable
    private byte[] pollDescriptionImage;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PollType pollType;

    @NotNull
    private List<AnswerOptionRequestDto> answers;
}
