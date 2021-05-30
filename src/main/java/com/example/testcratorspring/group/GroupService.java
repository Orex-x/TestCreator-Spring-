package com.example.testcratorspring.group;

import com.example.testcratorspring.group.Group;
import com.example.testcratorspring.group.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public Iterable<Group> getAllGroup(){
        return groupRepository.findAll();
    }

    public Optional<Group> getGroup(String id){
        return groupRepository.findById(Long.parseLong(id));
    }
    public void addGroup(Group group){
        groupRepository.save(group);
    }

    public void addGroup(String id, Group group){
        Group group1 = getGroup(id).get();
        group1.setName_group(group.getName_group());
        group1.setPassword(group.getPassword());
        groupRepository.save(group1);
    }

    public void deleteGroup(String id){
        groupRepository.deleteById(Long.parseLong(id));
    }
}
