package com.example.testcratorspring.group;

import javax.persistence.*;

@Entity
@Table(name = "tblGROUP")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group")
    private Long id_group;
    @Column(name = "group_name")
    private String name_group;
    @Column(name = "group_password")
    private String password;


    public Group(String name_group, String password) {
        this.name_group = name_group;
        this.password = password;
    }

    public Group() {
    }

    public void setId_group(Long id_group) {
        this.id_group = id_group;
    }

    public Long getId_group() {
        return id_group;
    }

    public String getName_group() {
        return name_group;
    }

    public void setName_group(String name_group) {
        this.name_group = name_group;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
