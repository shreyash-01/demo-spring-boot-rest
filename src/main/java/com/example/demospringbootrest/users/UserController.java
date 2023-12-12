package com.example.demospringbootrest.users;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<String> createUser(@RequestBody User user){
        try {
            userService.createNewUser(user);
            return new ResponseEntity<>("User Created", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Some Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userID ){
        try{
            userService.deleteExistingUser(userID);
            return new ResponseEntity<>("User Deleted", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        try {
            userService.updateExistingUser(user);
            return new ResponseEntity<>("User Updated", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Some Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
