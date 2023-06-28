package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.config.JwtUtils;
import epolsoft.practice.smart_surveys.dto.JwtResponseDto;
import epolsoft.practice.smart_surveys.dto.LoginRequestDto;
import epolsoft.practice.smart_surveys.dto.UserRequestDto;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.entity.enums.RoleType;
import epolsoft.practice.smart_surveys.exceptions.AlreadyExistsException;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.mapper.UserMapper;
import epolsoft.practice.smart_surveys.repository.UserRepository;
import epolsoft.practice.smart_surveys.security.entity.CustomUserDetails;
import epolsoft.practice.smart_surveys.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public User createUser(UserRequestDto userRequestDto) {
        String name = userRequestDto.getName();
        if (userRepository.existsByName(name)) {
            throw new AlreadyExistsException(
                    String.format("Пользователь с именем %s уже существует", name)
            );
        }
        String email = userRequestDto.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new AlreadyExistsException(
                    String.format("Пользователь с эл. почтой %s уже существует", email)
            );
        }
        String password = userRequestDto.getPassword();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));

        String role = userRequestDto.getRole().toUpperCase();
        switch (role) {
            case "ADMIN" -> user.setRole(RoleType.ADMIN);
            case "MODER" -> user.setRole(RoleType.MODER);
            case "USER" -> user.setRole(RoleType.USER);
            default -> throw new NotFoundException(
                    String.format("Не найдена роль с названием %s", role)
            );
        }

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public JwtResponseDto authenticateUser(LoginRequestDto loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        RoleType role = RoleType.valueOf(userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .toList().get(0));

        JwtResponseDto jwtResponse = new JwtResponseDto();
        jwtResponse.setToken(jwt);
        jwtResponse.setId(userDetails.getId());
        jwtResponse.setUsername(userDetails.getUsername());
        jwtResponse.setEmail(userDetails.getEmail());
        jwtResponse.setRole(role);
        return jwtResponse;
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
    public void updateUser(User newUser, Long id) {
        User user = getUserById(id);
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setName(newUser.getName());
        user.setRole(newUser.getRole());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void changePassword(Long id, String password) {
        User user = getUserById(id);
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
