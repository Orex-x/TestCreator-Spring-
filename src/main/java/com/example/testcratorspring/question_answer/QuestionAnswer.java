package com.example.testcratorspring.question_answer;


import com.example.testcratorspring.answer.Answer;
import com.example.testcratorspring.question.Question;

import javax.persistence.*;

@Entity
@Table(name = "tblQUESTION_ANSWER")
public class QuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question_answer")
    private Long id_question_answer;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;


    public QuestionAnswer(Question question, Answer answer) {
        this.question = question;
        this.answer = answer;
    }

    public QuestionAnswer() {
    }

    public void setId_question_answer(Long id_question_answer) {
        this.id_question_answer = id_question_answer;
    }


    public Long getId_question_answer() {
        return id_question_answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
