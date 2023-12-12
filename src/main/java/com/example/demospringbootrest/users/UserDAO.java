package com.example.demospringbootrest.users;

import java.util.List;

public interface UserDAO {
    void insertUser(User user);
    void deleteUser(int ID);
    User getUser(Integer userID);
    List<User> getUsers();
    void updateUser(int ID, String name);
}
