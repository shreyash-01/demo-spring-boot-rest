package com.example.demospringbootrest.users;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users;

    public UserService(){
        this.users = new ArrayList<>();
        this.users.add(new User(100, "Shreyash", 21));
        this.users.add(new User(101, "Shaan", 20));
        this.users.add(new User(102, "Utkarsh", 19));
    }

    public List<User> getUsers() {
        return this.users;
    }

    public User getUser(Integer userID){
        for(User user: users){
            if(user.getUserID()==userID){
                return user;
            }
        }
        return null;
    }
}
