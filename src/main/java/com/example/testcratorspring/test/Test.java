package com.example.testcratorspring.test;

import javax.persistence.*;

@Entity
@Table(name = "tblTEST")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test")
    private Long id_test;
    @Column(name = "title")
    private String title;

    public Test(String title) {
        this.title = title;
    }

    public Test() {
    }

    public void setId_test(Long id_test) {
        this.id_test = id_test;
    }


    public Long getId_test() {
        return id_test;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
