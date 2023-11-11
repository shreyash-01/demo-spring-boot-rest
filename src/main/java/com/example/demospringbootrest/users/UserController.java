package com.example.demospringbootrest.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/{userID}")
    public User getUser(@PathVariable Integer userID){
        return userService.getUser(userID);
    }

    @PostMapping("/")
    public String createUser(@RequestBody User user){
        return userService.createNewUser(user);
    }

}
