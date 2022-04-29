package org.nioun.essentials.commande.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Commande {

@Id
@GeneratedValue
private Long commandeId ;

private Long produitId;


@Lob
@Column(columnDefinition = "MEDIUMBLOB")
private String image;

private String name ;


private String description;

private BigDecimal quantite ;

private BigDecimal price ;

private BigDecimal prixTotal;

private String categorie ;


public Commande() {
	
}






public Commande(Long produitId,String image , String name,  String description,BigDecimal quantite, BigDecimal price,  BigDecimal prixTotal,
		String categorie) {
	super();
	this.produitId = produitId;
	this.image = image;
	this.name = name;
	this.image = image;this.description = description;
	this.price = price;
	this.quantite = quantite;
	this.prixTotal = prixTotal;
	this.categorie = categorie;
}



public Long getProduitId() {
	return produitId;
}


public void setProduitId(Long produitId) {
	this.produitId = produitId;
}


public Long getCommandeId() {
	return commandeId;
}


public void setCommandeId(Long commandeId) {
	this.commandeId= commandeId;
}


public String getImage() {
	return image;
}






public void setImage(String image) {
	this.image = image;
}






public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public BigDecimal getPrice() {
	return price;
}


public void setPrice(BigDecimal price) {
	this.price = price;
}


public BigDecimal getQuantite() {
	return quantite;
}


public void setQuantite(BigDecimal quantite) {
	this.quantite = quantite;
}


public BigDecimal getPrixTotal() {
	return prixTotal;
}


public void setPrixTotal(BigDecimal prixTotal) {
	this.prixTotal = prixTotal;
}


public String getCategorie() {
	return categorie;
}


public void setCategorie(String categorie) {
	this.categorie = categorie;
}



}
