package com.example.demo.service;

import com.example.demo.DataTransferObject.CourseDTO;
import com.example.demo.model.Course;

import java.util.List;

public interface CourseService {
    public Course saveOrUpdateCourse(Course course);

    public List<CourseDTO> getAllCourses();

    public void deleteCourse(int courseId);
}
