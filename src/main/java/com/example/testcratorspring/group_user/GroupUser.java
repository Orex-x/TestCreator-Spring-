package com.example.testcratorspring.group_user;

import com.example.testcratorspring.group.Group;
import com.example.testcratorspring.user.User;

import javax.persistence.*;

@Entity
@Table(name = "tblUSER_GROUP")
public class GroupUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user_group;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public GroupUser() {
    }

    public GroupUser(User user, Group group) {
        this.user = user;
        this.group = group;
    }

    public void setId_user_group(Long id_user_group) {
        this.id_user_group = id_user_group;
    }


    public Long getId_user_group() {
        return id_user_group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
