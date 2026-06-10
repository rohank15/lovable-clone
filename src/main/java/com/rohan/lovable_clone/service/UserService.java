package com.rohan.lovable_clone.service;

import com.rohan.lovable_clone.dto.auth.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
