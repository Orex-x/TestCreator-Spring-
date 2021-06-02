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
    private String name;
    @Column(name = "group_password")
    private String password;
    @Column(name = "security_status")
    private String security_status;
    @Column(name = "invitation_link")
    private String invitationLink;


    public Group(String name, String password, String security_status, String invitationLink) {
        this.name = name;
        this.password = password;
        this.security_status = security_status;
        this.invitationLink = invitationLink;
    }

    public Group() {
    }

    public void setId_group(Long id_group) {
        this.id_group = id_group;
    }

    public Long getId_group() {
        return id_group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name_group) {
        this.name = name_group;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurity_status() {
        return security_status;
    }

    public void setSecurity_status(String security_status) {
        this.security_status = security_status;
    }

    public String getInvitationLink() {
        return invitationLink;
    }

    public void setInvitationLink(String invitation_link) {
        this.invitationLink = invitation_link;
    }
}
