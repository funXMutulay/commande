package com.growhubsn.ghlink.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growhubsn.ghlink.model.Synoptique;

@Repository
public interface SynoptiqueRepository extends JpaRepository<Synoptique,Long>{
    
List<Synoptique> findByDenominationRaisonSociale(String denominationRaisonSociale);

}
