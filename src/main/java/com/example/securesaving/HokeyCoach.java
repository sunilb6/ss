package com.example.securesaving;

import com.example.securesaving.repository.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HokeyCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Play Hockey Man";
    }
}
