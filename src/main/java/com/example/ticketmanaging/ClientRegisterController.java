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

public class ClientRegisterController implements Initializable {
    @FXML
    protected ComboBox Gender;
    @FXML
    private TextField serialNumber ;
    @FXML
    private TextField mobileNumber;
    @FXML
    private TextField nationalID;
    @FXML
    private TextField previousEvents;
    @FXML
    private TextField username;
    @FXML
    private Label verify;
    @FXML
    private Button BACK;
    @FXML
    private ComboBox upcomingEvents;

    private static int Serial = 1 ;

    private Client findClient ( String username ) {
        for(int i = 0; i< clientsList.size(); i++) {
            Client current= clientsList.get(i);
            if(current.getUsername().equals(username)) {
                return current;
            }
        }
        return null;
    }

    public void AddToDropDown() {
        Gender.getItems().addAll("Male", "Female", "Prefer Not To Say");

        for(int i=0;i<eventsList.size();i++){
            upcomingEvents.getItems().add(eventsList.get(i).getName());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AddToDropDown();
        serialNumber.setEditable(false);
        serialNumber.setText(String.valueOf(Serial));
    }

    public void addClient(ActionEvent Event) throws IOException {
        String genderValue = (String) Gender.getValue();
        String upcomingEvent = (String) upcomingEvents.getValue();

        if (mobileNumber.getLength()>10) {
            mobileNumber.setEditable(false);
        }
        if (mobileNumber.getText().isEmpty() || serialNumber.getText().isEmpty() || nationalID.getText().isEmpty()
                || previousEvents.getText().isEmpty() || username.getText().isEmpty()) {
            verify.setText("Please enter data");
        }
        else if(findClient(username.getText())==null){
            serialNumber.setText(String.valueOf(Serial));
            clientsList.add(new Client(username.getText(), nationalID.getText(),genderValue,mobileNumber.getText(),serialNumber.getText(),previousEvents.getText(),upcomingEvent));
            verify.setText("Client Registered");
            Serial++;
        }
        else {
            verify.setText(username.getText().toString() + " Client Already Exists");
        }

        mobileNumber.clear();
        Gender.getSelectionModel().clearSelection();
        previousEvents.clear();
        username.clear();
        nationalID.clear();
        upcomingEvents.getSelectionModel().clearSelection();
    }
    public void Limiter(KeyEvent ke){
    String value = mobileNumber.getText();
        try{
        Integer.parseInt(ke.getText());
        mobileNumber.setEditable(true);
    }catch(Exception e){
        mobileNumber.setEditable(false);
        verify.setText("Numbers allowed only in this field");
    }
        if(!ke.getText().isEmpty()){
        try {
            Integer.parseInt(ke.getText());
        } catch (Exception e) {
            if (!value.isEmpty()) {
                mobileNumber.setEditable(false);
                verify.setText("Numbers allowed only in this field");
            }
        }
    }else{
        mobileNumber.setEditable(true);
    }

        if(mobileNumber.getText().length()>10){
            mobileNumber.setEditable(false);
            verify.setText("Maximum Numbers in MobileNumber Reached");
        }

        if(ke.getText().isEmpty()){
            mobileNumber.setEditable(true);
        }
    }

    public void KEY2(KeyEvent ke){
        String value = serialNumber.getText();
        try{
            Integer.parseInt(ke.getText());
            serialNumber.setEditable(true);
        }catch(Exception e){
            serialNumber.setEditable(false);
        }
        if(!ke.getText().isEmpty()){
            try {
                Integer.parseInt(ke.getText());
            } catch (Exception e) {
                if (!value.isEmpty()) {
                    serialNumber.setEditable(false);
                }
            }
        }else{
            serialNumber.setEditable(true);
        }
    }
    public void KEY3(KeyEvent ke){
        String value = nationalID.getText();
        try{
            Integer.parseInt(ke.getText());
            nationalID.setEditable(true);
        }catch(Exception e){
            nationalID.setEditable(false);
            verify.setText("Numbers allowed only in this field");
        }
        if(!ke.getText().isEmpty()){
            try {
                Integer.parseInt(ke.getText());
            } catch (Exception e) {
                if (!value.isEmpty()) {
                    nationalID.setEditable(false);
                    verify.setText("Numbers allowed only in this field");
                }
            }
        }else{
            nationalID.setEditable(true);
        }
    }
    Main m = new Main ();
    public void BACK(ActionEvent Event) throws IOException {
     m.changeScene("EmployeeDashboard.fxml");
    }
    }

