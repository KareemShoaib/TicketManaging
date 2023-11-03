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

public class EmployeeRegLogController {
    Main m = new Main();
    @FXML
    private Button Login;
    @FXML
    private Button Back;
    @FXML
    private Button Register;
    public void SendToELogin(ActionEvent event) throws IOException {

        m.changeScene("EmployeeLogin.fxml");

    }

    public void SendBackToMainW(ActionEvent event) throws IOException {

        m.changeScene("MainWindow.fxml");

    }

    public void SendToERegister(ActionEvent event) throws IOException {
        m.changeScene("EmployeeRegister.fxml");
    }








}



