package guru.springframework.custom.v001.services;

import java.util.List;

import guru.springframework.custom.v001.models.ArticleDto;
import guru.springframework.custom.v001.models.CommandeDto;

public interface CommandeService {

	List<CommandeDto> recupererListeDesCommandes();
	
	CommandeDto recupererCommandeParId(Long id);
	
	void supprimerCommandeParId(Long id);
	
	CommandeDto annulerCommandeParId(Long id);
	
	CommandeDto acheterCommandeParId(Long id);

	ArticleDto recupererArticleDansCommandeParId(Long id);
	
	ArticleDto ajouterArticleDansCommandeParId(Long id);
	
	void supprimerArticleDansCommandeParId(Long id);
	
	ArticleDto recupererArticleDansCommandeClientParId(Long idCommande, Long idArticle);

	
	
	/*
	TODO FIXME
	
	GET /orders/							Lists all the orders
	GET /orders/{id}						Get an order by id
	
	DELETE /orders/{id}						Delete an order
	POST /orders/{id}/actions/cancel		Cancel an order
	POST /orders/{id}/actions/purchase		Purchase an order
	
	GET /orders/{id}/items/					Get the items of an order
	POST /orders/{id}/items/				Add an item to an order
	DELETE /orders/{oid}/items/{iid}		Delete an item of an order
	GET /orders/{oid}/items/{iid}			Get an item of an order
	*/
	
}
