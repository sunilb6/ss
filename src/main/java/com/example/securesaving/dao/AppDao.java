package com.example.securesaving.dao;

import com.example.securesaving.entity.Course;
import com.example.securesaving.entity.Department;
import com.example.securesaving.entity.Employee;

import java.util.List;

public interface AppDao {
    void save(Employee employee);
    Employee findById(long id);
    Department findByDeptId(long id);
    List<Course> findCoursesByEmployeeId(long id);
    Employee findEmployeeByIdJoinFetch(long id);
    void update(Employee e);
    void updateCourse(Course c);
}
