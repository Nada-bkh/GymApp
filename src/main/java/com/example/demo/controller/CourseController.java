package com.example.demo.controller;

import com.example.demo.DataTransferObject.CourseDTO;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    public CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<Course> add(@RequestBody Course course) {
        Course newCourse = courseService.saveOrUpdateCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    //we use post method
    @PostMapping("/getAll")
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    //we use delete method
    @DeleteMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable int courseId) {
        courseService.deleteCourse(courseId);
        return "Course deleted successfully";
    }

    //we use put method
    @PutMapping("/update/{courseId}")
    public Course updateCourse(@PathVariable int courseId, @RequestBody Course course) {
        course.setId(courseId);
        return courseService.saveOrUpdateCourse(course);
    }
}
