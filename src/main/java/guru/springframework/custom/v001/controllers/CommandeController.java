package guru.springframework.custom.v001.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.custom.ApiConnectionUtilities;
import guru.springframework.custom.v001.models.ArticleDto;
import guru.springframework.custom.v001.models.ArticleListeDto;
import guru.springframework.custom.v001.models.CommandeDto;
import guru.springframework.custom.v001.models.CommandeListeDto;
import guru.springframework.custom.v001.services.CommandeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(CommandeController.FULL_URL)
public class CommandeController {
	
	public static final String FULL_URL = ApiConnectionUtilities.BASE_URL_API_V1 + "orders";
	
	private final CommandeService commandeService;

	@GetMapping
    @ResponseStatus(HttpStatus.OK)
	public CommandeListeDto recupererListeDesCommandes() {
		return new CommandeListeDto(commandeService.recupererListeDesCommandes());
	}
	
	@GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
	public CommandeDto recupererCommandeParId(Long idCommande) {
		return commandeService.recupererCommandeParId(idCommande);
	}
	
	@DeleteMapping()
    @ResponseStatus(HttpStatus.OK)
	public void supprimerCommandeParId(Long idCommande) {
		commandeService.supprimerCommandeParId(idCommande);
	}
	
	@PostMapping("{id}/actions/cancel")
    @ResponseStatus(HttpStatus.OK)
	public CommandeDto annulerCommandeParId(Long idCommande) {
		return commandeService.annulerCommandeParId(idCommande);
	}
	
	@PostMapping("{id}/actions/purchase")
    @ResponseStatus(HttpStatus.OK)
	public CommandeDto passerCommandeParId(Long idCommande) {
		return commandeService.passerCommandeParId(idCommande);
	}
	
	@GetMapping("{id}/items")
    @ResponseStatus(HttpStatus.OK)
	public ArticleListeDto recupererListeArticlesDansCommandeParId(Long idCommande) {
		return new ArticleListeDto(commandeService.recupererListeArticlesDansCommandeParId(idCommande));
	}
	
	@PostMapping("{id}/items")
    @ResponseStatus(HttpStatus.OK)
	public ArticleListeDto ajouterArticleDansCommandeParId(Long idCommande, ArticleDto articleDto) {
		return new ArticleListeDto(commandeService.ajouterArticleDansCommandeParId(idCommande, articleDto));
	}

	@DeleteMapping("{oid}/items/{iid}")
    @ResponseStatus(HttpStatus.OK)
	public void supprimerArticleDansCommandeParId(Long idCommande, Long idArticle) {
		commandeService.supprimerArticleDansCommandeParId(idCommande, idArticle);
	}
	
	@GetMapping("{oid}/items/{iid}")
    @ResponseStatus(HttpStatus.OK)
	public ArticleDto recupererArticleDansCommandeClientParId(Long idCommande, Long idArticle) {
		return commandeService.recupererArticleDansCommandeClientParId(idCommande, idArticle);
	}
	
}
