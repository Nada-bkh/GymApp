package com.example.demo.service;

import com.example.demo.DataTransferObject.CoachDTO;
import com.example.demo.DataTransferObject.CourseDTO;
import com.example.demo.model.Coach;
import com.example.demo.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoachServiceImpl implements CoachService {
    @Autowired
    public CoachRepository coachRepository;
    @Override
    public Coach saveOrUpdateCoach(Coach coach) {
        return coachRepository.save(coach);
    }



    @Override
    public void deleteCoach(int coachId) {
        coachRepository.deleteById(coachId);
    }

    @Override
    public List<CoachDTO> getAllCoaches() {
        List<Coach> coaches = coachRepository.findAll();
        return coaches.stream()
                .map(this::convertCoachToDTO)
                .collect(Collectors.toList());
    }

    private CoachDTO convertCoachToDTO(Coach coach) {
        List<CourseDTO> courseDTOs = coach.getCourses().stream()
                .map(course -> new CourseDTO(course.getId(), course.getName(), course.getDescription(),
                        course.getLevel(), course.getDuration(), course.getStartTime(), course.getEndTime(),
                        course.getDayOfTheWeek(), course.getRoom(), course.getCapacity(), Collections.emptyList()))
                .collect(Collectors.toList());

        return new CoachDTO(coach.getId(), coach.getFirstname(), coach.getLastname(), coach.getEmail(),
                coach.getPhone_number(), coach.getGender(), coach.getBirthdate(), coach.getHireDate(), coach.getSalary(),
                coach.getSpecialty(), courseDTOs);
    }
}
