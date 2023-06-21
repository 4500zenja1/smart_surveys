package epolsoft.practice.smart_surveys.controller;

import epolsoft.practice.smart_surveys.dto.UserUpdateRequestDto;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.mapper.UserMapper;
import epolsoft.practice.smart_surveys.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/user")
@Tag(name = "Пользователи", description = "Все методы для работы с пользователями")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Operation(summary = "Изменение данных пользователя админом")
    @PostMapping("/update/{id}")
    public void updateUser(@Valid @RequestBody UserUpdateRequestDto userUpdateRequestDto, @PathVariable Long id) {
        User user = userMapper.toEntity(userUpdateRequestDto);
        userService.updateUser(user, id);
    }

    @Operation(summary = "Изменение пароля пользователем")
    @PostMapping("/update/{id}/{password}")
    public void changePassword(@PathVariable Long id,
                               @Size(min = 6, message = "Пароль должен быть больше 6 символов") @PathVariable String password) {
        userService.changePassword(id, password);
    }
}
