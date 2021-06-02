package com.example.testcratorspring.user;

import com.example.testcratorspring.answer.Answer;
import com.example.testcratorspring.question.Question;
import com.example.testcratorspring.test.Test;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblUSER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id_user;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "user_login")
    private String login;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_activation_code")
    private String activationCode;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tblAUTHOR", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id"))
    private Set<Test> tests = new HashSet<>();


    public User() {
    }

    public User(String first_name, String surname, String last_name, String login,
                String password, String email, String user_activation_code) {
        this.first_name = first_name;
        this.surname = surname;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.activationCode = user_activation_code;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_user() {
        return id_user;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lastName) {
        this.last_name = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String user_email) {
        this.email = user_email;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }




    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }
   /* public void addTest(Test test){
        this.tests.add(test);
        test.getUsers().add(this);
    }

    public void removeTest(Test test){
        this.tests.remove(test);
        test.getUsers().remove(this);
    }*/
}
