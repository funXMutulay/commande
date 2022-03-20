package org.nioun.essentials.commande.controller;


import java.math.BigDecimal;
import java.util.HashMap;

import org.nioun.essentials.commande.ProduitProxy;
import org.nioun.essentials.commande.model.Commande;
import org.nioun.essentials.commande.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CommandeController {

	@Autowired
	ProduitProxy proxy;
	
	CommandeService commandeService;
	
	@GetMapping("/commande/name/{name}/description/{description}/quantite/{quantite}")
	public Commande returnCommandeValue(@PathVariable ("name") String name ,
			@PathVariable ("description") String description ,
			@PathVariable ("quantite") BigDecimal quantite ,ModelMap map) {
		
		HashMap<String , String> uriVariables = new HashMap<>();
		uriVariables.put("name", name);
		uriVariables.put("description", description);
		ResponseEntity<Commande> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8080/produit/name/{name}/description/{description}",
						Commande.class,
						uriVariables);
		
		Commande commande = responseEntity.getBody() ;
		
		
		return new Commande(commande.getProduitId(),
				name,description,quantite,
				commande.getPrice(),
				quantite.multiply(commande.getPrice()),
				commande.getEnv());
	
	
	} 

	@GetMapping("/commande-feign/name/{name}/description/{description}/quantite/{quantite}")
	public Commande recupererProduit(@PathVariable ("name") String name ,
			@PathVariable ("description") String description ,
			@PathVariable ("quantite") BigDecimal quantite , ModelMap map) {
		
		Commande commande = proxy.recupererProduit(name,description);
		
		
	/*	Long 	produitId=commande.getProduitId();
		commande.setProduitId(produitId);
		
		commande.setName(name);
		commande.setDescription(description);
		commande.setQuantite(quantite);
		
		BigDecimal price= commande.getPrice();
		commande.setPrice(price);
		
		BigDecimal prixTotal=quantite.multiply(commande.getPrice());
		commande.setPrixTotal(prixTotal);
		
		String env=commande.getEnv();
		commande.setEnv(env);
		*/
		commandeService.saveCommande(commande);
		
		
	/*	commandeService.saveCommande(
				);
		map.addAttribute("commande", commande);
		
	*/
		return new Commande(
				commande.getProduitId(),
				name,description,quantite,
				commande.getPrice(),
				quantite.multiply(commande.getPrice()),
				commande.getEnv()
				
				);
	} 
	
	@GetMapping("/commande/commandeId/{commandeId}")
	public Commande getCommandeById(@PathVariable ("commandeId") Long commandeId ) {
		Commande commande = commandeService.getCommande(commandeId);
		
		if(commande==null) {
			throw new RuntimeException ("Commande "+commandeId+"introuvable");
		}
		return commande;
		}

	
}
