package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.repository.UserRepository;
import epolsoft.practice.smart_surveys.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        else{
            throw new NullPointerException();
        }
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

    public void checkById(Long id) throws NotFoundException {
        if(!userRepository.existsById(id)){
            throw new NotFoundException("Не найден пользователь с таким id в базе данных");
        }

    }
}
