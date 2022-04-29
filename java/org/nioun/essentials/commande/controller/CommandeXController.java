package org.nioun.essentials.commande.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.nioun.essentials.commande.model.Commande;
import org.nioun.essentials.commande.repository.CommandeRepository;
import org.nioun.essentials.commande.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CommandeXController {
	@Autowired
	CommandeService service;

	@Autowired
	CommandeRepository repository;
  
	
	@GetMapping("/commande/index" )
	public String index(Model model) {
	    model.addAttribute("commandes", repository.findAll());
	    return "index";
	}
	
	@GetMapping("/commande/creerPreCommande/produitId/{produitId}")
    public String creerPreCommande(@PathVariable("produitId") Long produitId , ModelMap map) {
		
		HashMap<String , Long> uriVariables = new HashMap<>();
		uriVariables.put("produitId", produitId);
		ResponseEntity<Commande> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8000/produit/produitId/{produitId}",
						Commande.class,
						uriVariables);
		
		Commande commande = responseEntity.getBody() ;
		service.saveCommande(commande);
		map.addAttribute("commande", commande);
		/*
		commande.setProduitId(commande.getProduitId());
				commande.getImage(),
				name,description,quantite,
				commande.getPrice(),
				quantite.multiply(commande.getPrice()),
				commande.getCategorie());
		*/
        return "ajouterCommande";
    }
	
	@GetMapping("/commande/creerCommande/produitId/{produitId}")
    public String creerCommande(@PathVariable("produitId") Long produitId , ModelMap map) {
		
		HashMap<String , Long> uriVariables = new HashMap<>();
		uriVariables.put("produitId", produitId);
		ResponseEntity<Commande> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8000/produit/produitId/{produitId}",
						Commande.class,
						uriVariables);
		
		Commande commande = responseEntity.getBody() ;
		service.saveCommande(commande);
		map.addAttribute("commande", commande);
		/*
		commande.setProduitId(commande.getProduitId());
				commande.getImage(),
				name,description,quantite,
				commande.getPrice(),
				quantite.multiply(commande.getPrice()),
				commande.getCategorie());
		*/
        return "ajouterPreCommande";
    }
	
	
	
	@GetMapping("/commande/creerCommande")
    public String creerCommande(Commande commande) {
        return "ajouterCommande";
    }
    
	 @PostMapping("/saveCommandeToDB")
	    public String saveCommandeToDB(@RequestParam("produitId") Long produitId ,
	    		@RequestParam("file") MultipartFile file ,@RequestParam("name") String name ,
	    		@RequestParam("description") String description ,@RequestParam("price") BigDecimal price,
	    		@RequestParam("quantite") BigDecimal quantite ,
	    		@RequestParam("prixTotal") BigDecimal prixTotal ,
	    		@RequestParam("categorie")  String categorie) {
	                
	        service.saveCommandeToDB(produitId,file, name, description, price,quantite,prixTotal, categorie);
	        return "redirect:/commande/creerCommande";
	    }

	
    @GetMapping("/showUpdate/{commandeId}")
    public String showUpdate(@PathVariable("commandeId") long commandeId, Model model) {
        Commande commande= repository.findById(commandeId)
          .orElseThrow(() -> new IllegalArgumentException("Invalid  commandeId:" + commandeId));
        
        model.addAttribute("commande", commande);
        return "updateCommande";
    }
    
    
    @PostMapping("/updateCommande/{commandeId}")
	public String updateCommande(@PathVariable("commandeId") long commandeId, Commande commande, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	commande.setCommandeId(commandeId);
	        return "updateCommande";
	    }
	        
	    service.saveCommande(commande);
	    return "redirect:/commande/index";
	}
	
    @PostMapping("/updateCommandeToDB")
    public String updateCommandeToDB(@RequestParam("commandeId") Long commandeId ,
    		@RequestParam("produitId") Long produitId,
    		@RequestParam("file") MultipartFile file ,
    		@RequestParam("name") String name ,
    		@RequestParam("description") String description ,
    		@RequestParam("price") BigDecimal price,
    		@RequestParam("quantite") BigDecimal quantite,
    		@RequestParam("prixTotal") BigDecimal prixTotal,
    		@RequestParam("categorie")  String categorie,
    		Model model) {
       
    	service.updateCommandeToDB(commandeId ,produitId, file , name, description, price,quantite, prixTotal ,categorie);
        model.addAttribute("commandes", repository.findAll());
        
        return "redirect:/commande/index";
    }
    
    @GetMapping("/delete/{commandeId}")
	public String deleteCommande(@PathVariable("commandeId") long commandeId, Model model) {
		
    	/*
    	Commande commande = repository.findById(commandeId)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user commandeId:" + commandeId));
	    repository.delete(commande);
	    */
    	
    	 service.deleteCommandeById(commandeId);
    	model.addAttribute("commandes" , repository.findAll());
	    return "redirect:/index";
	}

    
    @PostMapping("/changeCommandeImage")
    public String changeCommandeImage(@RequestParam("commandeId") Long commandeId,
    		@RequestParam("nfile") MultipartFile nfile)
    {
    	service.changeCommandeImage(commandeId, nfile);
    	return "redirect:/listProducts.html";
    }
	
}
