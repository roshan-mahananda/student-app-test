package com.example.studentAppTest.Controller;

import com.example.studentAppTest.Model.Student;
import com.example.studentAppTest.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping
    public List<Student> getStudents(){
        return repo.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return repo.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails){
        Student student = repo.findById(id).orElseThrow(()->new RuntimeException("Student Not Found"));

        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());

        return repo.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        repo.deleteById(id);
    }
}
