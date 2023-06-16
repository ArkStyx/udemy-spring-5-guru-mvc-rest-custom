package guru.springframework.custom.v001.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import guru.springframework.custom.v001.domains.Article;
import guru.springframework.custom.v001.domains.Commande;
import guru.springframework.custom.v001.mappers.ArticleMapper;
import guru.springframework.custom.v001.mappers.CommandeMapper;
import guru.springframework.custom.v001.models.ArticleDto;
import guru.springframework.custom.v001.models.CommandeDto;
import guru.springframework.custom.v001.repositories.CommandeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommandeServiceImpl implements CommandeService {

    private final ArticleMapper articleMapper;
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
	public CommandeDto recupererCommandeParId(Long idCommande) {
		Commande commandeTrouvee = commandeRepository.findById(idCommande).orElseThrow(() -> new RuntimeException("Commande non trouvee - id : " + idCommande));
		return commandeMapper.commandeVersCommandeDto(commandeTrouvee);
	}

	@Override
	public void supprimerCommandeParId(Long idCommande) {
		Commande commandeTrouvee = commandeRepository.findById(idCommande).orElseThrow(() -> new RuntimeException("Commande non trouvee - id : " + idCommande));
		commandeRepository.delete(commandeTrouvee);
	}

	@Override
	public CommandeDto annulerCommandeParId(Long idCommande) {
		Commande commandeTrouvee = commandeRepository.findById(idCommande).orElseThrow(() -> new RuntimeException("Commande non trouvee - id : " + idCommande));
		commandeTrouvee.setDateHeureAnnulation(java.sql.Timestamp.valueOf(LocalDateTime.now()));
		return commandeMapper.commandeVersCommandeDto(commandeTrouvee);
	}

	@Override
	public CommandeDto passerCommandeParId(Long idCommande) {
		Commande commandeTrouvee = commandeRepository.findById(idCommande).orElseThrow(() -> new RuntimeException("Commande non trouvee - id : " + idCommande));
		commandeTrouvee.setDateHeureAchat(java.sql.Timestamp.valueOf(LocalDateTime.now()));
		return commandeMapper.commandeVersCommandeDto(commandeTrouvee);
	}

	@Override
	public List<ArticleDto> recupererListeArticlesDansCommandeParId(Long idCommande) {
		Commande commandeTrouvee = commandeRepository.findById(idCommande).orElseThrow(() -> new RuntimeException("Commande non trouvee - id : " + idCommande));
		return articleMapper.listeArticlesVersListeArticleDto(commandeTrouvee.getListeArticles());
	}

	@Override
	public List<ArticleDto> ajouterArticleDansCommandeParId(Long idCommande, ArticleDto articleDto) {
		Commande commandeTrouvee = commandeRepository.findById(idCommande).orElseThrow(() -> new RuntimeException("Commande non trouvee - id : " + idCommande));
		List<Article> listeArticles = commandeTrouvee.getListeArticles();
		listeArticles.add(articleMapper.articleDtoVersArticle(articleDto));
		return articleMapper.listeArticlesVersListeArticleDto(listeArticles);
	}

	@Override
	public void supprimerArticleDansCommandeParId(Long idCommande, Long idArticle) {
		Commande commandeTrouvee = commandeRepository.findById(idCommande).orElseThrow(() -> new RuntimeException("Commande non trouvee - id : " + idCommande));
		commandeTrouvee.getListeArticles().removeIf(article -> article.getId().equals(idArticle));
	}

	@Override
	public ArticleDto recupererArticleDansCommandeClientParId(Long idCommande, Long idArticle) {
		Commande commandeTrouvee = commandeRepository.findById(idCommande).orElseThrow(() -> new RuntimeException("Commande non trouvee - id : " + idCommande));
		Article articleRecherche = commandeTrouvee.getListeArticles()
				.stream()
				.filter(article -> article.getId().equals(idArticle))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Commande non trouvee - id : " + idCommande));
		return articleMapper.articleVersArticleDto(articleRecherche);
	}

}
