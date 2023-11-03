package com.example.ticketmanaging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ticketmanaging.Main.categoriesList;

public class RemoveCategoryController implements Initializable {
    @FXML
    private Button Back;
    @FXML
    private ComboBox categoriesBox;
    @FXML
    private Button button;
    @FXML
    private Label verification;

    Main m=new Main();
    public void Back(ActionEvent Event) throws IOException {
        m.changeScene("AdminDashboard.fxml");
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

    private Category findCategory(String name) {
        for(int i=0;i<categoriesList.size();i++) {
            Category current=categoriesList.get(i);
            if(current.getName().equals(name)) {
                return current;
            }
        }
        return null;
    }

    public void removeCategory(ActionEvent Event) throws IOException{
        String currentCategory=(String) categoriesBox.getValue();
        Category current=findCategory(currentCategory);
        if(currentCategory.isEmpty()){
            verification.setText("Please enter a category");
        }
        else if(currentCategory!=null){
            categoriesList.remove(current);
            verification.setText(currentCategory + " Category removed");
        }

        categoriesBox.getSelectionModel().clearSelection();
        categoriesBox.getItems().clear();
        for(int i = 0; i<categoriesList.size(); i++) {
            categoriesBox.getItems().add(categoriesList.get(i).getName());
        }

    }
}
