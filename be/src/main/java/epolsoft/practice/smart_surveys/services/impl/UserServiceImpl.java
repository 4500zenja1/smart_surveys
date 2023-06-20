package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.repository.UserRepository;
import epolsoft.practice.smart_surveys.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
    }

    @Override
    public User getUserById(Long id) {
        checkById(id);
        return userRepository.findById(id).get();
    }

    @Override
    public void getAllUsers() {
    }

    @Override
    public void updateUser(User user, Long id) {
    }

    @Override
    public void deleteUser(Long id) {
    }

    public void checkById(Long id) throws ResponseStatusException {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Не найден пользователь с таким id в базе данных"
            );
        }
    }
}
