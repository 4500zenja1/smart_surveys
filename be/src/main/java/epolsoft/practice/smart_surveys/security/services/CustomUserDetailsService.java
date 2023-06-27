package epolsoft.practice.smart_surveys.security.services;

import epolsoft.practice.smart_surveys.exceptions.NotFoundException;
import epolsoft.practice.smart_surveys.security.entity.CustomUserDetails;

public interface CustomUserDetailsService {
    CustomUserDetails loadUserByUsername(String username) throws NotFoundException;
}
