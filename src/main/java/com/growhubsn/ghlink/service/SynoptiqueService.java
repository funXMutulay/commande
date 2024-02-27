package com.growhubsn.ghlink.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhubsn.ghlink.model.Synoptique;
import com.growhubsn.ghlink.repository.SynoptiqueRepository;

@Service
public class SynoptiqueService {
    @Autowired    
private SynoptiqueRepository  synoptiqueRepository;


public List<Synoptique> findAll(){
    return synoptiqueRepository.findAll();
}

public Optional<Synoptique> findById(Long id){
    return  synoptiqueRepository.findById(id);
}

public void delete(Long id){
    synoptiqueRepository.deleteById(id);
}

public void save(Synoptique synoptique){
    synoptiqueRepository.save(synoptique);
}
}
