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
	
	void supprimerArticleDansCommandeParId(Long idCommande, Long idArticle);
	
	ArticleDto recupererArticleDansCommandeClientParId(Long idCommande, Long idArticle);

}
