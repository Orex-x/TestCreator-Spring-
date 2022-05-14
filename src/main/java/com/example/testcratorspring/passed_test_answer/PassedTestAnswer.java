package com.example.testcratorspring.passed_test_answer;

import com.example.testcratorspring.passedAnswer.PassedAnswer;
import com.example.testcratorspring.passed_test.PassedTest;
import com.example.testcratorspring.question.Question;

import javax.persistence.*;

@Entity
@Table(name = "PassedAnswerPassedTest")
public class PassedTestAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id_passed_test_answer;

    @OneToOne
    @JoinColumn(name = "PassedAnswersId")
    PassedAnswer passedAnswer;

    @OneToOne
    @JoinColumn(name = "PassedTestId")
    PassedTest passedTest;


    public PassedTestAnswer(PassedAnswer passedAnswer, PassedTest passedTest) {
        this.passedAnswer = passedAnswer;
        this.passedTest = passedTest;
    }

    public PassedTestAnswer() {
    }

    public void setId_passed_test_answer(Long id_passed_test_answer) {
        this.id_passed_test_answer = id_passed_test_answer;
    }

    public Long getId_passed_test_answer() {
        return id_passed_test_answer;
    }

    public PassedAnswer getPassedAnswer() {
        return passedAnswer;
    }

    public void setPassedAnswer(PassedAnswer passedAnswer) {
        this.passedAnswer = passedAnswer;
    }

    public PassedTest getPassedTest() {
        return passedTest;
    }

    public void setPassedTest(PassedTest passedTest) {
        this.passedTest = passedTest;
    }
}
