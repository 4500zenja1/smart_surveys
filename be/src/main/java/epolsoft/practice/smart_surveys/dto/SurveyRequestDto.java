package epolsoft.practice.smart_surveys.dto;

import epolsoft.practice.smart_surveys.entity.enums.TimeType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyRequestDto {
    @NotBlank(message = "{surveyTitle.notBlank}")
    @Size(min = 1, max = 50, message = "{surveyTitle.wrongSize}")
    private String surveyTitle;

    @Lob
    @Nullable
    private byte[] surveyDescriptionImage;

    @NotBlank(message = "{surveyDescription.notBlank}")
    @Size(min = 1, max = 200, message = "{surveyDescription.wrongSize}")
    private String surveyDescription;

    @NotNull(message = "{anonymity.notNull}")
    private Boolean anonymity;

    @NotNull(message = "{timeAmount.notNull}")
    @PositiveOrZero(message = "{timeAmount.notNegative}")
    private Integer timeAmount;

    @NotNull(message = "{timeType.notNull}")
    @Enumerated(EnumType.STRING)
    private TimeType timeType;

    @NotNull(message = "{openSurveyDate.notNull}")
    private LocalDateTime openSurveyDate;

    @NotNull(message = "{closeSurveyDate.notNull}")
    private LocalDateTime closeSurveyDate;

    @NotNull(message = "{closeSurveyIterableDate.notNull}")
    private LocalDateTime closeSurveyIterableDate;

    @NotNull(message = "{authorId.notNull}")
    private Long authorId;

    @NotNull(message = "{listPoll.notNull}")
    private List<PollRequestDto> polls;
}
