package com.example.studentAppTest.Repository;

import com.example.studentAppTest.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
