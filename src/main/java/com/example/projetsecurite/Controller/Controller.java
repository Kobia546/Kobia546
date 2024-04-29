package com.example.projetsecurite.Controller;

import com.example.projetsecurite.Entities.AvisUtilisteur;
import com.example.projetsecurite.Repositoryavis.AvisRepository;
import com.example.projetsecurite.Service.ServiceAvis;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private  AvisRepository repository;

    private final ServiceAvis avis;

    public Controller(ServiceAvis avis) {
        this.avis = avis;
    }


    @PostMapping("/post")
    public AvisUtilisteur CreerAvis(@RequestBody AvisUtilisteur utilisteur){
       return  this.avis.Create(utilisteur);

    }


}
