package com.example.testcratorspring.user;

import com.example.testcratorspring.group.Group;
import com.example.testcratorspring.mail.MailService;
import com.example.testcratorspring.user_group.UserGroup;
import com.example.testcratorspring.user_group.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Autowired
    @Qualifier("userGroupRepository")
    private UserGroupRepository userGroupRepository;

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


    public List<Group> getAllGroupForUser(User user){
     /*   Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://HOME-PC\\\\MSSQLSERVER;databasename=TestCreator",
                    "justuser",
                    "IWantSleep780381"
            );
            try {
                Statement statement = connection.createStatement();
                String query = "select * from tblUSER_GROUP where [user_id] = " + id;
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()){

                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
*/
        List<UserGroup> userGroups = userGroupRepository.findByUser(user);
        List<Group> groups = new ArrayList<>();

        for (UserGroup g : userGroups) {
            groups.add(g.getGroup());
        }

        return groups;
    }

    public List<UserGroup> getAllUserGroupForUser(User user){
        return userGroupRepository.findByUser(user);
    }

    public List<User> getAllUserByGroup(Group group){
        List<UserGroup> userGroups = userGroupRepository.findByGroup(group);
        List<User> listU = new ArrayList<>();
        for (UserGroup us : userGroups) {
            listU.add(us.getUser());
        }
        return listU;
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
        user1.setTests(user.getTests());
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
