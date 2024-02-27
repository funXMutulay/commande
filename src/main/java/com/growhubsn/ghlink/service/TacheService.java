package com.growhubsn.ghlink.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhubsn.ghlink.model.Tache;
import com.growhubsn.ghlink.repository.TacheRepository;

@Service
public class TacheService {
    @Autowired    
private TacheRepository  tacheRepository;


public List<Tache> findAll(){
    return tacheRepository.findAll();
}

public Optional<Tache> findById(int id){
    return  tacheRepository.findById(id);
}

public void delete(int id){
    tacheRepository.deleteById(id);
}

public void save(Tache tache){
    tacheRepository.save(tache);
}
}
