package com.example.testcratorspring.test_question;

import com.example.testcratorspring.question.Question;
import com.example.testcratorspring.test.Test;

import javax.persistence.*;

@Entity
@Table(name = "QuestionTest")
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "TestsId")
    private Test test;

    @OneToOne
    @JoinColumn(name = "QuestionsId")
    private Question question;


    public TestQuestion() {
    }

    public TestQuestion(Test test, Question question) {
        this.test = test;
        this.question = question;
    }

    public void setId_test_question(Long id_test_question) {
        this.id = id_test_question;
    }


    public Long getId_test_question() {
        return id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}

