package org.nioun.essentials.commande.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;

import org.nioun.essentials.commande.model.Commande;
import org.nioun.essentials.commande.repository.CommandeRepository;
import org.nioun.essentials.commande.model.Commande;
import org.nioun.essentials.commande.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public  void saveCommandeToDB(Long commandeId,MultipartFile file, String name, String description, BigDecimal price, BigDecimal quantite , BigDecimal prixTotal,String categorie) {
		Commande commande = new Commande();
		commande.setCommandeId(commandeId);
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("Fichier invalide");
		}
		
		try {
			commande.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		commande.setName(name);
		commande.setDescription(description);
		commande.setPrice(price);
		commande.setQuantite(quantite);
		commande.setPrixTotal(quantite.multiply(price));
		commande.setCategorie(categorie);
		commandeRepository.save(commande);
		
	}

	

	@Override
	public void updateCommandeToDB(Long commandeId,Long produitId, MultipartFile file, String name, String description,
			BigDecimal price,BigDecimal quantite , BigDecimal prixTotal,String categorie) {
Commande commande = new Commande();
commande.setCommandeId(commandeId);
commande.setCommandeId(produitId);
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("Fichier invalide");
		}
		
		try {
			commande.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		commande.setName(name);
		commande.setDescription(description);
		commande.setPrice(price);
		commande.setCategorie(categorie);
		commandeRepository.save(commande);
		
	}
	
	@Override
	public void changeCommandeImage(Long commandeId, MultipartFile file) {
		Commande commande = new Commande();
			commande=commandeRepository.findById(commandeId).get();
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		if(filename.contains("..")) {
			System.out.println("fichier introuvable");
		}
		try {
		commande.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		}catch(IOException e) {e.printStackTrace();}
		
		commandeRepository.save(commande);
	}
	
	public void deleteCommandeById(long commandeId) {
			Commande commande = commandeRepository.findById(commandeId).get();
			commandeRepository.delete(commande);
		
	}

	
	
}
