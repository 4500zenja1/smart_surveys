package epolsoft.practice.smart_surveys.controller;

import epolsoft.practice.smart_surveys.dto.UserRequestDto;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.mapper.UserMapper;
import epolsoft.practice.smart_surveys.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "Пользователи", description = "Все методы для работы с пользователями")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/admin/update")
    public void updateUser(@Valid @RequestBody UserRequestDto userRequestDto) {
       User user  = userMapper.toEntity(userRequestDto);
       userService.updateUser(user);
    }

    @PostMapping("/update")
    public void changePassword(@Valid @RequestBody UserRequestDto userRequestDto){
        User user  = userMapper.toEntity(userRequestDto);
        userService.changePassword(user);
    }
}
