package guru.springframework.custom.v001.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.custom.ApiConnectionUtilities;
import guru.springframework.custom.v001.models.ClientDto;
import guru.springframework.custom.v001.models.ClientListeDto;
import guru.springframework.custom.v001.models.CommandeDto;
import guru.springframework.custom.v001.services.ClientService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(ClientController.FULL_URL)
public class ClientController {

	public static final String FULL_URL = ApiConnectionUtilities.BASE_URL_API_V1 + "customers";
	
	private final ClientService customerService;
	
	
	/*
	TODO A SUPPRIMER
	
	GET /customers/							Lists all the customers
	POST /customers/						Create a customer
	DELETE /customers/{id}					Delete a customer
	GET /customers/{id}						Get a customer by id
	PATCH /customers/{id}					Update a customer
	PUT /customers/{id}						Replace a customer by new data
	GET /customers/{id}/orders/				Get the orders of a customer
	POST /customers/{id}/orders/			Create an order for a customer
	*/
	
	
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
	public ClientListeDto recupererListeDesClients() {
		return new ClientListeDto(customerService.recupererListeDesClients());
	}
	
	@GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
	public ClientDto recupererClientParId(@PathVariable Long id) {
		return customerService.recupererClientParId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ClientDto creerClient(ClientDto clientDto) {
		return customerService.creerClient(clientDto);
	}
	
	
	/*
	TODO A SUPPRIMER
	
	PATCH /customers/{id}					Update a customer
	PUT /customers/{id}						Replace a customer by new data
	
	GET /customers/{id}/orders/				Get the orders of a customer
	POST /customers/{id}/orders/			Create an order for a customer
	*/
	
	
	ClientDto majClientParId(Long id, ClientDto clientDto);
	
	ClientDto remplacerClientParId(Long id, ClientDto clientDto);
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void supprimerClientParId(@PathVariable Long id) {
		customerService.supprimerClientParId(id);
	}
	
	
	CommandeDto recupererCommandeClientParId(Long id);
	
	CommandeDto creerCommandeClientParId(CommandeDto commandeDto);
	
	
	

}
