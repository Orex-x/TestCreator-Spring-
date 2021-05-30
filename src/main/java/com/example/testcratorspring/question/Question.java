package com.example.testcratorspring.question;

import javax.persistence.*;

@Entity
@Table(name = "tblQUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Long id_question;
    @Column(name = "question")
    private String title;
    @Column(name = "mark")
    private Integer mark;
    @Column(name = "num_true_mark")
    private Integer num_true_mark;
    @Column(name = "is_check_box")
    private Boolean is_check_box;

    public Question() {
    }


    public Question(String title, Integer mark, Integer num_true_mark, Boolean id_check_box) {
        this.title = title;
        this.mark = mark;
        this.num_true_mark = num_true_mark;
        this.is_check_box = id_check_box;
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

    public Integer getNum_true_mark() {
        return num_true_mark;
    }

    public void setNum_true_mark(Integer num_true_mark) {
        this.num_true_mark = num_true_mark;
    }

    public Boolean getIs_check_box() {
        return is_check_box;
    }

    public void setIs_check_box(Boolean id_check_box) {
        this.is_check_box = id_check_box;
    }
}
