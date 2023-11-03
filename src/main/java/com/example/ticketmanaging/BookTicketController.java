package com.example.ticketmanaging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ticketmanaging.Main.*;

public class BookTicketController implements Initializable {
    @FXML
    private Label verification;
    @FXML
    private ComboBox clientsBox;
    @FXML
    private ComboBox eventsBox;
    @FXML
    private ComboBox categoriesBox;
    Main m = new Main();

    public void BACK(ActionEvent Event) throws IOException {
        m.changeScene("EmployeeDashboard.fxml");
    }


    public void AddToDropDown() {
        for (int i = 0; i < categoriesList.size(); i++) {
            categoriesBox.getItems().add(categoriesList.get(i).getName());
        }

        for (int i = 0; i < clientsList.size(); i++) {
            clientsBox.getItems().add(clientsList.get(i).getUsername());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AddToDropDown();
    }

    public void addToDropDownEvents() {
        if (eventsBox.getItems().size() > 0) {
            eventsBox.getItems().clear();
        }

        try{
            for (int i = 0; i < eventsList.size(); i++) {
                if (categoriesBox.getValue().toString().equals(eventsList.get(i).getCategoryName())) {
                    eventsBox.getItems().add(eventsList.get(i).getName());
                }

            }
        }catch (NullPointerException e){
            String currentClient=(String) clientsBox.getValue();
            String currentCategory=(String) categoriesBox.getValue();
            String currentEvent=(String) eventsBox.getValue();
            int result=findBookedEvent(currentClient,currentCategory,currentEvent);

            if(result==1){
                verification.setText("Event booked successfully");
            }
            else if(result==0){
                verification.setText("Booking for this event already exists");
            }
            else if(result==4){
                verification.setText("No available tickets");
            }
        }

    }




    public Client FindClientName(String name) {
        for(int i=0;i<clientsList.size();i++) {
            Client current=clientsList.get(i);
            if(current.getUsername().equals(name)) {
                return current;
            }
        }
        return null;
    }
    private Event findEvent(String categoryName,String name) {
        for(int i=0;i<eventsList.size();i++) {
            Event current=eventsList.get(i);
            if(current.getName().equals(name) && current.getCategoryName().equals(categoryName)) {
                return current;
            }
        }
        return null;
    }

    private Category findCategory(String name) {
        for(int i=0;i<categoriesList.size();i++) {
            Category current=categoriesList.get(i);
            if(current.getName().equals(name)) {
                return current;
            }
        }
        return null;
    }

    private int findBookedEvent(String clientName, String categoryName, String eventName) {
        Client currentName=FindClientName(clientName);
        Event currentEvent=findEvent(categoryName,eventName);
        Category currentCategory=findCategory(categoryName);

        try{
            if(currentName.equals(null) || currentEvent.equals(null) || currentCategory.equals(null)){
                verification.setText("Please choose a client");
            }
        }catch (Exception e){
            verification.setText("Please choose a client");
        }


        if(currentName!=null && currentEvent!=null) {
            for(int i=0;i<bookingsList.size();i++) {
                Book current=bookingsList.get(i);
                if(current.getUserName().equals(clientName) && current.getEventName().equals(eventName) &&
                        current.getCategoryName().equals(categoryName) ) {
                    return 0;
                }
            }
            if(currentEvent.getNumberOfAvailableTickets() <= 0) {
                return 4;
            }
            return 1;
        }
        return 2;
    }

    public void bookTicket(ActionEvent Event) throws IOException{
        String currentClient=(String) clientsBox.getValue();
        String currentCategory=(String) categoriesBox.getValue();
        String currentEvent=(String) eventsBox.getValue();

        Event current=findEvent(currentCategory,currentEvent);

        try{
            if(currentEvent.equals(null) || currentCategory.equals(null)){
                verification.setText("Please choose a client");
            }
        }catch (Exception e){
            verification.setText("Please choose a client");
        }

        int result=findBookedEvent(currentClient,currentCategory,currentEvent);
        if(result==1){
            int index=eventsList.indexOf(current);
            int newNumberOfTickets=eventsList.get(index).getNumberOfAvailableTickets();
            bookingsList.add(new Book(currentClient,currentCategory,currentEvent));
            newNumberOfTickets=newNumberOfTickets-1;
            eventsList.get(index).setNumberOfAvailableTickets(newNumberOfTickets);
            verification.setText("Event booked successfully");
        }
        else if(result==0){
            verification.setText("Booking for this event already exists");
        }
        else if(result==4){
            verification.setText("No available tickets");
        }

        clientsBox.getSelectionModel().clearSelection();
        categoriesBox.getSelectionModel().clearSelection();
        eventsBox.getSelectionModel().clearSelection();
    }
}
