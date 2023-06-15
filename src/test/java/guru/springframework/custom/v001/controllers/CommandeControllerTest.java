package guru.springframework.custom.v001.controllers;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.custom.v001.models.ArticleDto;
import guru.springframework.custom.v001.models.CommandeDto;
import guru.springframework.custom.v001.services.CommandeService;

public class CommandeControllerTest {

	private static final String API_V1_FULL_URL = "/api/v1/orders";
	
	private static final Long ID_01 = 1L;
	private static final Long ID_02 = 2L;
	
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
