package com.example.testcratorspring.question;

import javax.persistence.*;

@Entity
@Table(name = "tblQUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Long id_question;
    @Column(name = "title")
    private String title;
    @Column(name = "mark")
    private Integer mark;
    @Column(name = "num_true_mark")
    private Integer numTrueMark;
    @Column(name = "is_check_box")
    private Boolean isCheckBox;

    public Question() {
    }


    public Question(String title, Integer mark, Integer numTrueMark, Boolean id_check_box) {
        this.title = title;
        this.mark = mark;
        this.numTrueMark = numTrueMark;
        this.isCheckBox = id_check_box;
    }

    public void setId_question(Long id_question) {
        this.id_question = id_question;
    }

    public Long getId_question() {
        return id_question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getNumTrueMark() {
        return numTrueMark;
    }

    public void setNumTrueMark(Integer num_true_mark) {
        this.numTrueMark = num_true_mark;
    }

    public Boolean getIsCheckBox() {
        return isCheckBox;
    }

    public void setIsCheckBox(Boolean id_check_box) {
        this.isCheckBox = id_check_box;
    }
}
