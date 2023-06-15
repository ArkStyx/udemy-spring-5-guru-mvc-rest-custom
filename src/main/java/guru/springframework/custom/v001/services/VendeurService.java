package guru.springframework.custom.v001.services;

import java.util.List;

import guru.springframework.custom.v001.models.ArticleDto;
import guru.springframework.custom.v001.models.VendeurDto;

public interface VendeurService {

	List<VendeurDto> recupererListeDesVendeurs();
	
	VendeurDto recupererVendeurParId(Long id);
	
	VendeurDto creerVendeur(VendeurDto vendeurDto);
	
	ArticleDto majVendeurParId(Long id, VendeurDto vendeurDto);
	
	ArticleDto remplacerVendeurParId(Long id, VendeurDto vendeurDto);
	
	void supprimerVendeurParId(Long id);
	
	ArticleDto recupererArticleParVendeurId(Long id);
	
	ArticleDto ajouterArticleParVendeurId(Long id, ArticleDto articleDto);
	

	
	/*
	TODO FIXME CONTROLLER
	
	GET /vendors/						Lists all the vendors
	GET /vendors/{id}					Get a vendor by id
	
	POST /vendors/						Create a vendor
	DELETE /vendors/{id}				Delete a vendor
	PATCH /vendors/{id}					Update a vendor
	PUT /vendors/{id}					Replace a vendor by new data
	
	GET /vendors/{id}/products/			Get the products of a vendor
	POST /vendors/{id}/products/		Add a product to a vendor
	*/
	
}
