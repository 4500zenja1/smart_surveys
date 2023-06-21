package epolsoft.practice.smart_surveys.dto;

import epolsoft.practice.smart_surveys.entity.enums.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private Long id;

    @NotBlank(message = "Имя не может отсутствовать")
    private String name;

    @Email
    private String email;

    @NotBlank(message = "Пароль не может отсутствовать")
    private String password;

    private RoleType role;
}
