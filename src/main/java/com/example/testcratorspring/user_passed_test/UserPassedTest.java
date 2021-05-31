package com.example.testcratorspring.user_passed_test;

import com.example.testcratorspring.passed_test.PassedTest;
import com.example.testcratorspring.user.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

@Entity
@Table(name = "tblUSER_PASSED_TEST")
public class UserPassedTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_passed_test")
    private Long id_user_passed_test;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "passed_test_id")
    private PassedTest passedTest;

    public UserPassedTest(User user, PassedTest passedTest) {
        this.user = user;
        this.passedTest = passedTest;
    }

    public UserPassedTest() {
    }

    public void setId_user_passed_test(Long id_user_passed_test) {
        this.id_user_passed_test = id_user_passed_test;
    }


    public Long getId_user_passed_test() {
        return id_user_passed_test;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PassedTest getPassedTest() {
        return passedTest;
    }

    public void setPassedTest(PassedTest passedTest) {
        this.passedTest = passedTest;
    }
}