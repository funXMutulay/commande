package com.growhubsn.ghlink.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growhubsn.ghlink.model.PlanAccomp;
import com.growhubsn.ghlink.repository.PlanAccompRepository;

@Service
public class PlanAccompService {

@Autowired    
private PlanAccompRepository  planAccompRepository;


public List<PlanAccomp> findAll(){
    return planAccompRepository.findAll();
}

public Optional<PlanAccomp> findById(Long id){
    return  planAccompRepository.findById(id);
}

public void delete(Long id){
    planAccompRepository.deleteById(id);
}

public void save(PlanAccomp planAccomp){
    planAccompRepository.save(planAccomp);
}

}
