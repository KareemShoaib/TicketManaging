package com.example.ticketmanaging;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import static com.example.ticketmanaging.Main.*;

import java.io.IOException;

public class AdminLoginController {
    public AdminLoginController() {
    }
    Main m = new Main();

    @FXML
    private Button Login;
    @FXML
    private Button Cancel;
    @FXML
    private Label Error;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void SendToAdminPage (ActionEvent event) throws IOException {
        for (int i = 0; i<adminsList.size();i++){
            adminsList.get(i).login(username.getText().toString(), password.getText().toString());
            if(adminsList.get(i).isLoggedIn()){
                isLoggedInFlag = true;
                isLoggedInIndex = i;
                break;
            }
        }
        if(isLoggedInFlag){
            m.changeScene("AdminDashboard.fxml");
        }
        else if (username.getText().isEmpty() || password.getText().isEmpty()) {
            Error.setText("Please enter your data.");
        }
        else {
            Error.setText("Wrong username or password!");
        }
    }
    public void SendBackToM (ActionEvent event) throws IOException {
        m.changeScene("MainWindow.fxml");
    }





}