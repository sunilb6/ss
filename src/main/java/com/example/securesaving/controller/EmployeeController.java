package com.example.securesaving.controller;

import com.example.securesaving.entity.Employee;
import com.example.securesaving.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeServices employeeServices;
    
    @Autowired
    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping("/emp")
    public List<Employee> getEmpList() {
        return employeeServices.findAll();
    }

    @GetMapping("/emp/{id}")
    public Employee getEmpDetails(@PathVariable int id) {
        return employeeServices.findById(id);
    }

    @PostMapping("/emp")
    public Employee addEmp(@RequestBody Employee theEmployee) {
        return employeeServices.save(theEmployee);
    }

    @DeleteMapping("/emp/{id}")
    public void deleteEmpDetails(@PathVariable int id) {
        Employee employee = employeeServices.findById(id);
        if (employee != null)
            employeeServices.deleteById(id);
    }
}
