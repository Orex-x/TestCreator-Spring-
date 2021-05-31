package com.example.testcratorspring.group_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupTestService {
    @Autowired
    private GroupTestRepository groupTestRepository;

    public Iterable<GroupTest> getAllGroupTest(){
        return groupTestRepository.findAll();
    }

    public Optional<GroupTest> getGroupTest(String id){
        return groupTestRepository.findById(Long.parseLong(id));
    }
    public void addGroupTest(GroupTest groupTest){
        groupTestRepository.save(groupTest);
    }

    public void addGroupTest(String id, GroupTest groupTest){
        GroupTest groupTest1 = getGroupTest(id).get();
        groupTest1.setGroup(groupTest.getGroup());
        groupTest1.setTest(groupTest.getTest());
        groupTestRepository.save(groupTest1);
    }

    public void deleteGroupTest(String id){
        groupTestRepository.deleteById(Long.parseLong(id));
    }
}
