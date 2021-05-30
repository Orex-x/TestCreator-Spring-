package com.example.testcratorspring.answer;

import javax.persistence.*;

@Entity
@Table(name = "tblANSWER")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_answer")
    private Long id_answer;
    @Column(name = "answer")
    private String title;
    @Column(name = "group_name")
    private String group_name;
    @Column(name = "is_true")
    private Boolean is_true;

    public Answer() {
    }

    public Answer(String title, String group_name, Boolean is_true) {
        this.title = title;
        this.group_name = group_name;
        this.is_true = is_true;
    }

    public void setId_answer(Long id_answer) {
        this.id_answer = id_answer;
    }

    public Long getId_answer() {
        return id_answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public Boolean getIs_true() {
        return is_true;
    }

    public void setIs_true(Boolean is_true) {
        this.is_true = is_true;
    }
}
