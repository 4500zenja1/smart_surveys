package epolsoft.practice.smart_surveys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerOptionResponseDto {

    private Long id;

    private String option;

    private int votedCount;

    private double votedInPercent;
}
