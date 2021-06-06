package com.example.testcratorspring.group_test;

import com.example.testcratorspring.group.Group;
import com.example.testcratorspring.test.Test;

import javax.persistence.*;

@Entity
@Table(name = "tblGROUP_TEST")
public class GroupTest {

    @Id
    @Column(name = "id_group_test")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_group_test;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public GroupTest(Group group, Test test) {
        this.group = group;
        this.test = test;
    }

    public GroupTest() {
    }

    public void setId_group_test(Long id_group_test) {
        this.id_group_test = id_group_test;
    }


    public Long getId_group_test() {
        return id_group_test;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "GroupTest{" +
                "id_group_test=" + id_group_test +
                ", group=" + group +
                ", test=" + test +
                '}';
    }
}
