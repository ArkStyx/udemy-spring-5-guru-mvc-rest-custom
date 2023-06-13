package guru.springframework.custom.v001.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@PatchMapping("{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ClientDto majClientParId(Long id, ClientDto clientDto) {
		return customerService.majClientParId(id, clientDto);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClientDto remplacerClientParId(Long id, ClientDto clientDto) {
		return customerService.remplacerClientParId(id, clientDto);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void supprimerClientParId(@PathVariable Long id) {
		customerService.supprimerClientParId(id);
	}

	@GetMapping("{id}/orders")
	@ResponseStatus(HttpStatus.OK)
	public CommandeDto recupererCommandeClientParId(Long id) {
		return customerService.recupererCommandeClientParId(id);
	}
	
	@PostMapping("{id}/orders")
	@ResponseStatus(HttpStatus.OK)
	public CommandeDto creerCommandeClientParId(Long id, CommandeDto commandeDto) {
		return customerService.creerCommandeClientParId(id, commandeDto);
	}

}
