package com.example.ticketmanaging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ticketmanaging.Main.categoriesList;
import static com.example.ticketmanaging.Main.eventsList;

public class retrieveEventController implements Initializable {
    @FXML
    private TextArea eventsSecondView;
    @FXML
    private ComboBox categoriesBox;
    Main m=new Main();
    public void Back(ActionEvent Event) throws IOException {
        m.changeScene("EmployeeDashboard.fxml");
    }

    public void AddToDropDown(){
        for(int i = 0; i<categoriesList.size(); i++) {
            categoriesBox.getItems().add(categoriesList.get(i).getName());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AddToDropDown();
    }

    public void showEvents(ActionEvent Event) throws IOException{
        if(eventsSecondView.getPrefRowCount()>0){
            eventsSecondView.clear();
        }

        String currentCategory=(String) categoriesBox.getValue();
        int m=1;
        for(int i=0;i<eventsList.size();i++) {
            if (currentCategory.equals(eventsList.get(i).getCategoryName())) {
                eventsSecondView.appendText(m + " - " + eventsList.get(i).getName());
                eventsSecondView.appendText("\n");
                m++;
            }
        }
    }
}
