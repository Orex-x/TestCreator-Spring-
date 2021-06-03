package com.example.testcratorspring.test;

import com.example.testcratorspring.question.Question;
import com.example.testcratorspring.user.User;
import com.example.testcratorspring.group.Group;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblTEST")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test")
    private Long idTest;
    @Column(name = "title")
    private String title;

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinTable(name = "tblTEST_QUESTION", joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private Set<Question> questions = new HashSet<>();

    @ManyToMany(mappedBy = "tests")
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "tests")
    private Set<Group> group = new HashSet<>();


    public Test(String title) {
        this.title = title;
    }

    public Test() {
    }

    public void setIdTest(Long id_test) {
        this.idTest = id_test;
    }


    public Long getIdTest() {
        return idTest;
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
