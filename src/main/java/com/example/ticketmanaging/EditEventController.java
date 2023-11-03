package com.example.ticketmanaging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.example.ticketmanaging.Main.categoriesList;
import static com.example.ticketmanaging.Main.eventsList;

public class EditEventController implements Initializable {
    @FXML
    private ComboBox categoriesBox;
    @FXML
    private ComboBox eventsBox;
    @FXML
    private Label verification;
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
    private DatePicker eventDate;
    @FXML
    private ComboBox categoriesNew;


    Main m=new Main();
    public void Back(ActionEvent Event) throws IOException {
        m.changeScene("AdminDashboard.fxml");
    }

    public void AddToDropDown(){
        for(int i = 0; i<categoriesList.size(); i++){
            categoriesBox.getItems().add(categoriesList.get(i).getName());
        }

        for(int i = 0; i<categoriesList.size(); i++){
            categoriesNew.getItems().add(categoriesList.get(i).getName());
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
            verification.setText("Event modified");
        }


    }

    public void keyPressed(KeyEvent ke) {
        String value = numberOfTickets.getText();
        try{
            Integer.parseInt(ke.getText());
            numberOfTickets.setEditable(true);
        }catch(Exception e){
            numberOfTickets.setEditable(false);
        }
        if(!ke.getText().isEmpty()){
            try {
                Integer.parseInt(ke.getText());
            } catch (Exception e) {
                if (!value.isEmpty()) {
                    numberOfTickets.setEditable(false);
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



    public void addFields(ActionEvent Event) throws IOException{
        String eventNameBox=(String) eventsBox.getValue();
        String categoryName=(String) categoriesBox.getValue();


        Event current=findEvent(categoryName,eventNameBox);
        if(current!=null){
            int index=eventsList.indexOf(current);

            categoriesNew.setDisable(false);
            categoriesNew.getSelectionModel().select(eventsList.get(index).getCategoryName());

            eventName.setDisable(false);
            eventName.setText(eventsList.get(index).getName());

            eventDate.setDisable(false);
            LocalDate date = eventsList.get(index).getDate();
            eventDate.setValue(date);

            eventTime.setDisable(false);
            eventTime.getSelectionModel().select(eventsList.get(index).getTime());

            eventLocation.setDisable(false);
            eventLocation.setText(eventsList.get(index).getLocation());

            eventDescription.setDisable(false);
            eventDescription.setText(eventsList.get(index).getDescription());

            numberOfTickets.setDisable(false);
            String number=Integer.toString(eventsList.get(index).getNumberOfAvailableTickets());
            numberOfTickets.setText(number);

            verification.setText(null);
        }

    }

    public void editEvent(ActionEvent Event) throws IOException{
        String categoryName=(String)categoriesBox.getValue();
        String time=(String)eventTime.getValue();
        String eventNameBox=(String) eventsBox.getValue();


        Event current=findEvent(categoryName,eventNameBox);
        int index=eventsList.indexOf(current);

        if(eventName.getText().isEmpty() || eventDescription.getText().isEmpty() || eventLocation.getText().isEmpty()
                || categoryName.isEmpty() || time.isEmpty() || numberOfTickets.getText().isEmpty())   {
            verification.setText("Please enter data");
        }
        else{
            int numberInInt=Integer.parseInt(numberOfTickets.getText());
            String categoryNewName=(String) categoriesNew.getValue();

            eventsList.get(index).setCategoryName(categoryNewName);
            eventsList.get(index).setName(eventName.getText());
            eventsList.get(index).setDate(eventDate.getValue());
            eventsList.get(index).setTime(eventTime.getValue().toString());
            eventsList.get(index).setLocation(eventLocation.getText());
            eventsList.get(index).setDescription(eventDescription.getText());
            eventsList.get(index).setNumberOfAvailableTickets(numberInInt);

            verification.setText("Event modified");

            categoriesBox.getSelectionModel().clearSelection();
            eventsBox.getSelectionModel().clearSelection();

        }

    }

//    private boolean checkEventUnchanged(){
//        String eventNameBox=(String) eventsBox.getValue();
//        String categoryName=(String) categoriesBox.getValue();
//        Event current=findEvent(categoryName,eventNameBox);
//        int index=eventsList.indexOf(current);
//
//        Event x=eventsList.get(index);
//        if(x.getCategoryName().equals(x.getCategoryName()) && x.getName().equals(x.getName()) &&
//                x.getDate().equals(x.getDate()) && x.getTime().equals(x.getTime()) && x.getDescription().equals(x.getDescription())){
//            return true;
//        }
//        return false;
//    }

//    private boolean checkEventName(){
//        String eventNameBox=(String) eventsBox.getValue();
//        String categoryName=(String) categoriesBox.getValue();
//        Event current=findEvent(categoryName,eventNameBox);
//        int index=eventsList.indexOf(current);
//
//        Event x=eventsList.get(index);
//        for(int i=0;i<eventsList.size();i++){
//            if(x.getName().equals(eventsList.get(i).getName())){
//                return true;
//            }
//        }
//        return false;
//    }

}
