package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.dto.JwtResponseDto;
import epolsoft.practice.smart_surveys.dto.LoginRequestDto;
import epolsoft.practice.smart_surveys.dto.UserRequestDto;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User createUser(UserRequestDto userRequestDto);

    JwtResponseDto authenticateUser(LoginRequestDto loginRequest);

    User getCurrentUser();

    User getUserById(Long id);

    void checkById(Long id) throws NotFoundException;

    List<User> getAllUsers();
    User loadUserByUsername(String username) throws NotFoundException;

    void updateUser(User user,Long id);

    void changePassword(String password);

    void deleteUser(Long id);
}
