package com.example.ticketmanaging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import static com.example.ticketmanaging.Main.*;
public class EmployeeController {
    Main m = new Main();
    @FXML
    private Button Cancel;

    @FXML
    private Label Error;

    @FXML
    private Button Login;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    private Employee findEmployee(String username){
        for(int i=0;i<employeesList.size();i++){
            Employee current=employeesList.get(i);
            if(current.getUsername().equals(username)){
                return current;
            }
        }
        return null;
    }

    public void addEmployee(ActionEvent Event) throws IOException{
        if(findEmployee(username.getText().toString())==null){
            employeesList.add(new Employee(username.getText().toString(), password.getText().toString()));
            Error.setText("Employee added");
        }
        else{
            Error.setText("Employee exists");
        }
    }

    @FXML
    public void SendBackToM (ActionEvent event) throws IOException {
        m.changeScene("EmployeeRegLog.fxml");
    }

    public void loginAsEmployee(ActionEvent Event) throws IOException{
        boolean flag=false;
        for(int i=0;i<employeesList.size();i++){
            if(employeesList.get(i).getUsername().equals(username.getText().toString()) && employeesList.get(i).getPassword().equals(password.getText().toString())){
                flag=true;
                break;
            }
        }

        if(flag){
            m.changeScene("EmployeeDashboard.fxml");
        }
        else{
            Error.setText("Wrong username or password");
        }

    }
public void SendToLoginnn(ActionEvent Event) throws IOException{

    m.changeScene("EmployeeLogin.fxml");



}
}







