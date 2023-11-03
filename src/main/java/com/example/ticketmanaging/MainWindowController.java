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
public class MainWindowController {
    Main m = new Main();


    public MainWindowController() {

    }

    @FXML
    private Button ADMIN;
    @FXML
    private Button EMPLOYEE;
    @FXML
    private Button Close;

    public void SendToALogin(ActionEvent event) throws IOException {

        m.changeScene("AdminLogin.fxml");

    }

    public void CloseApp(ActionEvent event) throws IOException {

        System.exit(0);
    }

    public void SendToELogin(ActionEvent event) throws IOException {

        m.changeScene("EmployeeRegLog.fxml");
    }
}


