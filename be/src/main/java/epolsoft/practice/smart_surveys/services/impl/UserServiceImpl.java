package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.config.JwtUtils;
import epolsoft.practice.smart_surveys.dto.JwtResponseDto;
import epolsoft.practice.smart_surveys.dto.LoginRequestDto;
import epolsoft.practice.smart_surveys.dto.UserRequestDto;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.entity.enums.RoleType;
import epolsoft.practice.smart_surveys.exceptions.AlreadyExistsException;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.repository.UserRepository;
import epolsoft.practice.smart_surveys.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Lazy
    @Autowired
    AuthenticationManager authenticationManager;
    @Lazy
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public User createUser(UserRequestDto userRequestDto) {
        String username = userRequestDto.getUsername();
        if (userRepository.existsByUsername(username)) {
            throw new AlreadyExistsException(
                    String.format("Пользователь с именем %s уже существует", username)
            );
        }
        String email = userRequestDto.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new AlreadyExistsException(
                    String.format("Пользователь с эл. почтой %s уже существует", email)
            );
        }
        String password = userRequestDto.getPassword();
        RoleType role = userRequestDto.getRole();

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setRole(role);

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public JwtResponseDto authenticateUser(LoginRequestDto loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();
        RoleType role = userDetails.getRole();

        JwtResponseDto jwtResponse = new JwtResponseDto();
        jwtResponse.setToken(jwt);
        jwtResponse.setId(userDetails.getId());
        jwtResponse.setUsername(userDetails.getUsername());
        jwtResponse.setEmail(userDetails.getEmail());
        jwtResponse.setRole(role);
        return jwtResponse;
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Long userId = ((User)authentication.getPrincipal()).getId();
        return userRepository.findById(userId).get();
    }

    @Override
    public User getUserById(Long id) {
        checkById(id);
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User loadUserByUsername(String username) throws NotFoundException {

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Пользователь с именем %s не найден", username)
                ));
    }

    @Override
    @Transactional
    public void updateUser(User newUser, Long id) {
        User user = getUserById(id);
        user.setUsername(newUser.getUsername());
        user.setEmail(newUser.getEmail());
        user.setUsername(newUser.getUsername());
        user.setRole(newUser.getRole());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void changePassword(String password) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Long userId = ((User)authentication.getPrincipal()).getId();
        User user = getUserById(userId);

        user.setPassword(password);
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
