package com.example.ticketmanaging;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;

import static com.example.ticketmanaging.Main.*;

public class UnbookTicketController implements Initializable {
    Main m = new Main();
    @FXML
    private ComboBox clientsBox;
    @FXML
    private ComboBox eventsBox;
    @FXML
    private Label VERIFY;

    @FXML
    void BACK(ActionEvent event) throws IOException {
        m.changeScene("EmployeeDashboard.fxml");
    }

    public void AddToDropDown() {
        for (int i = 0; i < clientsList.size(); i++) {
            clientsBox.getItems().add(clientsList.get(i).getUsername());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AddToDropDown();
    }


    public void AddToDropDownEVENTS() {
        if (eventsBox.getItems().size() > 0) {
            eventsBox.getItems().clear();
        }

        try{
            for (int i = 0; i < bookingsList.size()    ; i++) {
                if (clientsBox.getValue().toString().equals(bookingsList.get(i).getUserName())) {
                    eventsBox.getItems().add(bookingsList.get(i).getEventName());
                }
            }
        }catch(NullPointerException e){

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

    private Event findEventOnly(String name) {
        for(int i=0;i<eventsList.size();i++) {
            Event current=eventsList.get(i);
            if(current.getName().equals(name)) {
                return current;
            }
        }
        return null;
    }

    private Book findBookedEvent(String clientName, String eventName) {
        Client currentName=FindClientName(clientName);
        int index=eventsList.indexOf(eventName);
        Event currentEvent=findEventOnly(eventName);


        if(currentName!=null && currentEvent!=null) {
            for (int i = 0; i < bookingsList.size(); i++) {
                Book current = bookingsList.get(i);
                if (current.getUserName().equals(clientName) && current.getEventName().equals(eventName)) {
                    return current;
                }
            }
        }
        return null;
    }


    public void UnbookTicket(ActionEvent event) throws IOException {
        String clientNameBox=(String) clientsBox.getValue();
        String eventNameBox=(String) eventsBox.getValue();

        Book current=findBookedEvent(clientNameBox,eventNameBox);
        try{
            if(clientNameBox.equals(null) || eventNameBox.equals(null)){
                VERIFY.setText("Please enter data");
            }
        }catch (Exception e){
            VERIFY.setText("Please enter data");
        }

        if(clientNameBox!=null && eventNameBox!=null){
            bookingsList.remove(current);
            VERIFY.setText("Event removed successfully");
        }

        eventsBox.getSelectionModel().clearSelection();
        clientsBox.getSelectionModel().clearSelection();

    }
}










