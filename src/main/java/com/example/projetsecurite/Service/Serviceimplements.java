package com.example.projetsecurite.Service;

import com.example.projetsecurite.Entities.AvisUtilisteur;

import com.example.projetsecurite.Repositoryavis.AvisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Serviceimplements implements ServiceAvis{

     @Autowired
     private AvisRepository repository;
    @Override
    public AvisUtilisteur Create(AvisUtilisteur avis) {
       return repository.save(avis);
    }
}
