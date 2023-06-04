package guru.springframework.custom.v001.services;

import java.util.List;

import guru.springframework.custom.v001.models.CustomerDto;
import guru.springframework.custom.v001.models.OrderDto;

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
	
	// TODO A VERIFIER
	List<CustomerDto> recupererListeDesClients();
	CustomerDto creerClient();
	void supprimerClientParId(Long id);
	CustomerDto recupererClientParId(Long id);
	CustomerDto majClientParId(Long id);
	CustomerDto remplacerClientParId(Long id);
	OrderDto recupererCommandeClientParId(Long id);
	OrderDto creerCommandeClientParId(Long id);
}
