package com.example.demo.service;

import com.example.demo.DataTransferObject.CoachDTO;
import com.example.demo.model.Coach;

import java.util.List;

public interface CoachService {
    public Coach saveOrUpdateCoach(Coach coach);

    public List<CoachDTO> getAllCoaches();

    public void deleteCoach(int coachId);

}
