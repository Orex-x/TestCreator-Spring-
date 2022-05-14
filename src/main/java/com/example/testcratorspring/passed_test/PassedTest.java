package com.example.testcratorspring.passed_test;

import com.example.testcratorspring.answer.Answer;
import com.example.testcratorspring.passedAnswer.PassedAnswer;
import com.example.testcratorspring.passed_test_answer.PassedTestAnswer;
import com.example.testcratorspring.question.Question;
import com.example.testcratorspring.test.Test;
import com.example.testcratorspring.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PassedTests")
public class PassedTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id_passed_test;

    @OneToOne
    @JoinColumn(name = "TestId")
    private Test test;

    @Column(name = "Result")
    private Double result;

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinTable(name = "tblPASSED_TEST_ANSWER", joinColumns = @JoinColumn(name = "passed_test_id"),
            inverseJoinColumns = @JoinColumn(name = "passed_answer_id"))
    private Set<PassedAnswer> passedAnswers = new HashSet<>();



    @ManyToMany(mappedBy = "passedTests")
    private Set<User> users = new HashSet<>();


    public PassedTest() {
    }

    public PassedTest(Test test, Double result, Set<PassedTestAnswer> passedTestAnswers) {
        this.test = test;
        this.result = result;
    }

    public void setId_passed_test(Long id_passed_test) {
        this.id_passed_test = id_passed_test;
    }


    public Long getId_passed_test() {
        return id_passed_test;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Set<PassedAnswer> getPassedAnswers() {
        return passedAnswers;
    }

    public void setPassedAnswers(Set<PassedAnswer> passedAnswers) {
        this.passedAnswers = passedAnswers;
    }
}
