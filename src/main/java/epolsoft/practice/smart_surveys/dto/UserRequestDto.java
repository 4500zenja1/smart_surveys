package epolsoft.practice.smart_surveys.dto;

import epolsoft.practice.smart_surveys.entity.enums.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private Long id;

    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;

    @NotEmpty
    @Size(min = 1, max = 30)
    private String email;

    // потом можем определить дальнейшие ограничения для пароля (регулярку, длину и пр.)
    @NotEmpty
    @Size(min = 1)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleType role;
}
