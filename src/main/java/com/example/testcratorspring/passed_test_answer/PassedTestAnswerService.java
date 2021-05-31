package com.example.testcratorspring.passed_test_answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassedTestAnswerService {

    @Autowired
    private PassedTestAnswerRepository passedTestAnswerRepository;

    public Iterable<PassedTestAnswer> getAllPassedTestAnswer(){
        return passedTestAnswerRepository.findAll();
    }

    public Optional<PassedTestAnswer> getPassedTestAnswer(String id){
        return passedTestAnswerRepository.findById(Long.parseLong(id));
    }
    public void addPassedTestAnswer(PassedTestAnswer passedTestAnswer){
        passedTestAnswerRepository.save(passedTestAnswer);
    }

    public void addPassedTestAnswer(String id, PassedTestAnswer passedTestAnswer){
        PassedTestAnswer passedTestAnswer1 = getPassedTestAnswer(id).get();
        passedTestAnswer1.setAnswer(passedTestAnswer.getAnswer());
        passedTestAnswer1.setPassedTest(passedTestAnswer.getPassedTest());
        passedTestAnswer1.setQuestion(passedTestAnswer.getQuestion());
        passedTestAnswerRepository.save(passedTestAnswer1);
    }

    public void deletePassedTestAnswer(String id){
        passedTestAnswerRepository.deleteById(Long.parseLong(id));
    }
}
