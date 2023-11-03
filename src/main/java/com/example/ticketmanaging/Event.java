package com.example.ticketmanaging;

import java.time.LocalDate;

public class Event {
    private String categoryName;
    private String name;
    private LocalDate date;
    private String time;
    private String location;
    private String description;
    private int numberOfAvailableTickets;


    public Event(String categoryName, String name, LocalDate date, String time, String location, String description,
                 int numberOfAvailableTickets) {
        this.categoryName = categoryName;
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.numberOfAvailableTickets = numberOfAvailableTickets;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfAvailableTickets() {
        return numberOfAvailableTickets;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getName() {
        return name;
    }


    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }


    public void setNumberOfAvailableTickets(int numberOfAvailableTickets) {
        this.numberOfAvailableTickets = numberOfAvailableTickets;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public void setDescription(String description) {
        this.description = description;
    }

}
