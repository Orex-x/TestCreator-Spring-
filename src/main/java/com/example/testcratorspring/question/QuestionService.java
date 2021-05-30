package com.example.testcratorspring.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Iterable<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestion(String id){
        return questionRepository.findById(Long.parseLong(id));
    }
    public void addQuestion(Question question){
        questionRepository.save(question);
    }

    public void addQuestion(String id, Question question){
        Question question1 = getQuestion(id).get();
        question1.setTitle(question.getTitle());
        question1.setMark(question.getMark());
        question1.setNum_true_mark(question.getNum_true_mark());
        question1.setIs_check_box(question.getIs_check_box());
        questionRepository.save(question1);
    }

    public void deleteQuestion(String id){
        questionRepository.deleteById(Long.parseLong(id));
    }
}
