package epolsoft.practice.smart_surveys.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "{name.notBlank}")
    @Size(min = 1, max = 50, message = "{name.wrongSize}")
    private String name;

    @NotBlank(message = "{email.notBlank}")
    @Size(min = 1, max = 30, message = "{email.wrongSize}")
    @Email(message = "{email.invalid}")
    private String email;

    @NotBlank(message = "{password.notBlank}")
    @Size(min = 6, message = "{password.wrongSize}")
    private String password;

    @NotBlank(message = "{roleType.notNull}")
    private String role;
}
