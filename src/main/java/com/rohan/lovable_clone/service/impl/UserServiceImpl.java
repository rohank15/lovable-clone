package com.rohan.lovable_clone.service.impl;

import com.rohan.lovable_clone.dto.auth.UserProfileResponse;
import com.rohan.lovable_clone.error.ResourceNotFoundException;
import com.rohan.lovable_clone.repository.UserRepository;
import com.rohan.lovable_clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User: ", username));
    }
}
