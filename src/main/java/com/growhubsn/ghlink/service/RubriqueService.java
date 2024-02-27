package com.growhubsn.ghlink.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhubsn.ghlink.model.Rubrique;
import com.growhubsn.ghlink.repository.RubriqueRepository;

@Service
public class RubriqueService {

@Autowired    
private RubriqueRepository  rubriqueRepository;


public List<Rubrique> findAll(){
    return rubriqueRepository.findAll();
}

public Optional<Rubrique> findById(Long id){
    return  rubriqueRepository.findById(id);
}

public void delete(Long id){
    rubriqueRepository.deleteById(id);
}

public void save(Rubrique rubrique){
    rubriqueRepository.save(rubrique);
}
}
