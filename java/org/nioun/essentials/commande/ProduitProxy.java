package org.nioun.essentials.commande;


import org.nioun.essentials.commande.model.Commande;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="produit" , url = "localhost:8000")
@FeignClient(name="produit" , url="localhost:8000")
public interface ProduitProxy {
	
	@GetMapping("/produit/name/{name}/description/{description}")
	 public Commande recupererProduit(@PathVariable ("name") String name ,
			 @PathVariable ("description") String description);
	
	@GetMapping("/produit/produitId/{produitId}")
	public Commande getProduitById(@PathVariable ("produitId") Long produitId);

}
