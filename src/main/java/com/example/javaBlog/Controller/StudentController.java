package com.example.javaBlog.Controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaBlog.Model.Students;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    private List<Students> students = new ArrayList<>(List.of(
        new Students(1L, "John", 90),
        new Students(2L, "Jane", 80),
        new Students(3L, "Doe", 70),
        new Students(4L, "Smith", 60),
        new Students(5L, "Alex", 50),
        new Students(6L, "Sam", 40),
        new Students(7L, "Tom", 30),
        new Students(8L, "Jerry", 20),
        new Students(9L, "Harry", 10),
        new Students(10L, "Potter", 0)
    ));
    
    @GetMapping("/students")
    public List<Students> getStudents(){
        return students;
    }
    
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Students addStudent(@RequestBody Students student){
        students.add(student);
        return student;
    }

}
