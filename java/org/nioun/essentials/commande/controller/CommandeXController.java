package org.nioun.essentials.commande.controller;

import java.util.List;
import org.nioun.essentials.commande.model.Commande;
import org.nioun.essentials.commande.repository.CommandeRepository;
import org.nioun.essentials.commande.service.CommandeService;
import org.nioun.essentials.commande.util.EmailUtil;
import org.nioun.essentials.commande.util.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/commande")
public class CommandeXController {
	
	
	
		@Autowired
		CommandeService service;

		@Autowired
		CommandeRepository repository;

		@Autowired
		EmailUtil emailUtil;

		@Autowired
		ReportUtil reportUtil;


		@RequestMapping("/commande/creerCommande")
		public String creerCommande(ModelMap map) {
			Commande commande= new Commande();
			map.addAttribute(commande);
			return "ajouterCommande";
		}

		@RequestMapping("/saveCommande")
		public String saveCommande(@ModelAttribute("commande") Commande commande, ModelMap modelMap) {
			Commande commandeSaved = service.saveCommande(commande);
			String msg = "Commande saved with id: " + commandeSaved.getCommandeId();
			modelMap.addAttribute("msg", msg);
			 emailUtil.sendEmail("mmdukb@hotmail.com", "Commande Saved",
					"Commande Saved Successfully and about to return a response");

			return "ajouterCommande";
		}

		@RequestMapping("/commande/displayCommandes")
		public String displayCommandes(ModelMap modelMap) {
			List<Commande> commandes = service.getAllCommandes();
			modelMap.addAttribute("commandes", commandes);
			return "displayCommandes";
		}

		@RequestMapping("deleteCommande")
		public String deleteCommande(@RequestParam("commandeId") Long commandeId, ModelMap modelMap) {
			 // Commande commande = service.getCommande(commandeId);
			Commande commande = new Commande();
			commande.setCommandeId(commandeId);
			service.deleteCommande(commande);
			List<Commande> commandes = service.getAllCommandes();
			modelMap.addAttribute("commandes", commandes);
			return "displayCommandes";
		}

		@RequestMapping("/showUpdate")
		public String showUpdate(@RequestParam("commandeId") Long commandeId, ModelMap modelMap) {
			Commande commande = service.getCommande(commandeId);
			modelMap.addAttribute("commande", commande);
			return "updateCommande";
		}

		@RequestMapping("/updateCommande")
		public String updateCommande(@ModelAttribute("commande") Commande commande, ModelMap modelMap) {
			service.updateCommande(commande);
			List<Commande> commandes = service.getAllCommandes();
			modelMap.addAttribute("commandes", commandes);
			return "afficherCommandes";
		}


	}