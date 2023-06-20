package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;

public interface UserService {
    void createUser(User user);

    User getUserById(Long id);

    void checkById(Long id) throws NotFoundException;

    void getAllUsers();

    void updateUser(User user, Long id);

    void deleteUser(Long id);
}
