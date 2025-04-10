package com.demoConcepto.demo.controllers;

import com.demoConcepto.demo.dto.MailRequest;
import com.demoConcepto.demo.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @Autowired
    private MailService mailService;

    @PostMapping("/mail")
    public String enviarCorreo(@RequestBody MailRequest mailRequest){
        mailService.enviarCorreo(mailRequest.getMail(), "Recuperación de Contraseña", "FUNCIONA");
        return "Correo enviado";
    }
}
