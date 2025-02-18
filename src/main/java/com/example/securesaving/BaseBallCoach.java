package com.example.securesaving;

import com.example.securesaving.repository.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice Base Ball Everyday";
    }
}
