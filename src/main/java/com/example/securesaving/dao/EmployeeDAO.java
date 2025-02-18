package com.example.securesaving.dao;

import com.example.securesaving.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
