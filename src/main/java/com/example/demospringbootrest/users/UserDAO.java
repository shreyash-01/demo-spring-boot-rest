package com.example.demospringbootrest.users;

import java.util.List;

public interface UserDAO {
    void insertUser(User user);
    void deleteUser();
    User getUser(Integer userID);
    List<User> getUsers();
    void updateUser();
}
