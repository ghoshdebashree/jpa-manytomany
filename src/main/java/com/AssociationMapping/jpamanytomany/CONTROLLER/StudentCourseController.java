package com.AssociationMapping.jpamanytomany.CONTROLLER;

import com.AssociationMapping.jpamanytomany.ENTITY.Course;
import com.AssociationMapping.jpamanytomany.ENTITY.Student;
import com.AssociationMapping.jpamanytomany.REPOSITORY.CourseRepository;
import com.AssociationMapping.jpamanytomany.REPOSITORY.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/course")
public class StudentCourseController {

    private StudentRepository studentRepository;   // WITHOUT AUTOWIRING, USING CONSTRUCTOR
    private CourseRepository courseRepository;

    public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }
    @PostMapping
    public Student saveStudentDetailsWithCourse(@RequestBody Student student){
        return studentRepository.save(student);
    }
    @GetMapping
    public List<Student> findAAllStudents(){
        return studentRepository.findAll();
    }
    @GetMapping("/{studentId}")
    public Student findStudents(@PathVariable Long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }
    @GetMapping("/find/{name}")
    public List<Student> findStudentsByName(@PathVariable String name){
        return studentRepository.findByNameContaining(name);
    }
    @GetMapping("/Search/{price}")
    public List<Course> findCourseLessThanPriceProvided(@PathVariable double price){
        return courseRepository.findByFeeLessThan(price);
    }
}
