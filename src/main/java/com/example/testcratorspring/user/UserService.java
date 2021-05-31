package com.example.testcratorspring.user;

import com.example.testcratorspring.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    //@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MailService mailService;

    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUserbyId(String id){
        return userRepository.findById(Long.parseLong(id));
    }
    public User getUserbyLogin(String login){
        return userRepository.findByLogin(login);
    }



    public boolean addUser(User user){
        User user1 = userRepository.findByLogin(user.getLogin());

        if(user1 != null){
            return false;
        }
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActivationCode(UUID.randomUUID().toString());
        String message = String.format(
                "Hello %s! \n" +
                        "Welcome to the cu..., TestCreator\n" +
                        "Tap this link: http://192.168.0.147:8080/users/activation/%s",
                user.getFirst_name(),
                user.getActivationCode()
        );

        mailService.send(user.getEmail(), message);

        userRepository.save(user);
        return true;
    }

    public void addUser(String id, User user){
        User user1 = getUserbyId(id).get();
        user1.setFirst_name(user.getFirst_name());
        user1.setSurname(user.getSurname());
        user1.setLast_name(user.getLast_name());
        user1.setLogin(user.getLogin());
        user1.setPassword(user.getPassword());
        userRepository.save(user1);
    }

    public void deleteUserbyId(String id){
        userRepository.deleteById(Long.parseLong(id));
    }

    public void deleteUserbyLogin(String login){
        userRepository.deleteByLogin(login);
    }


    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if(user == null)
            return false;
        user.setActivationCode(null);
        userRepository.save(user);
        return true;
    }
}
