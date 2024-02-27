package com.growhubsn.ghlink.service ;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhubsn.ghlink.model.Chapitre;
import com.growhubsn.ghlink.repository.ChapitreRepository;


@Service
public class ChapitreService {

@Autowired    
private ChapitreRepository  chapitreRepository;


public List<chapitre> findAll(){
    return chapitreRepository.findAll();
}

public Optional<Chapitre> findById(Long id){
    return  chapitreRepository.findById(id);
}

public void delete(Long id){
    chapitreRepository.deleteById(id);
}

public void save(Chapitre chapitre){
    chapitreRepository.save(chapitre);
}


}
