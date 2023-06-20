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
import lombok.Data;

@Entity
@Table(name = "answer_option")
@Data
public class AnswerOption
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "poll_id", referencedColumnName = "id")
    private Poll poll;

    @Column(name = "option_text", nullable = false, columnDefinition = "text")
    private String option;

    @Column(name = "voted_count", nullable = false, columnDefinition = "integer default 0")
    private int votedCount;
}
