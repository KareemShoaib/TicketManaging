package com.example.ticketmanaging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ticketmanaging.Main.*;

public class AddEventController implements Initializable {
    public AddEventController() {
    }

    @FXML
    protected ComboBox categoriesBox;
    @FXML
    private Button Add;
    @FXML
    private TextField eventName;
    @FXML
    private ComboBox eventTime;
    @FXML
    private TextField eventLocation;
    @FXML
    private TextField eventDescription;
    @FXML
    private TextField numberOfTickets;
    @FXML
    private Label verification;
    @FXML
    private DatePicker eventDate;

    Main m=new Main();
    public void Back(ActionEvent Event) throws IOException {
        m.changeScene("AdminDashboard.fxml");
    }

    public void AddToDropDown(){
        for(int i = 0; i<categoriesList.size(); i++){
            categoriesBox.getItems().add(categoriesList.get(i).getName());
        }

        eventTime.getItems().addAll("00:00","01:00","02:00","03:00","04:00","05:00",
                "06:00","07:00","08:00","09:00","10:00","11:00","12:00",
                "13:00","14:00","15:00","16:00","17:00","18:00","19:00",
                "20:00","21:00","22:00","23:00");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AddToDropDown();
    }

    public void keyPressed(KeyEvent ke) {
        String value = numberOfTickets.getText();
        try{
            Integer.parseInt(ke.getText());
            numberOfTickets.setEditable(true);
        }catch(Exception e){
            numberOfTickets.setEditable(false);
            verification.setText("Numbers allowed only in this field");
        }
        if(!ke.getText().isEmpty()){
            try {
                Integer.parseInt(ke.getText());
            } catch (Exception e) {
                if (!value.isEmpty()) {
                    numberOfTickets.setEditable(false);
                    verification.setText("Numbers allowed only in this field");
                }
            }
        }else{
            numberOfTickets.setEditable(true);
        }
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

    public void addEvent(ActionEvent Event) throws IOException{
        String categoryName=(String)categoriesBox.getValue();
        String time=(String)eventTime.getValue();




        if(eventName.getText().isEmpty() || eventDescription.getText().isEmpty() || eventLocation.getText().isEmpty()
            || categoryName.isEmpty() || time.isEmpty() || numberOfTickets.getText().isEmpty() || eventDate.getValue()==null)   {
            verification.setText("Please enter data");
        }
        else if(findEvent(categoryName,eventName.getText())==null){
            int numberInInt=Integer.parseInt(numberOfTickets.getText());
            eventsList.add(new Event(categoryName,eventName.getText(),eventDate.getValue(),time,eventLocation.getText(),eventDescription.getText(),numberInInt));
            verification.setText("Event added");
        }
        else{
            verification.setText(eventName.getText().toString()+ " event already exists");
        }

        categoriesBox.getSelectionModel().clearSelection();
        eventTime.getSelectionModel().clearSelection();
        eventName.clear();
        eventLocation.clear();
        eventDescription.clear();
        numberOfTickets.clear();
        eventDate.getEditor().clear();
    }


}

