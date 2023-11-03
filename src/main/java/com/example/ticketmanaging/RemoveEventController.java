package com.example.ticketmanaging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ticketmanaging.Main.categoriesList;
import static com.example.ticketmanaging.Main.eventsList;

public class RemoveEventController implements Initializable {
    @FXML
    protected ComboBox categoriesBox;
    @FXML
    private ComboBox eventsBox;
    @FXML
    private Label verification;


    Main m=new Main();
    public void Back(ActionEvent Event) throws IOException {
        m.changeScene("AdminDashboard.fxml");
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
        if(eventsBox.getItems().size() > 0){
            eventsBox.getItems().clear();
        }

        for(int i=0;i<eventsList.size();i++){
            if(categoriesBox.getValue().toString().equals(eventsList.get(i).getCategoryName().toString())){
                eventsBox.getItems().add(eventsList.get(i).getName());
            }
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

    public void removeEvent(ActionEvent Event) throws IOException{
        String categoryName=(String)categoriesBox.getValue();
        String eventName=(String)eventsBox.getValue();
        Event current=findEvent(categoryName,eventName);
        if(current!=null){
            eventsList.remove(current);
            eventsBox.getItems().remove(eventName);
            verification.setText(eventName + " event removed");
        }
        else{
            verification.setText("Event doesn't exist");
        }

        eventsBox.getSelectionModel().clearSelection();


    }
}
