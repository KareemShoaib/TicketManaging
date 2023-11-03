package com.example.ticketmanaging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ticketmanaging.Main.clientsList;
public class RemoveClientController implements Initializable {
    Main m = new Main();
    @FXML
    private ComboBox ClientBox;
    @FXML
    private Label VERIFY;


    public void AddToDropDown(){
        for(int i = 0; i< clientsList.size(); i++){
            ClientBox.getItems().add(clientsList.get(i).getUsername());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AddToDropDown();
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

    public void removeClient(ActionEvent Event) throws IOException{
        String clientName=(String)ClientBox.getValue();
        Client current=findClient(clientName);
        if(current!=null){
            clientsList.remove(current);
            VERIFY.setText(clientName + " client removed");
        }
        else{
            VERIFY.setText("Client doesn't exist");
        }

        ClientBox.getSelectionModel().clearSelection();
        ClientBox.getItems().clear();
        for(int i = 0; i< clientsList.size(); i++){
            ClientBox.getItems().add(clientsList.get(i).getUsername());
        }
    }

    public void BACK(ActionEvent event) throws IOException {
        m.changeScene("EmployeeDashboard.fxml");
    }
}




