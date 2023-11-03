package com.example.ticketmanaging;

public class Client {
    private String username;

    private String nationalID;

    private String gender;

    private String mobileNumber;

    private String ID;

    private String previousEvents;

    private String upcoming;

    public Client(String username, String nationalID, String gender, String mobileNumber, String serialNumber, String previousEvents, String upcoming) {
        this.username = username;
        this.nationalID = nationalID;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.ID = serialNumber;
        this.previousEvents = previousEvents;
        this.upcoming = upcoming;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPreviousEvents() {
        return previousEvents;
    }

    public void setPreviousEvents(String previousEvents) {
        this.previousEvents = previousEvents;
    }

    public String getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(String upcoming) {
        this.upcoming = upcoming;
    }
}
