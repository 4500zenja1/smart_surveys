package epolsoft.practice.smart_surveys.dto;

import epolsoft.practice.smart_surveys.entity.enums.PollType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionRequestDto {
    private Long id;
    private Long pollId;
    private byte[] optionImage;
    private String optionText;
    private int votedCount;
    private PollType type;
}
