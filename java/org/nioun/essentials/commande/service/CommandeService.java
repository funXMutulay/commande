package org.nioun.essentials.commande.service;

import java.util.List;

import org.nioun.essentials.commande.model.Commande;

public interface CommandeService {

	Commande saveCommande(Commande commande);
	
	Commande updateCommande(Commande commande);
	
	void deleteCommande(Commande commande);
	
	Commande getCommande(Long commandeId);
	
	List<Commande> getAllCommandes();
}
