package com.example.demo.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Student,Integer> {
    List<Student> findBySid(int sid);
    List<Student> findByNameAndSid(String name, int sid);
}
