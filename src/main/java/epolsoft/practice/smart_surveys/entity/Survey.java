package epolsoft.practice.smart_surveys.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "survey")
@Data
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "survey_title", nullable = false, length = 50)
    private String surveyTitle;

    @Column(name = "survey_description", length = 200)
    private String surveyDescription;

    @Column(name = "anonymity")
    private Boolean anonymity;

    @Column(name = "repeat_survey_interval", nullable = true, columnDefinition = "interval")
    private Duration interval;

    @Column(name = "open_survey_date", nullable = false, columnDefinition = "timestamp")
    private LocalDateTime openSurveyDate;

    @Column(name = "close_survey_date", nullable = false, columnDefinition = "timestamp")
    private LocalDateTime closeSurveyDate;

    @Column(name = "close_survey_iterable_date", nullable = false, columnDefinition = "timestamp")
    private LocalDateTime closeSurveyIterableDate;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;
}