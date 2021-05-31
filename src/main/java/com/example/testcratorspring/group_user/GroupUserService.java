package com.example.testcratorspring.group_user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupUserService {
    @Autowired
    private GroupUserRepository groupUserRepository;

    public Iterable<GroupUser> getAllGroupUser(){
        return groupUserRepository.findAll();
    }

    public Optional<GroupUser> getGroupUser(String id){
        return groupUserRepository.findById(Long.parseLong(id));
    }
    public void addGroupUser(GroupUser groupUser){
        groupUserRepository.save(groupUser);
    }

    public void addGroupUser(String id, GroupUser groupUser){
        GroupUser groupUser1 = getGroupUser(id).get();
        groupUser1.setUser(groupUser.getUser());
        groupUser1.setGroup(groupUser.getGroup());
        groupUserRepository.save(groupUser1);
    }

    public void deleteGroupUser(String id){
        groupUserRepository.deleteById(Long.parseLong(id));
    }
}
