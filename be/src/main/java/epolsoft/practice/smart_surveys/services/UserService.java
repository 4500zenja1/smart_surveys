package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.dto.UserRequestDto;
import epolsoft.practice.smart_surveys.dto.UserUpdateRequestDto;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;

import java.util.List;

public interface UserService {
    User createUser(UserUpdateRequestDto userUpdateRequestDto);

    User getUserById(Long id);

    void checkById(Long id) throws NotFoundException;

    List<User> getAllUsers();

    void updateUser(User user,Long id);

    void changePassword(Long id,String password);

    void deleteUser(Long id);
}
