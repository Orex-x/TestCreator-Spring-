package com.example.testcratorspring.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/groups")
    public Iterable<Group> getAllPost(){return groupService.getAllGroup();}

    @RequestMapping(value = "/groups/{Id}")
    public Optional<Group> getGroup(@PathVariable String Id){
        return groupService.getGroup(Id);
    }

    @RequestMapping(value = "/groups", method = RequestMethod.POST)
    public void addGroup(@RequestBody Group group){
        groupService.addGroup(group);
    }
    @RequestMapping(value = "/groups/{Id}" , method = RequestMethod.PUT)
    public void updateGroup(@PathVariable ("Id") String id,
                           @RequestBody Group group){
        groupService.addGroup(id, group);
    }

    @RequestMapping(value = "/groups/{Id}", method = RequestMethod.DELETE)
    public void deleteGroup(@PathVariable ("Id") String id){
        groupService.deleteGroup(id);
    }
}
