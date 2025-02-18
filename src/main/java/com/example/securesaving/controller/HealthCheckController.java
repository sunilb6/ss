package com.example.securesaving.controller;

import com.example.securesaving.dao.EmployeeDAO;
import com.example.securesaving.entity.Employee;
import com.example.securesaving.entity.Student;
import com.example.securesaving.repository.Coach;
import com.example.securesaving.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class HealthCheckController {

    @Value("${dev.user.name}")
    private String devUserName;

    /*
    // Field Injection (not recommended by Spring.io)
    @Autowired
    private Coach myCoash;
    */

    private Coach myCoach;


    //Example of Constructor Injection
    //Qualifier beanId should be same as Class name but the first leter should be small
    /*@Autowired
    public HealthCheckController(@Qualifier("baseBallCoach") Coach theCoach) {
        myCoach = theCoach;
    }*/

    //Example of @Primary annotation on Coach
    @Autowired
    public HealthCheckController(Coach theCoach) {
        myCoach = theCoach;
    }

    /*
    //Example of Setter injection, we can give any method name we want
    @Autowired
    public void setCoach(Coach theCoach) {
        myCoash = theCoach;
    }*/

    @GetMapping("/liveness")
    public ResponseEntity<HashMap> liveness() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("statusCode", 0);
        result.put("status", "ok");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/readiness")
    public ResponseEntity<HashMap> readiness() {
        boolean isReady = checkDatabaseConnection();
        HashMap<String, Object> result = new HashMap<>();
        result.put("statusCode", 0);
        result.put("status", isReady);
        return isReady ? ResponseEntity.ok(result) : ResponseEntity.status(503).body(result);
    }

    @GetMapping("/info")
    public ResponseEntity<HashMap> info() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("msg", devUserName);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/workout")
    public ResponseEntity<HashMap> getWorkout() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("msg", myCoach.getDailyWorkout());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student("Sunil", "Behera"));
        listOfStudents.add(new Student("Abinash", "BGadsaraehera"));

        return listOfStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentDetails(@PathVariable String studentId) {
        try {
            int sId = Integer.parseInt(studentId);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private boolean checkDatabaseConnection() {
        // Simulate a readiness check (replace with actual DB health check logic)
        return true;
    }
}
