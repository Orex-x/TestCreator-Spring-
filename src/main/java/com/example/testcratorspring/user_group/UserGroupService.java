package com.example.testcratorspring.user_group;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserGroupService {
    @Autowired
    private UserGroupRepository userGroupRepository;

    public Iterable<UserGroup> getAllUserGroup(){
        return userGroupRepository.findAll();
    }

    public Optional<UserGroup> getUserGroup(String id){
        return userGroupRepository.findById(Long.parseLong(id));
    }
    public void addUserGroup(UserGroup userGroup){
        userGroupRepository.save(userGroup);
    }

    public void addUserGroup(String id, UserGroup userGroup){
        UserGroup userGroup1 = getUserGroup(id).get();
        userGroup1.setUser(userGroup.getUser());
        userGroup1.setGroup(userGroup.getGroup());
        userGroupRepository.save(userGroup1);
    }

    public void deleteUserGroup(String id){
        userGroupRepository.deleteById(Long.parseLong(id));
    }
}
