package com.rohan.lovable_clone.service;

import com.rohan.lovable_clone.dto.auth.AuthResponse;
import com.rohan.lovable_clone.dto.auth.LoginRequest;
import com.rohan.lovable_clone.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
