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
import javafx.scene.control.TextField;

import static com.example.ticketmanaging.Main.*;
public class SearchEventController {

Main m = new Main();

        @FXML
        private Label label;

        @FXML
        private Button search;

        @FXML
        private TextField eventname;

        @FXML
        public void BACK(ActionEvent event) throws IOException {
        m.changeScene("EmployeeDashboard.fxml");
        }

        @FXML
        void searchClient(ActionEvent event) throws IOException {
            if (eventname.getText().isEmpty()) {
                label.setText("Please enter Data");
            } else {
                for (int i = 0; i < eventsList.size(); i++) {
                    if (eventname.getText().equals(eventsList.get(i).getName())) {
                        label.setText(eventsList.get(i).getName() + " Event Exists ");
                        break;
                    } else
                        label.setText(eventname.getText() + " Event Does Not Exist ");
                }
            }
        }

    }





