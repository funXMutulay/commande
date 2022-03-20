package org.nioun.essentials.commande.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.nioun.essentials.commande.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CommandeRepository extends JpaRepository<Commande ,Long> {


	@Query("select name ,count(name) from Commande group by name" )
	public List<Object[]> findByNameAndNameCount();
	
	
}
