package com.example.ticketmanaging;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main extends Application {
    private static Stage stg;
    protected static ArrayList<Admin> adminsList = new ArrayList<>();
    protected static ArrayList<Employee> employeesList = new ArrayList<>();

    protected  static ArrayList<Category> categoriesList=new ArrayList<Category>();

    protected static ArrayList<Event> eventsList=new ArrayList<Event>();
    protected static ArrayList<Client> clientsList =new ArrayList<Client>();
    protected static ArrayList<Book> bookingsList=new ArrayList<Book>();

    protected static int isLoggedInIndex = -1;
    protected static boolean isLoggedInFlag = false;


    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 760, 480);
        stage.setTitle("TicketReservationSystem");
        stage.setScene(scene);
        stage.show();

    }
    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);

    }
    public static void main(String[] args) {

        Admin a1 = new Admin("Kareem Shoaib", "1234");
        Admin a2 = new Admin("Mazen Tayseer", "0000");
        Admin a3 = new Admin("Ahmed Tarek", "xyzd");
        Admin a4 = new Admin("Mohamed Khaled", "2003");
        Admin a5 = new Admin("Nadin Ahmed", "abcd");
        Admin a6=new Admin("1","1");

        Employee e1 = new Employee("1", "1");
        Employee e2 = new Employee("employee2", "abcd");
        Employee e3 = new Employee("employee3", "9876");

        adminsList.add(a1);
        adminsList.add(a2);
        adminsList.add(a3);
        adminsList.add(a4);
        adminsList.add(a5);
        adminsList.add(a6);

        employeesList.add(e1);
        employeesList.add(e2);
        employeesList.add(e3);

        Category c1=new Category("Match");
        LocalDate date = LocalDate.of(2020, 1, 8);
        Event event1=new Event("Match","Ahly",date,"08:00","Borj el arab","Final",50);
        Event event3=new Event("Match","Zamalek",date,"08:00","Borj el arab","Final",50);
        categoriesList.add(c1);
        eventsList.add(event1);
        eventsList.add(event3);

        Category c2=new Category("Concert");
        LocalDate date1 = LocalDate.of(2021, 12, 9);
        Event event2=new Event("Concert","Eminem",date1,"08:00","USA","Sing",50);
        categoriesList.add(c2);
        eventsList.add(event2);





        launch();
    }
}