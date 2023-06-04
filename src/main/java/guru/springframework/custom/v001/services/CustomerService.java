package guru.springframework.custom.v001.services;

import java.util.List;

import guru.springframework.custom.v001.controllers.Create;
import guru.springframework.custom.v001.controllers.Get;
import guru.springframework.custom.v001.controllers.Lists;
import guru.springframework.custom.v001.controllers.a;
import guru.springframework.custom.v001.controllers.customer;
import guru.springframework.custom.v001.controllers.id;
import guru.springframework.custom.v001.controllers.orders;
import guru.springframework.custom.v001.controllers.the;
import guru.springframework.custom.v001.models.CategoryDto;

public interface CustomerService {

	/*
	TODO A IMPLEMENTER
	GET /customers/							Lists all the customers
	POST /customers/						Create a customer
	DELETE /customers/{id}					Delete a customer
	GET /customers/{id}						Get a customer by id
	PATCH /customers/{id}					Update a customer
	PUT /customers/{id}						Replace a customer by new data
	GET /customers/{id}/orders/				Get the orders of a customer
	POST /customers/{id}/orders/			Create an order for a customer
	*/
	
	
	List<ClientDto> recupererListeDesClients();
	ClientDto creerClient();
	void supprimerClientParId(Long id);
	ClientDto recupererClientParId(Long id);
	ClientDto majClientParId(Long id);
	ClientDto remplacerClientParId(Long id);
	CommandeDto recupererCommandeClientParId(Long id);
	CommandeDto creerCommandeClientParId(Long id);
}
