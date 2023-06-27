package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.dto.JwtResponseDto;
import epolsoft.practice.smart_surveys.dto.LoginRequestDto;
import epolsoft.practice.smart_surveys.dto.UserRequestDto;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;

import java.util.List;

public interface UserService {
    User createUser(UserRequestDto userRequestDto);

    JwtResponseDto authenticateUser(LoginRequestDto loginRequest);

    User getUserById(Long id);

    void checkById(Long id) throws NotFoundException;

    List<User> getAllUsers();

    void updateUser(User user,Long id);

    void changePassword(Long id,String password);

    void deleteUser(Long id);
}
