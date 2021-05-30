package com.example.testcratorspring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users")
    public Iterable<User> getAllPost(){return userService.getAllUser();}

    @RequestMapping(value = "/users/{Id}")
    public Optional<User> getUser(@PathVariable String Id){
        return userService.getUser(Id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
    @RequestMapping(value = "/users/{Id}" , method = RequestMethod.PUT)
    public void updateUser(@PathVariable ("Id") String id,
                              @RequestBody User user){
        userService.addUser(id, user);
    }

    @RequestMapping(value = "/users/{Id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable ("Id") String id){
        userService.deleteUser(id);
    }
}
