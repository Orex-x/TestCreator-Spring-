package com.example.testcratorspring.group_user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GroupUserController {
    @Autowired
    private GroupUserService groupUserService;

    @RequestMapping(value = "/groupUsers")
    public Iterable<GroupUser> getAllGroupUser(){return groupUserService.getAllGroupUser();}

    @RequestMapping(value = "/groupUsers/{Id}")
    public Optional<GroupUser> getGroupUser(@PathVariable String Id){
        return groupUserService.getGroupUser(Id);
    }

    @RequestMapping(value = "/groupUsers", method = RequestMethod.POST)
    public void addGroupUser(@RequestBody GroupUser groupGroupUser){
        groupUserService.addGroupUser(groupGroupUser);
    }
    @RequestMapping(value = "/groupUsers/{Id}" , method = RequestMethod.PUT)
    public void updateGroupUser(@PathVariable ("Id") String id,
                           @RequestBody GroupUser groupGroupUser){
        groupUserService.addGroupUser(id, groupGroupUser);
    }

    @RequestMapping(value = "/groupUsers/{Id}", method = RequestMethod.DELETE)
    public void deleteGroupUser(@PathVariable ("Id") String id){
        groupUserService.deleteGroupUser(id);
    }
}
