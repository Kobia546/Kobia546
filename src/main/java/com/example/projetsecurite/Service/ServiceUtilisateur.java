package com.example.projetsecurite.Service;

import com.example.projetsecurite.Entities.Utilisateur;

import java.util.Map;

public interface ServiceUtilisateur {
     void creerUtilisateur(Utilisateur utilisateur);

     void validation(Map<String, String> activation);
}
