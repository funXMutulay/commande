package com.growhubsn.ghlink.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhubsn.ghlink.model.User;
import com.growhubsn.ghlink.repository.UserRepository;

@Service
public class UserService {
 
 
    @Autowired    
private UserRepository  userRepository;


public List<User> findAll(){
    return userRepository.findAll();
}

public Optional<User> findById(Long id){
    return  userRepository.findById(id);
}

public void delete(Long id){
    userRepository.deleteById(id);
}

public void save(User user){
    userRepository.save(user);
}
}
