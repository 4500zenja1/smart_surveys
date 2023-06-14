package epolsoft.practice.smart_surveys.entity;
import jakarta.persistence.*;

public class AnswerOption
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "poll_id", referencedColumnName = "id")
    private Poll poll;
    @Column(name = "option_text", nullable = false, columnDefinition = "text")
    private String option;
    @Column(name = "voted_count", nullable = false, columnDefinition = "integer default 0")
    private int voted_count;
}
