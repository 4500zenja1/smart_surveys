package epolsoft.practice.smart_surveys.dto;

import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.entity.enums.PollType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PollRequestDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 1)
    private String question;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PollType poll_type;
}
