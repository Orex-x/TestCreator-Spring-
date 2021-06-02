package com.example.testcratorspring.user_group;

import com.example.testcratorspring.group.Group;
import com.example.testcratorspring.user.User;

import javax.persistence.*;

@Entity
@Table(name = "tblUSER_GROUP")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user_group;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "is_admin")
    private boolean is_admin;

    public UserGroup() {
    }

    public UserGroup(User user, Group group, boolean is_admin) {
        this.user = user;
        this.group = group;
        this.is_admin = is_admin;
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

    public boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}
