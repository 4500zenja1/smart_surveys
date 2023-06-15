package epolsoft.practice.smart_surveys.dto;

import epolsoft.practice.smart_surveys.entity.Poll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyRequestDto {
    private Long id;

    private String surveyTitle;

    private byte[] surveyDescriptionImage;

    private String surveyDescription;

    private Boolean anonymity;

    private String interval;

    private LocalDateTime openSurveyDate;

    private LocalDateTime closeSurveyDate;

    private LocalDateTime closeSurveyIterableDate;

    private UserResponseDto author;

    private List<Poll> polls = new ArrayList<>();
}
