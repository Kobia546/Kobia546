package com.example.projetsecurite.Service;

import com.example.projetsecurite.Entities.Utilisateur;
import com.example.projetsecurite.Entities.Validation;
import com.example.projetsecurite.Repositoryavis.ValidationRepository;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Data
@Service
public class ServiceimplementsValidation implements ServiceValidation{

    private final ValidationRepository repository;
    private final NotificationService notificationService;

    @Autowired
    public ServiceimplementsValidation(ValidationRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    @Override
    public void Enregistrer(Utilisateur utilisateur) {
        Validation validation=new Validation();
        validation.setUtilisateur(utilisateur);
        Instant creation=Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(10, ChronoUnit.MINUTES);
        validation.setExp(expiration);
        Random random=new Random();
        int randominteger=random.nextInt(99999);
        String code=String.format("%06d",randominteger);

        validation.setCode(code);
        this.repository.save(validation);
        this.notificationService.envoyeer(validation);
    }

    @Override
    public Validation Lireenfonctionducode(String Code) {
        return this.repository.findByCode(Code).orElseThrow(()-> new RuntimeException("Votre code d'activation est nulle"));

    }



}
