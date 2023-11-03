package com.example.ticketmanaging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static com.example.ticketmanaging.Main.categoriesList;
import static com.example.ticketmanaging.Main.eventsList;

public class viewEventDetailsCategory implements Initializable {
    @FXML
    private TextField categoryName;
    @FXML
    private TextField eventDate;
    @FXML
    private TextField eventTime;
    @FXML
    private TextField eventName;
    @FXML
    private TextField eventLocation;
    @FXML
    private TextField eventDescription;
    @FXML
    private TextField numberOfTickets;
    @FXML
    private ComboBox eventsBox;
    @FXML
    private ComboBox categoriesBox;

    Main m=new Main();
    public void Back(ActionEvent Event) throws IOException {
        m.changeScene("EmployeeDashboard.fxml");
    }

    public void AddToDropDown(){
        for(int i = 0; i<categoriesList.size(); i++){
            categoriesBox.getItems().add(categoriesList.get(i).getName());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AddToDropDown();
    }

    public void addToDropDownEvents(){
        if(eventsBox.getItems().size()>0){
            eventsBox.getItems().clear();
        }

        try{
            for(int i=0;i<eventsList.size();i++){
                if(categoriesBox.getValue().toString().equals(eventsList.get(i).getCategoryName())){
                    eventsBox.getItems().add(eventsList.get(i).getName());
                }
            }
        }catch (NullPointerException e){

        }

        categoryName.clear();
        eventName.clear();
        eventTime.clear();
        eventDate.clear();
        eventLocation.clear();
        eventDescription.clear();
        numberOfTickets.clear();
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

    public void viewEventDetails(ActionEvent event) throws IOException{
        String eventNameBox=(String) eventsBox.getValue();
        String categoryNameBox=(String) categoriesBox.getValue();

        Event current=findEvent(categoryNameBox,eventNameBox);
        if(current!=null){
            int index=eventsList.indexOf(current);
            String number=Integer.toString(eventsList.get(index).getNumberOfAvailableTickets());

            LocalDate date = eventsList.get(index).getDate();
            String formattedDate = date. format(DateTimeFormatter. ofPattern("dd-MMM-yy"));

            categoryName.setText(eventsList.get(index).getCategoryName());
            eventName.setText(eventsList.get(index).getName());
            eventTime.setText(eventsList.get(index).getTime());
            eventDate.setText(formattedDate);
            eventLocation.setText(eventsList.get(index).getLocation());
            eventDescription.setText(eventsList.get(index).getDescription());
            numberOfTickets.setText(number);


        }

    }

}
