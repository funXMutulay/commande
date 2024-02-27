package com.growhubsn.ghlink.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.growhubsn.ghlink.model.Synoptique;
import com.growhubsn.ghlink.repository.SynoptiqueRepository;

@CrossOrigin(origins="*" , maxAge=3600)
@RestController
@RequestMapping("/api/synoptique")
public class SynoptiqueController {


    @Autowired
     SynoptiqueRepository synoptiqueRepository;


    @GetMapping("/")
    public ResponseEntity<List<Synoptique>> getAllSynoptiqueRepository(@RequestParam(required=false) String denominationRaisonSociale){

        try {
            List<Synoptique>  synoptiques = new ArrayList<Synoptique>();
            if (denominationRaisonSociale == null)
                synoptiqueRepository.findAll().forEach(synoptiques::add);

            else
            synoptiqueRepository.findByDenominationRaisonSociale(denominationRaisonSociale).forEach(synoptiques::add);

            if(synoptiques.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            
            return new ResponseEntity<>(synoptiques,HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{synoptiqueId}")
    public Synoptique getSynoptiqueById(@PathVariable   ("synoptiqueId") Long synoptiqueId ){

      Optional<Synoptique>   synoptiqueData = synoptiqueRepository.findById(synoptiqueId);

      if(synoptiqueData.isPresent()){
        
      }

    }



    
}