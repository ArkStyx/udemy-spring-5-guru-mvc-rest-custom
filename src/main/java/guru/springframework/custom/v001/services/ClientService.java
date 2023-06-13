package guru.springframework.custom.v001.services;

import java.util.List;

import guru.springframework.custom.v001.models.ClientDto;
import guru.springframework.custom.v001.models.CommandeDto;

public interface ClientService {

	List<ClientDto> recupererListeDesClients();
	
	ClientDto recupererClientParId(Long id);
	
	ClientDto creerClient(ClientDto clientDto);
	
	ClientDto majClientParId(Long id, ClientDto clientDto);
	
	ClientDto remplacerClientParId(Long id, ClientDto clientDto);
	
	void supprimerClientParId(Long id);
	
	CommandeDto recupererCommandeClientParId(Long id);
	
	CommandeDto creerCommandeClientParId(Long id, CommandeDto commandeDto);
}
