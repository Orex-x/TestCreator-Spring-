package com.example.testcratorspring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(String id){
        return userRepository.findById(Long.parseLong(id));
    }
    public void addUser(User user){
        userRepository.save(user);
    }

    public void addUser(String id, User user){
        User user1 = getUser(id).get();
        user1.setFirstName(user.getFirstName());
        user1.setSurname(user.getSurname());
        user1.setLast_name(user.getLast_name());
        user1.setLogin(user.getLogin());
        user1.setPassword(user.getPassword());
        userRepository.save(user1);
    }

    public void deleteUser(String id){
        userRepository.deleteById(Long.parseLong(id));
    }
}
