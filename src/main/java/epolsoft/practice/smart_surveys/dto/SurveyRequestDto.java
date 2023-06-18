package epolsoft.practice.smart_surveys.dto;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;
import org.postgresql.util.PGInterval;

import java.time.LocalDateTime;


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
    private PGInterval interval;

    @NotNull
    private LocalDateTime openSurveyDate;

    @NotNull
    private LocalDateTime closeSurveyDate;

    @NotNull
    private LocalDateTime closeSurveyIterableDate;

    @NotNull
    @ManyToOne
    private UserRequestDto author;
}
