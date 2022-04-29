package org.nioun.essentials.commande.service;

import java.math.BigDecimal;
import java.util.List;

import org.nioun.essentials.commande.model.Commande;
import org.springframework.web.multipart.MultipartFile;

public interface CommandeService {

	Commande saveCommande(Commande commande);
	
	Commande updateCommande(Commande commande);
	
	void deleteCommande(Commande commande);
	
	Commande getCommande(Long commandeId);
	
	List<Commande> getAllCommandes();
	
void saveCommandeToDB(Long produitId , MultipartFile file  ,String name , String description ,BigDecimal price,BigDecimal quantite , BigDecimal prixTotal, String categorie);
	
	void updateCommandeToDB(Long commandeId ,Long produitId , MultipartFile file ,String name , String description ,BigDecimal price,BigDecimal quantite , BigDecimal prixTotal, String categorie);
	
	void deleteCommandeById(long commandeId);

	void changeCommandeImage(Long commandeId, MultipartFile nfile);
	
}
