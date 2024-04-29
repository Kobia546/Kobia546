package com.example.projetsecurite.Repositoryavis;

import com.example.projetsecurite.Entities.AvisUtilisteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisRepository extends CrudRepository<AvisUtilisteur,Long> {
}
