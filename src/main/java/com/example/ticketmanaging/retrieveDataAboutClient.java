package com.example.ticketmanaging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ticketmanaging.Main.*;

public class retrieveDataAboutClient implements Initializable {
    @FXML
    private TextField dataField;
    @FXML
    private Label fieldLabel;
    @FXML
    private ComboBox field;
    @FXML
    private Label choiceLabel;
    @FXML
    private ComboBox choice;
    @FXML
    private ComboBox nameOrSerialNumber;

    Main m=new Main();
    public void Back(ActionEvent Event) throws IOException {
        m.changeScene("EmployeeDashboard.fxml");
    }

    public void AddToDropDown(){
        nameOrSerialNumber.getItems().addAll("Name","Serial number");
        field.getItems().addAll("National ID","Gender","Mobile number");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AddToDropDown();
    }

    public void setChoice(ActionEvent event) throws IOException{
        String nameOrSerialNumberBox=(String) nameOrSerialNumber.getValue();

        if(nameOrSerialNumberBox=="Name"){
            choice.getItems().clear();
            field.setVisible(false);
            dataField.setVisible(false);
            fieldLabel.setText(null);
            choiceLabel.setText("Choose name:");
            choice.setVisible(true);
            choice.setPromptText("Choose name");
            for(int i=0;i<clientsList.size();i++){
                choice.getItems().add(clientsList.get(i).getUsername());
            }
        }
        else if(nameOrSerialNumberBox=="Serial number"){
            choice.getItems().clear();
            field.setVisible(false);
            dataField.setVisible(false);
            fieldLabel.setText(null);
            choiceLabel.setText("Choose serial number:");
            choice.setVisible(true);
            choice.setPromptText("Choose serial number");
            for(int i=0;i<clientsList.size();i++){
                choice.getItems().add(clientsList.get(i).getID());
            }
        }
    }

    public void setField(ActionEvent event) throws IOException{
        fieldLabel.setText("Choose field:");
        field.setVisible(true);
        field.setPromptText("Choose a field");
    }

    private Client findClient ( String username ) {
        for(int i = 0; i< clientsList.size(); i++) {
            Client current= clientsList.get(i);
            if(current.getUsername().equals(username)) {
                return current;
            }
        }
        return null;
    }

    private Client findClientSerial (String serialNumber) {
        for(int i = 0; i< clientsList.size(); i++) {
            Client current= clientsList.get(i);
            if(current.getID().equals(serialNumber)) {
                return current;
            }
        }
        return null;
    }

    public void getData(ActionEvent event) throws IOException{
        String fieldAcquired=(String) field.getValue();
        String choiceAcquired=(String) choice.getValue();

        dataField.setVisible(true);

        if(nameOrSerialNumber.getValue().toString()=="Name"){
            Client current=findClient(choiceAcquired);
            int index=clientsList.indexOf(current);
            if(fieldAcquired=="National ID"){
                dataField.setText(clientsList.get(index).getNationalID());
            }
            else if(fieldAcquired=="Gender"){
                dataField.setText(clientsList.get(index).getGender());
            }
            else if(fieldAcquired=="Mobile number"){
                dataField.setText(clientsList.get(index).getMobileNumber());
            }
        }
        else if(nameOrSerialNumber.getValue().toString()=="Serial number"){
            Client current=findClientSerial(choiceAcquired);
            int index=clientsList.indexOf(current);
            if(fieldAcquired=="National ID"){
                dataField.setText(clientsList.get(index).getNationalID());
            }
            else if(fieldAcquired=="Gender"){
                dataField.setText(clientsList.get(index).getGender());
            }
            else if(fieldAcquired=="Mobile number"){
                dataField.setText(clientsList.get(index).getMobileNumber());
            }
        }

    }

}
