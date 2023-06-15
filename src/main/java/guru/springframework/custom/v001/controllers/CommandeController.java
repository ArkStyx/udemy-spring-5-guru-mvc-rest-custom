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
	public CommandeDto recupererCommandeParId(Long id) {
		return commandeService.recupererCommandeParId(id);
	}
	
	@DeleteMapping()
    @ResponseStatus(HttpStatus.OK)
	public void supprimerCommandeParId(Long id) {
		commandeService.supprimerCommandeParId(id);
	}
	
	@PostMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
	public CommandeDto annulerCommandeParId(Long id) {
		return commandeService.annulerCommandeParId(id);
	}
	
	@PostMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
	public CommandeDto acheterCommandeParId(Long id) {
		return commandeService.acheterCommandeParId(id);
	}
	
	@GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
	public ArticleDto recupererArticleDansCommandeParId(Long id) {
		return commandeService.recupererArticleDansCommandeParId(id);
	}
	
	@PostMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
	public ArticleDto ajouterArticleDansCommandeParId(Long id) {
		return commandeService.ajouterArticleDansCommandeParId(id);
	}

	@DeleteMapping("{idCommande, idArticle}")
    @ResponseStatus(HttpStatus.OK)
	public void supprimerArticleDansCommandeParId(Long idCommande, Long idArticle) {
		commandeService.supprimerArticleDansCommandeParId(idCommande, idArticle);
	}
	
	@GetMapping("{idCommande, idArticle}")
    @ResponseStatus(HttpStatus.OK)
	public ArticleDto recupererArticleDansCommandeClientParId(Long idCommande, Long idArticle) {
		return commandeService.recupererArticleDansCommandeClientParId(idCommande, idArticle);
	}
	
}
