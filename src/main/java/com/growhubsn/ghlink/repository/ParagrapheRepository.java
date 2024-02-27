package com.growhubsn.ghlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growhubsn.ghlink.model.Paragraphe;

@Repository
public interface ParagrapheRepository extends JpaRepository<Paragraphe,Long>{
    
}
