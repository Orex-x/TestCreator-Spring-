package com.example.testcratorspring.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public Iterable<Test> getAllTest(){
        return testRepository.findAll();
    }

    public Optional<Test> getTest(String id){
        return testRepository.findById(Long.parseLong(id));
    }
    public void addTest(Test test){
        testRepository.save(test);
    }

    public void addTest(String id, Test test){
        Test test1 = getTest(id).get();
        test1.setTitle(test.getTitle());
        testRepository.save(test1);
    }

    public void deleteTest(String id){
        testRepository.deleteById(Long.parseLong(id));
    }
}
