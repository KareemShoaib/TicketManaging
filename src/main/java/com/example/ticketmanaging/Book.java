package com.example.ticketmanaging;

public class Book {
    private String userName;
    private String categoryName;
    private String eventName;


    public Book(String clientName, String categoryName, String eventName) {
        this.userName = clientName;
        this.categoryName = categoryName;
        this.eventName = eventName;
    }


    public String getUserName() {
        return userName;
    }


    public String getCategoryName() {
        return categoryName;
    }


    public String getEventName() {
        return eventName;
    }




}
