package com.demoConcepto.demo.models;
import jakarta.persistence.*;
import lombok.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    private String mail;
    private String pass;

    public Usuario() {
    }

    public Usuario(long id, String mail, String pass) {
        this.id = id;
        this.mail = mail;
        this.pass = pass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
