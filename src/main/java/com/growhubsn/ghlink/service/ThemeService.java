package com.growhubsn.ghlink.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhubsn.ghlink.model.Theme;
import com.growhubsn.ghlink.repository.ThemeRepository;

@Service
public class ThemeService {
    @Autowired    
private ThemeRepository  themeRepository;


public List<Theme> findAll(){
    return themeRepository.findAll();
}

public Optional<Theme> findById(Long id){
    return  themeRepository.findById(id);
}

public void delete(Long id){
    themeRepository.deleteById(id);
}

public void save(Theme theme){
    themeRepository.save(theme);
}
}
