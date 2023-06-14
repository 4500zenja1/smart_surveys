package epolsoft.practice.smart_surveys.entity;

import epolsoft.practice.smart_surveys.enums.PollType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "poll")
@Data
@NoArgsConstructor
public class Poll
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "survey_id", referencedColumnName = "id")
    private Survey survey;
    @Column(name = "question_text", nullable = false, columnDefinition = "text")
    private String question;
    @Column(name = "poll_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PollType poll_type;
}