package guru.springframework.custom.v001.services;

import java.util.List;

import guru.springframework.custom.v001.models.ArticleDto;
import guru.springframework.custom.v001.models.CommandeDto;

public interface CommandeService {

	List<CommandeDto> recupererListeDesCommandes();
	
	CommandeDto recupererCommandeParId(Long idCommande);
	
	void supprimerCommandeParId(Long idCommande);
	
	CommandeDto annulerCommandeParId(Long idCommande);
	
	CommandeDto passerCommandeParId(Long idCommande);

	List<ArticleDto> recupererListeArticlesDansCommandeParId(Long idCommande);
	
	List<ArticleDto> ajouterArticleDansCommandeParId(Long idCommande, ArticleDto articleDto);
	
	void supprimerArticleDansCommandeParId(Long idCommande, Long idArticle);
	
	ArticleDto recupererArticleDansCommandeClientParId(Long idCommande, Long idArticle);

}
