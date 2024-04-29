package com.example.projetsecurite.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Instant creation;
    private Instant exp;
    private Instant activation;
    private String code;
    @OneToOne(cascade=CascadeType.ALL)
    private Utilisateur utilisateur;




}
