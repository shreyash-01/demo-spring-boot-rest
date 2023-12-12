package com.example.demospringbootrest.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    UserDAOImpl userDAO;

    @Autowired
    public UserService(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    public User getUser(Integer userID){
        return userDAO.getUser(userID);
    }

    public void createNewUser(User user){
        userDAO.insertUser(user);
    }

    public void updateExistingUser(User user) {
        userDAO.updateUser(user.getUserID(), user.getName());
    }

    public void deleteExistingUser(Integer userID) {
        userDAO.deleteUser(userID);
    }
}
