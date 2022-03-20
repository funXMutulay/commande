package org.nioun.essentials.commande.service;

import java.util.List;

import org.nioun.essentials.commande.model.Commande;
import org.nioun.essentials.commande.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	CommandeRepository commandeRepository; 
	
	
	public CommandeRepository getCommandeRepository() {
		return commandeRepository;
	}

	public void setCommandeRepository(CommandeRepository commandeRepository) {
		this.commandeRepository = commandeRepository;
	}

	public Commande saveCommande(Commande commande) {

		return commandeRepository.save(commande);
	}


	public Commande updateCommande(Commande commande) {

		return commandeRepository.save(commande);
	}


	public void deleteCommande(Commande commande) {
		commandeRepository.delete(commande);

	}


	public Commande getCommande(Long commandeId) {

		return commandeRepository.getOne(commandeId);
	}


	public List<Commande> getAllCommandes() {

		return commandeRepository.findAll();
	}

}
