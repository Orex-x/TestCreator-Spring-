package com.example.testcratorspring.answer;

import javax.persistence.*;

@Entity
@Table(name = "tblANSWER")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_answer")
    private Long id_answer;
    @Column(name = "title")
    private String title;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "is_true")
    private Boolean isTrue;

    public Answer() {
    }

    public Answer(String title, String groupName, Boolean isTrue) {
        this.title = title;
        this.groupName = groupName;
        this.isTrue = isTrue;
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String group_name) {
        this.groupName = group_name;
    }

    public Boolean getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(Boolean is_true) {
        this.isTrue = is_true;
    }
}
