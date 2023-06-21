package epolsoft.practice.smart_surveys.dto;

import epolsoft.practice.smart_surveys.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVoteResponseDto {
    private Long answerOptionId;

    private Long userId;

    private String text;
}
