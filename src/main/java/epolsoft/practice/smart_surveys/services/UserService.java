package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void createUser (User user);
    void getUserById(Long id);
    void getAllUsers();
    void updateUser(User user, Long id);
    void deleteUser(Long id);
}
