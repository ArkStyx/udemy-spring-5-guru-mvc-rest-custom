package guru.springframework.custom.v001.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import guru.springframework.custom.v001.models.ArticleDto;
import guru.springframework.custom.v001.models.ArticleListeDto;
import guru.springframework.custom.v001.models.CommandeDto;
import guru.springframework.custom.v001.models.CommandeListeDto;
import guru.springframework.custom.v001.services.CommandeService;

public class CommandeControllerTest {

	private static final String API_V1_FULL_URL = "/api/v1/orders";
	
	private static final Long ID_01 = 1L;
	private static final Long ID_02 = 2L;
	
	private static final String NUMERO_DE_COMMANDE_01 = "ABC_0123456789";
	private static final Long QUANTITE_ARTICLE_01 = 1L;
	private static final String CODE_BARRE_01 = "AB01CD02EF03";
	
	private static final String NUMERO_DE_COMMANDE_02 = "CDE_0123456789";
	private static final Long QUANTITE_ARTICLE_02 = 1L;
	private static final String CODE_BARRE_02 = "GH01IJ02KL03";
	
	// TODO FIXME 01
	
   	/* Mockito Standard - Given */
	/* Mockito Standard - When */
	/* Mockito Standard - Then */
	
	/* BDD - Given */
	/* BDD - When */
	/* BDD - Then */
	
	@Mock
	CommandeService commandeService;
	
	@InjectMocks
	CommandeController commandeController;

	MockMvc mockMvc;
	
    @BeforeEach
    public void setUp() throws Exception {
    	MockitoAnnotations.openMocks(this);
    	mockMvc = MockMvcBuilders.standaloneSetup(commandeController).build();
    }
    
    
	/*
	TODO FIXME CONTROLLER
	
	GET /orders/							Lists all the orders
	GET /orders/{id}						Get an order by id
	
	DELETE /orders/{id}						Delete an order
	POST /orders/{id}/actions/cancel		Cancel an order
	POST /orders/{id}/actions/purchase		Purchase an order
	
	GET /orders/{id}/items/					Get the items of an order
	POST /orders/{id}/items/				Add an item to an order
	DELETE /orders/{oid}/items/{iid}		Delete an item of an order
	GET /orders/{oid}/items/{iid}			Get an item of an order
	*/
    

    @Test
	public void recupererListeDesCommandes() throws Exception {
    	
       	/* Mockito Standard - Given */
    	CommandeDto commandeDto01 = new CommandeDto();
    	commandeDto01.setId(ID_01);
    	commandeDto01.setNumeroDeCommande(NUMERO_DE_COMMANDE_01);
    	commandeDto01.setQuantiteArticle(QUANTITE_ARTICLE_01);
    	commandeDto01.setCodeBarre(CODE_BARRE_01);
    	
    	CommandeDto commandeDto02 = new CommandeDto();
    	commandeDto02.setId(ID_02);
    	commandeDto02.setNumeroDeCommande(NUMERO_DE_COMMANDE_02);
    	commandeDto02.setQuantiteArticle(QUANTITE_ARTICLE_02);
    	commandeDto02.setCodeBarre(CODE_BARRE_02);
    	
    	List<CommandeDto> listeCommandeDto = new ArrayList<>();
    	listeCommandeDto.add(commandeDto01);
    	listeCommandeDto.add(commandeDto02);
    	
    	/* Mockito Standard - When */
    	Mockito.when(commandeService.recupererListeDesCommandes()).thenReturn(listeCommandeDto);
    	
    	/* Mockito Standard - Then */
    	mockMvc.perform(
				MockMvcRequestBuilders.get(API_V1_FULL_URL)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
			)
			.andExpect(status().isOk());
	
    	verify(commandeService, times(1)).recupererListeDesCommandes();
	}
    
    @Test
	public void recupererCommandeParId() {
       	/* Mockito Standard - Given */
    	/* Mockito Standard - When */
    	/* Mockito Standard - Then */
    	
    	
    	CommandeDto recupererCommandeParId(Long idCommande);
	}
	
    @Test
	public void supprimerCommandeParId() {
       	/* Mockito Standard - Given */
    	/* Mockito Standard - When */
    	/* Mockito Standard - Then */
		
    	
    	void supprimerCommandeParId(Long idCommande);
	}
	
    @Test
	public void annulerCommandeParId() {
       	/* Mockito Standard - Given */
    	/* Mockito Standard - When */
    	/* Mockito Standard - Then */
		
    	
    	CommandeDto annulerCommandeParId(Long idCommande);
	}

    @Test
	public void passerCommandeParId() {
       	/* Mockito Standard - Given */
    	/* Mockito Standard - When */
    	/* Mockito Standard - Then */
		
    	
    	CommandeDto passerCommandeParId(Long idCommande);
	}

    @Test
	public void recupererListeArticlesDansCommandeParId() {
       	/* Mockito Standard - Given */
    	/* Mockito Standard - When */
    	/* Mockito Standard - Then */
		

    	List<ArticleDto> recupererListeArticlesDansCommandeParId(Long idCommande);
	}

    @Test
	public void ajouterArticleDansCommandeParId() {
       	/* Mockito Standard - Given */
    	/* Mockito Standard - When */
    	/* Mockito Standard - Then */
		
    	
    	List<ArticleDto> ajouterArticleDansCommandeParId(Long idCommande, ArticleDto articleDto);
	}

    @Test
	public void supprimerArticleDansCommandeParId() {
       	/* Mockito Standard - Given */
    	/* Mockito Standard - When */
    	/* Mockito Standard - Then */
		
    	
    	void supprimerArticleDansCommandeParId(Long idCommande, Long idArticle);
	}

    @Test
	public void recupererArticleDansCommandeClientParId() {
       	/* Mockito Standard - Given */
    	/* Mockito Standard - When */
    	/* Mockito Standard - Then */
		   	
    	ArticleDto recupererArticleDansCommandeClientParId(Long idCommande, Long idArticle);
	}
    
}
