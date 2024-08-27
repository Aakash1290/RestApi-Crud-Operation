package com.Aakash.userManagement;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.getUserList();
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){

        return this.service.getById(id);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
            return this.service.createUser(user);
    }
    @PostMapping("/addUsers")
    public ResponseEntity<List<User>> addUsers(@RequestBody List<User> users){
        return ResponseEntity.ok().body(this.service.createUserList(users));
    }
    @DeleteMapping("/deleteUser/{id}")
    public  ResponseEntity<User>  deleteUsers(@PathVariable int id){
        return ResponseEntity.ok().body(this.service.deleteUser(id));
    }
    @PutMapping("/updateUser/")
    public ResponseEntity<User> deleteUser(@RequestBody User user){
        return ResponseEntity.ok().body(this.service.updateUser(user));
    }

}
