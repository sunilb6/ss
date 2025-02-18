package com.example.securesaving;

import com.example.securesaving.repository.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * "@Component" mark the class as Spring bean and makes it available for DI (Dependency Injection)
 * Whe do you see "no usage"? Due to the dynamic nature of Spring Boot, some time the IDE not able figure out how
 * beans are injected and also since most of the time we are coding to the interface, we may not explicitly reference the
 * implementation class in our Spring app, we simply let Spring do its work behind the scene, of injecting the
 * appropriate implementation as needed.
 *
 * So behind the scene Spring will create a new instance of your CricketCoach class, also perform DI with my HealthCheckController
 * so theCoach is a Dependency or a helper for HealthCheckController
 */
@Primary
@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice Cricket Everyday";
    }
}
