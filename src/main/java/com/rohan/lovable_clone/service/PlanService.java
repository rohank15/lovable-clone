package com.rohan.lovable_clone.service;

import com.rohan.lovable_clone.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllPlans();
}
