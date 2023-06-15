package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.User;

public interface UserService {
    void createUser(User user);

    User getUserById(Long id);

    void getAllUsers();

    void updateUser(User user, Long id);

    void deleteUser(Long id);
}
