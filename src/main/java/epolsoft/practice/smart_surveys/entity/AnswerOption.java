package epolsoft.practice.smart_surveys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.repository.Query;

@Entity
@Table(name = "answer_option")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerOption
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "poll_id", referencedColumnName = "id")
    private Poll poll;

    @Column(name = "option_text", nullable = false, columnDefinition = "text")
    private String option;

    @Formula("(SELECT COUNT(*) + 1 FROM user_vote u WHERE u.answer_option_id=id)")
    private int count;

    @Column(name = "voted_count", nullable = false, columnDefinition = "integer default 0")
    private int votedCount;

    @Query("update AnswerOption ao set ao.votedCount = count where ao.id = id")
    public void setVotedCount() {this.votedCount=this.count;}
}
