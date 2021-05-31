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

    @RequestMapping(value = "/users/id/{Id}")
    public Optional<User> getUserbyId(@PathVariable String Id){
        return userService.getUserbyId(Id);
    }

    @RequestMapping(value = "/users/login/{Login}")
    public User getUserByLogin(@PathVariable String Login){
        return userService.getUserbyLogin(Login);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/users/{Id}" , method = RequestMethod.PUT)
    public void updateUser(@PathVariable ("Id") String id,
                              @RequestBody User user){
        userService.addUser(id, user);
    }

    @RequestMapping(value = "/users/id/{Id}", method = RequestMethod.DELETE)
    public void deleteUserbyId(@PathVariable ("Id") String id){
        userService.deleteUserbyId(id);
    }

    @RequestMapping(value = "/users/login/{Login}", method = RequestMethod.DELETE)
    public void deleteUserbyLogin(@PathVariable ("Login") String login){
        userService.deleteUserbyLogin(login);
    }

    @RequestMapping(value = "/users/activation/{code}", method = RequestMethod.GET)
    public boolean activate(@PathVariable String code){
       return userService.activateUser(code);
    }
}
