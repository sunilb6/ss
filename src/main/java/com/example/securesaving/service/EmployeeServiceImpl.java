package com.example.securesaving.service;

import com.example.securesaving.entity.Employee;
import com.example.securesaving.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Purpose
 * Service Facade design pattern
 * Intermediate layer for custom business logic
 * Integrated date from multiple sources (DAO/repository)
 * 
 * EmpController--->EmpService---->1.EmpDAO, SkillsDAO, PayrollDAO---->Database
 */
//This annotation used to indicate that a class is a Service component, it will register
//as Spring Bean in the application Context
@Service
public class EmployeeServiceImpl implements EmployeeServices {

    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(long theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        return result.orElse(null);
    }

    //We can remove transactional if we are using JpaRepository for DAO use this
    //@Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    //@Transactional
    @Override
    public void deleteById(long theId) {
        employeeRepository.deleteById(theId);
    }
}
