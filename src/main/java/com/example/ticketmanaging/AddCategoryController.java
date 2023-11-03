package com.example.ticketmanaging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.ticketmanaging.Main.categoriesList;

public class AddCategoryController {
    @FXML
    private Button Back;
    @FXML
    private TextField category;
    @FXML
    private Button button;
    @FXML
    private Label verification;

    Main m=new Main();
    public void Back(ActionEvent Event) throws IOException {
        m.changeScene("AdminDashboard.fxml");
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

    public void addNewCategory(ActionEvent Event) throws IOException{
        if(category.getText().isEmpty()){
            verification.setText("Please enter a category");
        }
        else if(findCategory(category.getText().toString())==null){
            categoriesList.add(new Category(category.getText().toString()));
            verification.setText(category.getText().toString() + " Category added");
        }
        else{
            verification.setText(category.getText().toString() + " Category already exists");
        }

        category.clear();
    }
}
