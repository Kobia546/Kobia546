package com.example.projetsecurite.Repositoryavis;

import com.example.projetsecurite.Entities.Utilisateur;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByEmail(String email);

}
