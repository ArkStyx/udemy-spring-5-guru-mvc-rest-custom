package guru.springframework.custom.v001.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import guru.springframework.custom.v001.domains.Categorie;
import guru.springframework.custom.v001.domains.Commande;
import guru.springframework.custom.v001.mappers.CommandeMapper;
import guru.springframework.custom.v001.models.ArticleDto;
import guru.springframework.custom.v001.models.ClientDto;
import guru.springframework.custom.v001.models.CommandeDto;
import guru.springframework.custom.v001.repositories.CommandeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommandeServiceImpl implements CommandeService {

    private final CommandeMapper commandeMapper;
    
    private final CommandeRepository commandeRepository;
	
	@Override
	public List<CommandeDto> recupererListeDesCommandes() {
		List<CommandeDto> listeCommandeDto = commandeRepository.findAll()
				.stream()
				.map(commandeMapper::commandeVersCommandeDto)
				.collect(Collectors.toList());
		return listeCommandeDto;
	}

	@Override
	public CommandeDto recupererCommandeParId(Long id) {
		Commande commandeTrouvee = commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande non trouvee - id : " + id));
		return commandeMapper.commandeVersCommandeDto(commandeTrouvee);
	}

	@Override
	public void supprimerCommandeParId(Long id) {
		Commande commandeTrouvee = commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande non trouvee - id : " + id));
		commandeRepository.delete(commandeTrouvee);
	}

	@Override
	public CommandeDto annulerCommandeParId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandeDto acheterCommandeParId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDto recupererArticleDansCommandeParId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDto ajouterArticleDansCommandeParId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerArticleDansCommandeParId(Long idCommande, Long idArticle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArticleDto recupererArticleDansCommandeClientParId(Long idCommande, Long idArticle) {
		// TODO Auto-generated method stub
		return null;
	}

}
