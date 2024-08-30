package com.example.demo.DataTransferObject;

import java.sql.Timestamp;
import java.util.List;

public class CourseDTO {
    private int id;
    private String name, description, level;
    private int duration;
    private Timestamp startTime, endTime;
    private String dayOfTheWeek, room;
    private int capacity;
    private List<CoachDTO> coaches;

    public CourseDTO() {
    }

    public CourseDTO(int id, String name, String description, String level, int duration, Timestamp startTime,
                     Timestamp endTime, String dayOfTheWeek, String room, int capacity, List<CoachDTO> coaches) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.level = level;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfTheWeek = dayOfTheWeek;
        this.room = room;
        this.capacity = capacity;
        this.coaches = coaches;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<CoachDTO> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<CoachDTO> coaches) {
        this.coaches = coaches;
    }
}
