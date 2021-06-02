package com.example.testcratorspring.test;
import com.example.testcratorspring.answer.Answer;
import com.example.testcratorspring.author.Author;
import com.example.testcratorspring.author.AuthorRepository;
import com.example.testcratorspring.question.Question;
import com.example.testcratorspring.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        Set<Question> qustion = test.getQuestions();
        Question question = qustion.iterator().next();
        Set<Answer> answers = question.getAnswers();
        Answer answer = answers.iterator().next();
        String AAA = answer.getGroupName();
        testRepository.save(test);
    }

    public void updateTest(String id, Test test){
        Test test1 = getTest(id).get();
        test1.setTitle(test.getTitle());
        test1.setQuestions(test.getQuestions());
        testRepository.save(test1);
    }

    public void deleteTest(String id){
        testRepository.deleteById(Long.parseLong(id));
    }
}
