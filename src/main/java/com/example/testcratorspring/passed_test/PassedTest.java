package com.example.testcratorspring.passed_test;

import com.example.testcratorspring.test.Test;

import javax.persistence.*;

@Entity
@Table(name = "tblPASSED_TEST")
public class PassedTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passed_test")
    private Long id_passed_test;

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @Column(name = "result")
    private String result;


    public PassedTest() {
    }

    public PassedTest(Test test, String result) {
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
