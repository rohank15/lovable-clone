package com.rohan.lovable_clone.service.impl;

import com.rohan.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.rohan.lovable_clone.dto.subscription.UsageTodayResponse;
import com.rohan.lovable_clone.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfAUser(Long userId) {
        return null;
    }
}
