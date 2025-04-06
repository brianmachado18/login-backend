package com.demoConcepto.demo.dto;

import lombok.Data;


public class AuthRequest {
    private String mail;
    private String pass;

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
