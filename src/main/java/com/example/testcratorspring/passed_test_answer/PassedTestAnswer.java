package com.example.testcratorspring.passed_test_answer;

import com.example.testcratorspring.passed_test.PassedTest;
import com.example.testcratorspring.question.Question;

import javax.persistence.*;

@Entity
@Table(name = "tblPASSED_TEST_ANSWER")
public class PassedTestAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passed_test_answer")
    private Long id_passed_test_answer;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToOne
    @JoinColumn(name = "passed_test_id")
    private PassedTest passedTest;

    @Column(name = "answer")
    private String answer;

    public PassedTestAnswer(Question question, PassedTest passedTest, String answer) {
        this.question = question;
        this.passedTest = passedTest;
        this.answer = answer;
    }

    public PassedTestAnswer() {
    }

    public void setId_passed_test_answer(Long id_passed_test_answer) {
        this.id_passed_test_answer = id_passed_test_answer;
    }


    public Long getId_passed_test_answer() {
        return id_passed_test_answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public PassedTest getPassedTest() {
        return passedTest;
    }

    public void setPassedTest(PassedTest passedTest) {
        this.passedTest = passedTest;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
