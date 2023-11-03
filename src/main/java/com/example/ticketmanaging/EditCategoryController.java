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

import static com.example.ticketmanaging.Main.categoriesList;
import static com.example.ticketmanaging.Main.eventsList;

public class EditCategoryController implements Initializable{
    @FXML
    private Label verification;
    @FXML
    private ComboBox categoriesBox;
    @FXML
    private TextField newCategory;

    Main m=new Main();
    public void Back(ActionEvent Event) throws IOException{
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

    public void EditCategory(ActionEvent Event) throws IOException {
        Category NEWCategory=findCategory(newCategory.getText().toString());
        String oldCategory=(String)categoriesBox.getValue();

        String New=newCategory.getText().toString();

        try{
            if(categoriesBox.getValue().equals(null) || newCategory.getText().isEmpty()){
                verification.setText("Please enter categories in the fields bellow");
            }
            else if(NEWCategory==null){
                Category Old=findCategory(categoriesBox.getValue().toString());
                int index=categoriesList.indexOf(Old);
                categoriesList.get(index).setName(New);

                for(int i=0;i<eventsList.size();i++){
                    if(categoriesBox.getValue().toString().equals(eventsList.get(i).getCategoryName())){
                        eventsList.get(i).setCategoryName(newCategory.getText());
                    }
                }

                verification.setText(oldCategory +" event changed to " + New);
            }
            else{
                verification.setText(New + " event already exists");
            }
        }catch(NullPointerException e){
            verification.setText("Please enter categories");
        }

        categoriesBox.getSelectionModel().clearSelection();
        newCategory.clear();

        categoriesBox.getItems().clear();
        for(int i = 0; i<categoriesList.size(); i++){
            categoriesBox.getItems().add(categoriesList.get(i).getName());
        }
    }
}
