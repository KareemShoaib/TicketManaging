package com.example.ticketmanaging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class EmployeeDashboardController {
    Main m = new Main();
    @FXML
    private Button Book;

    @FXML
    private Button RemoveCat;

    @FXML
    private Button Retrieve;

    @FXML
    private Button Search;

    @FXML
    private Button SignOut;

    @FXML
    private Button Unbook;

    @FXML
    private Button View;

    @FXML
    void BookTicket(ActionEvent event) throws IOException{
       m.changeScene("BookTicket.fxml");
    }

    @FXML
    public void RegisterClient(ActionEvent event) throws IOException {
        m.changeScene("ClientRegister.fxml");
    }

    @FXML
    public void RemoveClient(ActionEvent event) throws IOException {
        m.changeScene("RemoveClient.fxml");
    }

    @FXML
    void RetrieveData(ActionEvent event) throws IOException{
        m.changeScene("retrieveDataAboutClient.fxml");
    }

    @FXML
    void RetrieveEvents(ActionEvent event) throws IOException {
        m.changeScene("retrieveEventUnderCategory.fxml");
    }

    @FXML
    void SearchEvent(ActionEvent event) throws IOException {
      m.changeScene("SearchEvent.fxml");
    }

    @FXML
    void UnbookTicket(ActionEvent event) throws IOException {
        m.changeScene("UnbookTicket.fxml");
    }

    @FXML
    void ViewEventDetails(ActionEvent event) throws IOException {
        m.changeScene("viewEventDetails.fxml");
    }

    @FXML
    public void signOut(ActionEvent event) throws IOException {
    m.changeScene("MainWindow.fxml");
    }

}
