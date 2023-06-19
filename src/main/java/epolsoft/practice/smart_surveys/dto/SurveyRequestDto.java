package epolsoft.practice.smart_surveys.dto;

import epolsoft.practice.smart_surveys.entity.enums.TimeType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SurveyRequestDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 1, max = 50)
    private String surveyTitle;

    @Lob
    @Nullable
    private byte[] surveyDescriptionImage;

    @NotEmpty
    @Size(min = 1, max = 200)
    private String surveyDescription;

    @NotNull
    private Boolean anonymity;

    @NotNull
    @Min(1)
    private Integer timeAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TimeType timeType;

    @NotNull
    private LocalDateTime openSurveyDate;

    @NotNull
    private LocalDateTime closeSurveyDate;

    @NotNull
    private LocalDateTime closeSurveyIterableDate;

    @NotNull
    @ManyToOne
    private UserRequestDto author;

    @Nullable
    @OneToMany
    private List<PollRequestDto> polls;
}
