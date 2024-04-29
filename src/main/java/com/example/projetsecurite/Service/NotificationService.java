package com.example.projetsecurite.Service;

import com.example.projetsecurite.Entities.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class NotificationService {

    @Autowired
    JavaMailSender javaMailSender;

    public void envoyeer(Validation validation) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("no-reply@MAMBO-CHRISTIAN");
            mailMessage.setTo(validation.getUtilisateur().getEmail());
            mailMessage.setSubject("Code d'activation");
            String text = String.format("Bonjour M %s votre code est le %s .A bientot",
                    validation.getUtilisateur().getNom(),
                    validation.getCode()
            );
            mailMessage.setText(text);
            javaMailSender.send(mailMessage);
        } catch (MailException ex) {
            // Gérer l'exception ici
            ex.printStackTrace(); // Vous pouvez imprimer la trace de la pile pour le suivi des erreurs
        }
    }
}



