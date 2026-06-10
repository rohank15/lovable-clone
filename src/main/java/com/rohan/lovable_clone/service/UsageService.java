package com.rohan.lovable_clone.service;

import com.rohan.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.rohan.lovable_clone.dto.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfAUser(Long userId);
}
