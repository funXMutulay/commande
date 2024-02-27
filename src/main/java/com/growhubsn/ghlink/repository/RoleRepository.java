package com.growhubsn.ghlink.repository;

import org.springframework.stereotype.Repository;


import java.util.Optional;

import com.growhubsn.ghlink.model.Role;
import com.growhubsn.ghlink.model.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

// import org.springframework.data.jpa.repository.Query;

@Repository
public interface RoleRepository extends JpaRepository<Role ,Integer> {

/*
	@Query("select name ,count(name) from Budget group by name" )
	public List<Object[]> findByNameAndNameCou();
 */	

 Optional<Role> findByName(ERole name);

 	
}
