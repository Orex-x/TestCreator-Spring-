package com.example.testcratorspring.user_group;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserGroupController {
    @Autowired
    private UserGroupService userGroupService;

    @RequestMapping(value = "/userGroups")
    public Iterable<UserGroup> getAllUserGroup(){return userGroupService.getAllUserGroup();}

    @RequestMapping(value = "/userGroups/{Id}")
    public Optional<UserGroup> getUserGroup(@PathVariable String Id){
        return userGroupService.getUserGroup(Id);
    }

    @RequestMapping(value = "/userGroups", method = RequestMethod.POST)
    public void addUserGroup(@RequestBody UserGroup userGroupGroup){
        userGroupService.addUserGroup(userGroupGroup);
    }
    @RequestMapping(value = "/userGroups/{Id}" , method = RequestMethod.PUT)
    public void updateUserGroup(@PathVariable ("Id") String id,
                           @RequestBody UserGroup userGroupGroup){
        userGroupService.addUserGroup(id, userGroupGroup);
    }

    @RequestMapping(value = "/userGroups/{Id}", method = RequestMethod.DELETE)
    public void deleteUserGroup(@PathVariable ("Id") String id){
        userGroupService.deleteUserGroup(id);
    }
}
