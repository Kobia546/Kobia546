package com.example.projetsecurite.Controller;

import com.example.projetsecurite.Entities.Utilisateur;

import com.example.projetsecurite.Service.ServiceUtilisateur;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
public class ControllerUser {
    @Autowired
   private ServiceUtilisateur serviceUtilisateur;

    @PostMapping(value = "/inscription",consumes ="application/json")
    public void Creeruser( @RequestBody Utilisateur utilisateur)  {

         this.serviceUtilisateur.creerUtilisateur(utilisateur);
    }
    @PostMapping(value = "/activation")
    public void Creeruser(@RequestBody Map< String, String> activation)  {

        this.serviceUtilisateur.validation(activation);
    }
}
