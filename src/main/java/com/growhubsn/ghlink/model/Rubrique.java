package com.growhubsn.ghlink.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Rubrique {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rubriqueId ;
    private String question;
    private String reponse;
}
