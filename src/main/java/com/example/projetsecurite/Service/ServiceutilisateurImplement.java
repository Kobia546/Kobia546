package com.example.projetsecurite.Service;

import com.example.projetsecurite.Entities.Role;
import com.example.projetsecurite.Entities.TypeRole;
import com.example.projetsecurite.Entities.Utilisateur;
import com.example.projetsecurite.Entities.Validation;
import com.example.projetsecurite.Repositoryavis.UtilisateurRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.Map;
import java.util.Optional;


@Slf4j


@Service
public class ServiceutilisateurImplement implements ServiceUtilisateur {

     @Autowired
    private UtilisateurRepository utilisateurRepository;
    public  BCryptPasswordEncoder passwordEncoder;

    public final ServiceValidation serviceValidation;


    public ServiceutilisateurImplement(BCryptPasswordEncoder passwordEncoder, ServiceValidation serviceValidation) {
        this.passwordEncoder = passwordEncoder;
        this.serviceValidation = serviceValidation;
    }


    @Override
    public void creerUtilisateur(Utilisateur utilisateur) {

        String Password = this.passwordEncoder.encode(utilisateur.getMdp());
        if (!utilisateur.getEmail().contains("@")) {
            throw new RuntimeException("Ceci n'est pas une adresse gmail valide");
        }


        if (!utilisateur.getEmail().contains(".")) {
            throw new RuntimeException(("Ceci n'est pas une adresse Email"));
        }


          Optional <Utilisateur> utilisateur1=this.utilisateurRepository.findByEmail(utilisateur.getEmail());
         if(utilisateur1.isPresent()){

           throw new RuntimeException ("Cette adresse email est deja utilisee");

         }

            utilisateur.setMdp(Password);
            Role roleUtilisateur = new Role();
            roleUtilisateur.setLibelle(TypeRole.UTILISATEUR);
            utilisateur.setRole(roleUtilisateur);

                 utilisateur = this.utilisateurRepository.save(utilisateur);
                  this.serviceValidation.Enregistrer(utilisateur);


        }

    @Override
    public void validation(Map<String, String> activation) {
        Validation validation=serviceValidation.Lireenfonctionducode(activation.get("Code"));
       if(Instant.now().isAfter(validation.getExp())){
           throw new RuntimeException("Votre code a expire");
       }
      Utilisateur utilisateurActive =this.utilisateurRepository.findById(validation.getUtilisateur().getId()).orElseThrow(()->new RuntimeException("Votre telepmo"));
       utilisateurActive.setActif(true);
       this.utilisateurRepository.save(utilisateurActive);

    }
}