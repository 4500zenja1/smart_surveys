package epolsoft.practice.smart_surveys.dto;

import epolsoft.practice.smart_surveys.entity.enums.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "Имя не может отсутствовать")
    @Size(min = 1, max = 50)
    private String name;

    @Email
    @NotEmpty
    @Size(min = 1, max = 30)
    private String email;

    // потом можем определить дальнейшие ограничения для пароля (регулярку, длину и пр.)
    @NotBlank(message = "Пароль не может отсутствовать")
    @Size(min = 6, message = "Пароль должен быть больше 6 символов")
    private String password;

    @NotNull(message = "Роль не может отсутствовать")
    @Enumerated(EnumType.STRING)
    private RoleType role;
}
