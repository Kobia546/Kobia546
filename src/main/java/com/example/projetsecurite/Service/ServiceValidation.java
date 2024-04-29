package com.example.projetsecurite.Service;

import com.example.projetsecurite.Entities.Utilisateur;
import com.example.projetsecurite.Entities.Validation;

public interface ServiceValidation {
    void Enregistrer(Utilisateur utilisateur);
    Validation Lireenfonctionducode(String code);
}
