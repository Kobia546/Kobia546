package com.example.projetsecurite.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvisUtilisteur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idUtilisateur;
    String message;
    String statut;

}
