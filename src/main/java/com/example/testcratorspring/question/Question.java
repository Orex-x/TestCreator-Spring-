package com.example.testcratorspring.question;

import com.example.testcratorspring.answer.Answer;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "num_true_answer")
    private Integer numTrueAnswer;
    @Column(name = "is_check_box")
    private Boolean isCheckBox;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tblQUESTION_ANSWER", joinColumns = @JoinColumn(name = "question_id"),
        inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private Set<Answer> answers = new HashSet<>();

    public Question() {
    }


    public Question(String title, Integer mark, Integer numTrueAnswer, Boolean id_check_box) {
        this.title = title;
        this.mark = mark;
        this.numTrueAnswer = numTrueAnswer;
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

    public Integer getNumTrueAnswer() {
        return numTrueAnswer;
    }

    public void setNumTrueAnswer(Integer num_true_mark) {
        this.numTrueAnswer = num_true_mark;
    }

    public Boolean getIsCheckBox() {
        return isCheckBox;
    }

    public void setIsCheckBox(Boolean id_check_box) {
        this.isCheckBox = id_check_box;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer){
        this.answers.add(answer);
        answer.getQuestions().add(this);
    }

    public void removeAnswer(Answer answer){
        this.answers.remove(answer);
        answer.getQuestions().add(this);

    }

}
