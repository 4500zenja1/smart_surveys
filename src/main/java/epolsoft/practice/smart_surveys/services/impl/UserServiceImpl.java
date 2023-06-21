package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.repository.UserRepository;
import epolsoft.practice.smart_surveys.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void updateUser(User newUser) {
          User user = getUserById(newUser.getId());
          user.setName(newUser.getName());
          user.setEmail(newUser.getEmail());
          user.setName(newUser.getName());
          user.setRole(newUser.getRole());
          user.setPassword(newUser.getPassword());
          userRepository.save(user);
    }

    @Override
    @Transactional
    public void changePassword(User newUser) {
        User user = getUserById(newUser.getId());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
    }

    public void checkById(Long id) throws NotFoundException {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("Не найден пользователь с таким id в базе данных");
        }
    }
}
