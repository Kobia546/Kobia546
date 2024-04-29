package com.example.projetsecurite.Repositoryavis;

import com.example.projetsecurite.Entities.Validation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValidationRepository extends CrudRepository<Validation,Long> {

    Optional<Validation> findByCode(String Code);
}
