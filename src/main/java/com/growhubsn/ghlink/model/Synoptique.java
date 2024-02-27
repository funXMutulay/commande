package com.growhubsn.ghlink.model;

import java.math.BigDecimal;
import java.util.Date;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Synoptique {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long synoptiqueId; 
    private String denominationRaisonSociale;
    private String formeJuridique;
    private String numImmatRC;
    private String numIdentificationFiscale;
    private String addresseGeographique;
    private String telephone;
    private String fax;
    private String email;
    private String  siteWeb;
    private String nomPrincipal;
    private String prenomPrincipal;
    private String fonctionPrincipal;
    private String nomContact;
    private String prenomContact;
    private String fonctionContact;
    private String addresseContact;
    private String telephoneContact;
    private String faxContact;
    private String mailContact;
    private Date dateCreation;
    private Date dateDemarrage;
    private BigDecimal montantCapitalSocial ;
    private Integer pourcentageRepartitionNational;
    private Integer pourcentageRepartitionUEMOA;
    private Integer pourcentageRepartitionEtranger;
    private String paysOrigineCapitalEtranger;
    private String acitvitePrincipale;
    private String produits ;
    private String banquePartenaire ;
    private BigDecimal chiffreAffaires;
    private Integer pourcentagePartExport;
    private BigDecimal valeurAjoutee;
    private BigDecimal chargesFinancieres;
    private BigDecimal tresorerieNette;
    private Integer nombreEmplois;
    
}
