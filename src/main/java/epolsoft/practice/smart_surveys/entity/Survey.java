package epolsoft.practice.smart_surveys.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Duration;
import java.util.Date;

@Entity
@Table(name = "survey")
@Data
@NoArgsConstructor
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "survey_title",nullable = false,length = 50)
    private String surveyTitle;
    @Column(name = "survey_description",length = 200)
    private String surveyDescription;
    @Column(name = "anonymity")
    private boolean anonymity;
    @Column(name = "repeat_survey_interval",nullable = false,columnDefinition = "interval")
    private Duration interval;
    @Column(name = "open_survey_date",nullable = false,columnDefinition = "timestamp")
    private Date openSurveyDate;
    @Column(name = "close_survey_date",nullable = false,columnDefinition = "timestamp")
    private Date closeSurveyDate;
    @Column(name = "close_survey_iterable_date",nullable = false,columnDefinition = "timestamp")
    private Date closeSurveyIterableDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private User surveyAuthor;
}
