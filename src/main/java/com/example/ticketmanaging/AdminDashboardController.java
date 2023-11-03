package com.example.ticketmanaging;

import com.almasb.fxgl.app.MainWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdminDashboardController {
    @FXML
    private Button SignOut;
    @FXML
    private Button AddNewCategory;
    @FXML
    private Button RemoveCategory;

    Main m=new Main();
    public void signOut(ActionEvent Event) throws IOException{
        m.changeScene("AdminLogin.fxml");
    }

    public void SendToAddNewCategory(ActionEvent Event) throws IOException{
        m.changeScene("addCategory.fxml");
    }

    public void SendToRemoveCategory(ActionEvent Event) throws IOException{
        m.changeScene("removeCategory.fxml");
    }

    public void SentToEditCategory(ActionEvent Event) throws IOException{
        m.changeScene("editCategory.fxml");
    }

    public void SendToAddEvent(ActionEvent Event) throws IOException{
        m.changeScene("addEvent.fxml");
    }

    public void SendToRemoveEvent(ActionEvent Event) throws IOException{
        m.changeScene("removeEvent.fxml");
    }

    public void SendToEditEvent(ActionEvent Event) throws IOException{
        m.changeScene("EditEvent.fxml");
    }

}
