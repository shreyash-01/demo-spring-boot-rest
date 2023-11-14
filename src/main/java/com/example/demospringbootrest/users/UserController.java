package com.example.demospringbootrest.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("")
    public List<User> getAllUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/{userID}")
    public User getUser(@PathVariable Integer userID){
        return userService.getUser(userID);
    }

    @PostMapping("")
    public String createUser(@RequestBody User user){
        return userService.createNewUser(user);
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<HttpEntity> deleteUser(@PathVariable Integer userID ){
        try{
            userService.deleteExistingUser(userID);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public User updateUser(@RequestBody User user){
        return userService.updateExistingUser(user);

    }
}
