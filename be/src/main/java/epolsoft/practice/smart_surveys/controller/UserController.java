package epolsoft.practice.smart_surveys.controller;

import epolsoft.practice.smart_surveys.dto.UserRequestDto;
import epolsoft.practice.smart_surveys.dto.UserResponseDto;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.mapper.UserMapper;
import epolsoft.practice.smart_surveys.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/user")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Пользователи", description = "Все методы для работы с пользователями")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Operation(summary = "Изменение данных пользователя админом")
    @PatchMapping("/update/{id}")
    public void updateUser(@Valid @RequestBody UserRequestDto userDto, @PathVariable Long id) {
        User user = userMapper.toEntity(userDto);
        userService.updateUser(user, id);
    }

    @Operation(summary = "Изменение пароля пользователем")
    @PatchMapping(value = "/update_password/{id}")
    public void changePassword(@PathVariable Long id,
                               @Size(min = 6, message = "Пароль должен быть больше 6 символов") @RequestBody String password) {
        userService.changePassword(id, password);
    }

    @Operation(summary = "Получить пользователя по id")
    public UserResponseDto getByID(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return userMapper.toResponseDto(user);
    }

    @Operation(summary = "Получение всех пользователей")
    @GetMapping()
    public List<UserResponseDto> getAll() {
        List<User> users = userService.getAllUsers();
        return userMapper.toResponseDtos(users);
    }

    @Operation(summary = "Создать нового пользователя")
    @PostMapping("/new")
    public UserResponseDto createUser(@Valid @RequestBody UserRequestDto userDto) {
        return userMapper.toResponseDto(userService.createUser(userDto));
    }

}
