package com.growhubsn.ghlink.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhubsn.ghlink.model.Role;
import com.growhubsn.ghlink.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired    
private RoleRepository  roleRepository;


public List<Role> findAll(){
    return roleRepository.findAll();
}

public Optional<Role> findById(int id){
    return  roleRepository.findById(id);
}

public void delete(int id){
    roleRepository.deleteById(id);
}

public void save(Role role){
    roleRepository.save(role);
}

}
