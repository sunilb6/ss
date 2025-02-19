package com.example.securesaving.dao;

import com.example.securesaving.entity.Department;
import com.example.securesaving.entity.Employee;

public interface AppDao {
    void save(Employee employee);
    Employee findById(long id);
    Department findByDeptId(long id);
}
