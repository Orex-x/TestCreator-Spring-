package com.example.testcratorspring.test;

import com.example.testcratorspring.answer.Answer;
import com.example.testcratorspring.question.Question;
import com.example.testcratorspring.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblTEST")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test")
    private Long id_test;
    @Column(name = "title")
    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tblTEST_QUESTION", joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private Set<Question> questions = new HashSet<>();

    @ManyToMany(mappedBy = "tests")
    private Set<User> users = new HashSet<>();



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

    /* @Override
    public String toString() {
        return "Test{" +
                "id_test=" + id_test +
                ", title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
*/
    /*

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    public void addQuestion(Question question){
        this.questions.add(question);
        question.getTests().add(this);
    }

    public void removeQuestion(Question question){
        this.questions.remove(question);
        question.getTests().remove(this);
    }
    public void addUser(User user){
        this.getUsers().add(user);
        user.getTests().add(this);
    }

    public void removeUser(User user){
        this.questions.remove(user);
        user.getTests().add(this);
    }
*/

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }


}
