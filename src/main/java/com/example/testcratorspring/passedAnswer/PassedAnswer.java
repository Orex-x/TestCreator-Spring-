package com.example.testcratorspring.passedAnswer;


import com.example.testcratorspring.passed_test.PassedTest;
import com.example.testcratorspring.question.Question;
import com.example.testcratorspring.test.Test;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblPASSED_ANSWER")
public class PassedAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passed_answer")
    private Long id_passed_answer;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "answer")
    private String title;

    @ManyToMany(mappedBy = "passedAnswers")
    private Set<PassedTest> passedTests = new HashSet<>();


    public PassedAnswer(Question question, String title) {
        this.question = question;
        this.title = title;
    }

    public PassedAnswer() {

    }

    public Long getId_passed_answer() {
        return id_passed_answer;
    }

    public void setId_passed_answer(Long id_passed_answer) {
        this.id_passed_answer = id_passed_answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
