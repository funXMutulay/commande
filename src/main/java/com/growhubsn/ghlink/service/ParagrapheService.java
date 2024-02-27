package com.growhubsn.ghlink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.growhubsn.ghlink.dto.ParagrapheReception;
import com.growhubsn.ghlink.dto.ParagrapheRequest;
import com.growhubsn.ghlink.model.Paragraphe;
import com.growhubsn.ghlink.model.Rubrique;
import com.growhubsn.ghlink.repository.ParagrapheRepository;
import com.growhubsn.ghlink.repository.RubriqueRepository;

@Service
public class ParagrapheService {

@Autowired
ParagrapheRepository paragrapheRepository;

@Autowired
RubriqueRepository rubriqueRepository;


@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
public ParagrapheReception getParagraphe(ParagrapheRequest request ){

Rubrique rubrique = request.getRubrique();
rubriqueRepository.save(rubrique);

Paragraphe paragraphe = request.getParagraphe();
paragrapheRepository.save(paragraphe);
    
   return  new ParagrapheReception("Success",paragraphe,rubrique);
}

}