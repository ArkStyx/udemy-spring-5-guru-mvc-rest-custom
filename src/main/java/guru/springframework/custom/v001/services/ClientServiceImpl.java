package guru.springframework.custom.v001.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import guru.springframework.custom.v001.controllers.ClientController;
import guru.springframework.custom.v001.domains.Client;
import guru.springframework.custom.v001.domains.Commande;
import guru.springframework.custom.v001.exceptions.ResourceNotFoundException;
import guru.springframework.custom.v001.mappers.ClientMapper;
import guru.springframework.custom.v001.mappers.CommandeMapper;
import guru.springframework.custom.v001.models.ClientDto;
import guru.springframework.custom.v001.models.CommandeDto;
import guru.springframework.custom.v001.repositories.ClientRepository;
import guru.springframework.custom.v001.repositories.CommandeRepository;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper;
    private final CommandeMapper commandeMapper;
    
    private final ClientRepository clientRepository;
    private final CommandeRepository commandeRepository;
	
	@Override
	public List<ClientDto> recupererListeDesClients() {
		List<ClientDto> listeClientDto = clientRepository.findAll()
				.stream()
				.map(clientMapper::clientVersClientDto)
				.collect(Collectors.toList());
		return listeClientDto;
	}

	@Override
	public ClientDto recupererClientParId(Long id) {
		Client clientTrouve = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvee - id : " + id));
		return clientMapper.clientVersClientDto(clientTrouve);
	}

	@Override
	public ClientDto creerClient(ClientDto clientDto) {
		Client client = clientMapper.clientDtoVersClient(clientDto);
		return sauvegarderEtRetournerClientDto(client);
	}

	@Override
	public ClientDto majClientParId(Long id, ClientDto clientDto) {
		Client clientTrouve = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvee - id : " + id));
		clientTrouve.setId(id);
        return sauvegarderEtRetournerClientDto(clientTrouve);
	}

	@Override
	public ClientDto remplacerClientParId(Long id, ClientDto clientDto) {
		return clientRepository.findById(id).map(customer -> {
			String customerDtoPrenom = clientDto.getPrenom();
			if (StringUtils.isNotBlank(customerDtoPrenom)) {
				customer.setPrenom(customerDtoPrenom);
			}
			String customerDtoNomDeFamille = clientDto.getNomDeFamille();
			if (StringUtils.isNotBlank(customerDtoNomDeFamille)) {
				customer.setNomDeFamille(customerDtoNomDeFamille);
			}
			
	        return sauvegarderEtRetournerClientDto(customer);
		}).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void supprimerClientParId(Long id) {
		Client clientTrouve = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouve - id : " + id));
		clientRepository.delete(clientTrouve);
	}

	@Override
	public CommandeDto recupererCommandeClientParId(Long id) {
		Commande commandeTrouvee = commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande non trouvee - id : " + id));
		return commandeMapper.commandeVersCommandeDto(commandeTrouvee);
	}

	@Override
	public CommandeDto creerCommandeClientParId(Long id, CommandeDto commandeDto) {
		Commande commande = commandeMapper.commandeDtoVersCommande(commandeDto);
    	Commande commandePourSauvegarde = commandeRepository.save(commande);
    	
    	Client clientPourSauvegarde = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvee - id : " + id));
    	clientPourSauvegarde.getListeDeCommandes().add(commandePourSauvegarde);
    	clientRepository.save(clientPourSauvegarde);
    	
        CommandeDto commandeSauvegardee = commandeMapper.commandeVersCommandeDto(commandePourSauvegarde);
        return commandeSauvegardee;
	}

    private ClientDto sauvegarderEtRetournerClientDto(Client client) {
        Client clientPourSauvegarde = clientRepository.save(client);
        ClientDto clientSauvegarde = clientMapper.clientVersClientDto(clientPourSauvegarde);
        clientSauvegarde.setUrlClient(recupererUrlClient(clientPourSauvegarde.getId()));
        return clientSauvegarde;
    }
    
    private String recupererUrlClient(Long id) {
        return ClientController.FULL_URL + "/" + id;
    }

}
