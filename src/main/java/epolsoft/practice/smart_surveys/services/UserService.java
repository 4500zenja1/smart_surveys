package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.User;
import org.springframework.web.server.ResponseStatusException;

public interface UserService {
    void createUser(User user);

    User getUserById(Long id);

    void checkById(Long id) throws ResponseStatusException;

    void getAllUsers();

    void updateUser(User user, Long id);

    void deleteUser(Long id);
}
