package com.example.securesaving.dao;

import com.example.securesaving.entity.Course;
import com.example.securesaving.entity.Department;
import com.example.securesaving.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao {

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee findById(long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Department findByDeptId(long id) {
        return entityManager.find(Department.class, id);
    }

    @Override
    public List<Course> findCoursesByEmployeeId(long theId) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where employee.id = :data", Course.class);
        query.setParameter("data", theId);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Employee findEmployeeByIdJoinFetch(long id) {
        /**
         * JOIN FETCH (even when the Employee has @OneToMany(fetchType=LAZY), this will retrieve Employee and Course, it is similar to EAGER loading
         */
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e " +
                "JOIN FETCH e.courses " +
                "JOIN FETCH e.department " +
                "where e.id=:data", Employee.class);
        query.setParameter("data", id);
        Employee courses = query.getSingleResult();
        return courses;
    }

    @Override
    @Transactional
    public void update(Employee e) {
        entityManager.merge(e);
    }

    @Override
    @Transactional
    public void updateCourse(Course c) {
        entityManager.merge(c);
    }
}
