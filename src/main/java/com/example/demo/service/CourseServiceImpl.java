package com.example.demo.service;

import com.example.demo.DataTransferObject.CoachDTO;
import com.example.demo.DataTransferObject.CourseDTO;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    public CourseRepository courseRepository;

    @Override
    public Course saveOrUpdateCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(this::convertCourseToDTO)
                .collect(Collectors.toList());
    }

    private CourseDTO convertCourseToDTO(Course course) {
        List<CoachDTO> coachDTOs = course.getCoaches().stream()
                .map(coach -> new CoachDTO(coach.getId(), coach.getFirstname(), coach.getLastname(), coach.getEmail(),
                        coach.getPhone_number(), coach.getGender(), coach.getBirthdate(), coach.getHireDate(),
                        coach.getSalary(), coach.getSpecialty(), Collections.emptyList()))
                .collect(Collectors.toList());

        return new CourseDTO(course.getId(), course.getName(), course.getDescription(), course.getLevel(),
                course.getDuration(), course.getStartTime(), course.getEndTime(), course.getDayOfTheWeek(),
                course.getRoom(), course.getCapacity(), coachDTOs);
    }

    @Override
    public void deleteCourse(int courseId) {
        courseRepository.deleteById(courseId);
    }
}
