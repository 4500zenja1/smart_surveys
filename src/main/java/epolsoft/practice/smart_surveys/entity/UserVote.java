package epolsoft.practice.smart_surveys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import epolsoft.practice.smart_surveys.entity.enums.RoleType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_vote")
@Data
@NoArgsConstructor
public class UserVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "answer_option_id", nullable = false, columnDefinition = "bigint")
    private Long answerOptionId;

    @Column(name = "user_id", nullable = false, columnDefinition = "bigint")
    private Long userId;

    @Column(name = "text", nullable = false, columnDefinition = "text")
    private String text;
}


