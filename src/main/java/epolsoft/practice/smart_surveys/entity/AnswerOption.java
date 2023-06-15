package epolsoft.practice.smart_surveys.entity;
import epolsoft.practice.smart_surveys.enums.RoleType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Formula;
import epolsoft.practice.smart_surveys.enums.AnswerType;

@Entity
@Table(name = "answer_option")
@Data
public class AnswerOption
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "poll_id", referencedColumnName = "id")
    private Poll poll;
    @Column(name = "option_image", nullable = false, columnDefinition = "BLOB")
    private String image;
    @Column(name = "option_text", nullable = false, columnDefinition = "text")
    private String option;
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AnswerType type;
    @Column(name = "voted_count", nullable = false, columnDefinition = "integer default 0")
    @Formula("(SELECT COUNT(id) FROM user_vote WHERE answer_option_id=id)")
    private int voted_count;
}
