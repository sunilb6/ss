package com.example.securesaving.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int user_id;
    private String dept;

    public Department() {
    }

    public Department(long id, int user_id, String dept) {
        this.id = id;
        this.user_id = user_id;
        this.dept = dept;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Employee employee;
}
