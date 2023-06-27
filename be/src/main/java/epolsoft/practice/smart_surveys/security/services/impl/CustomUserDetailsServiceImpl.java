package epolsoft.practice.smart_surveys.security.services.impl;

import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.repository.UserRepository;
import epolsoft.practice.smart_surveys.security.entity.CustomUserDetails;
import epolsoft.practice.smart_surveys.security.services.CustomUserDetailsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public CustomUserDetails loadUserByUsername(String username) throws NotFoundException {
        User user = userRepository.findByName(username)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Пользователь с именем %s не найден", username)
                ));

        return CustomUserDetails.build(user);
    }

}
