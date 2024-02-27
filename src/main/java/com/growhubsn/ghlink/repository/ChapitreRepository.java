package com.growhubsn.ghlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growhubsn.ghlink.model.Chapitre;

@Repository
public interface ChapitreRepository extends JpaRepository<Chapitre,Long>{
    
}
