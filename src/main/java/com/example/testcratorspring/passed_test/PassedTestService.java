package com.example.testcratorspring.passed_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassedTestService {
    @Autowired
    private PassedTestRepository passedTestRepository;

    public Iterable<PassedTest> getAllPassedTest(){
        return passedTestRepository.findAll();
    }

    public Optional<PassedTest> getPassedTest(String id){
        return passedTestRepository.findById(Long.parseLong(id));
    }
    public void addPassedTest(PassedTest passedTest){
        passedTestRepository.save(passedTest);
    }

    public void addPassedTest(String id, PassedTest passedTest){
        PassedTest passedTest1 = getPassedTest(id).get();
        passedTest1.setTest(passedTest.getTest());
        passedTest1.setResult(passedTest.getResult());
        passedTestRepository.save(passedTest1);
    }

    public void deletePassedTest(String id){
        passedTestRepository.deleteById(Long.parseLong(id));
    }
}
