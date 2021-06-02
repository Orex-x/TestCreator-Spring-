package com.example.testcratorspring.author;

import com.example.testcratorspring.test.Test;
import com.example.testcratorspring.user.User;

import javax.persistence.*;

@Entity
@Table(name = "tblAUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private Long id_author;

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Author() {
    }

    public Author(Test test, User user) {
        this.test = test;
        this.user = user;
    }

    public void setId_author(Long id_author) {
        this.id_author = id_author;
    }


    public Long getId_author() {
        return id_author;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
