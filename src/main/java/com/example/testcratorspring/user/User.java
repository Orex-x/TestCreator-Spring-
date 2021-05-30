package com.example.testcratorspring.user;

import javax.persistence.*;

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


    public User() {
    }

    public User(String firstName, String surname, String lastName, String login, String password) {
        this.first_name = firstName;
        this.surname = surname;
        this.last_name = lastName;
        this.login = login;
        this.password = password;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_user() {
        return id_user;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
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
}
