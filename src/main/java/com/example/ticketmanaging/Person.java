package com.example.ticketmanaging;

import java.util.Objects;
import static com.example.ticketmanaging.Main.*;

public class Person {
    private String username;
    private String password;


    public Person(String username, String password){
        this.username=username;
        this.password=password;
    }

    public boolean isLoggedIn(){ return isLoggedInFlag; }
    public void login(String username, String password){
        isLoggedInFlag = Objects.equals(username, this.username) & Objects.equals(password, this.password);
    }
    public void logout(){
        isLoggedInFlag = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
