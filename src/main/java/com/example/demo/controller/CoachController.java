package com.example.demo.controller;

import com.example.demo.DataTransferObject.CoachDTO;
import com.example.demo.model.Coach;
import com.example.demo.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {
    @Autowired
    public CoachService coachService;

    @PostMapping("/add")
    public ResponseEntity<Coach> add(@RequestBody Coach coach) {
        Coach newCoach = coachService.saveOrUpdateCoach(coach);
        return new ResponseEntity<>(newCoach, HttpStatus.CREATED);
    }

    //we use post method
    @PostMapping("/getAll")
    public List<CoachDTO> getAllCoaches() {
        return coachService.getAllCoaches();
    }

    //we use delete method
    @DeleteMapping("/delete/{coachId}")
    public String deleteCoach(@PathVariable int coachId) {
        coachService.deleteCoach(coachId);
        return "Coach deleted successfully";
    }

    //we use put method
    @PutMapping("/update/{coachId}")
    public Coach updateCoach(@PathVariable int coachId, @RequestBody Coach coach) {
        coach.setId(coachId);
        return coachService.saveOrUpdateCoach(coach);
    }

}
