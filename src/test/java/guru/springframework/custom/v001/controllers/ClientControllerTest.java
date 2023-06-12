package guru.springframework.custom.v001.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.custom.v001.models.ClientDto;
import guru.springframework.custom.v001.services.ClientService;

public class ClientControllerTest {

	
	private static final String API_V1_FULL_URL = "/api/v1/customers";
	
	private static final Long ID_01 = 1L;
	private static final Long ID_02 = 2L;
	
	private static final String NOM_DE_FAMILLE_01 = "Dupont";
	private static final String NOM_DE_FAMILLE_02 = "Dupuis";
	
	private static final String PRENOM_DE_FAMILLE_01 = "Martin";
	private static final String PRENOM_DE_FAMILLE_02 = "Arnaud";
	
	private static final String URL_CLIENT_01 = "dupont_001";
	private static final String URL_CLIENT_02 = "dupuis_001";
	
	@Mock
	ClientService clientService;
	
	@InjectMocks
	ClientController clientController;
	
	MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
	}
	
	
	// TODO FIXME
	
   	/* Mockito Standard - Given */
	/* Mockito Standard - When */
	/* Mockito Standard - Then */
	
	/* BDD - Given */
	/* BDD - When */
	/* BDD - Then */

	/*
	GET /customers/							Lists all the customers
	POST /customers/						Create a customer
	DELETE /customers/{id}					Delete a customer
	GET /customers/{id}						Get a customer by id
	PATCH /customers/{id}					Update a customer
	PUT /customers/{id}						Replace a customer by new data
	GET /customers/{id}/orders/				Get the orders of a customer
	POST /customers/{id}/orders/			Create an order for a customer
	*/
	
	
    @Test
    public void getCustomers() throws Exception {
    	
    	/* Mockito Standard - Given */
    	ClientDto clientDto01 = new ClientDto();
    	clientDto01.setId(ID_01);
    	clientDto01.setNomDeFamille(NOM_DE_FAMILLE_01);
    	clientDto01.setPrenom(PRENOM_DE_FAMILLE_01);
    	clientDto01.setUrlClient(URL_CLIENT_01);
    	
    	ClientDto clientDto02 = new ClientDto();
    	clientDto02.setId(ID_02);
    	clientDto02.setNomDeFamille(NOM_DE_FAMILLE_02);
    	clientDto02.setPrenom(PRENOM_DE_FAMILLE_02);
    	clientDto02.setUrlClient(URL_CLIENT_02);
    	
    	List<ClientDto> listeClientDto = new ArrayList<>();
    	listeClientDto.add(clientDto01);
    	listeClientDto.add(clientDto02);
    	
    	/* Mockito Standard - When */
    	Mockito.when(clientService.recupererListeDesClients()).thenReturn(listeClientDto);
    	
    	/* Mockito Standard - Then */
    	mockMvc.perform(
    				MockMvcRequestBuilders.get(API_V1_FULL_URL)
    				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
    			)
    			.andExpect(status().isOk());
    	
    	verify(clientService, times(1)).recupererListeDesClients();
    }
    
	@Test
	public void getCustomerById() throws Exception {
	  	
    	/* Mockito Standard - Given */
    	ClientDto clientDto01 = new ClientDto();
    	clientDto01.setId(ID_01);
    	clientDto01.setNomDeFamille(NOM_DE_FAMILLE_01);
    	clientDto01.setPrenom(PRENOM_DE_FAMILLE_01);
    	clientDto01.setUrlClient(URL_CLIENT_01);
		
    	/* Mockito Standard - When */
    	Mockito.when(clientService.recupererClientParId(anyLong())).thenReturn(clientDto01);
    	
    	/* Mockito Standard - Then */
    	mockMvc.perform(
    				MockMvcRequestBuilders.get(API_V1_FULL_URL + "/1")
    				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
    			)
    			.andExpect(status().isOk());
		  	
    	verify(clientService, times(1)).recupererClientParId(anyLong());
	}

    @Test
    public void createCustomer() throws Exception {
    	
    	/* Mockito Standard - Given */
    	ClientDto clientDto01 = new ClientDto();
    	clientDto01.setId(ID_01);
    	clientDto01.setNomDeFamille(NOM_DE_FAMILLE_01);
    	clientDto01.setPrenom(PRENOM_DE_FAMILLE_01);
    	clientDto01.setUrlClient(URL_CLIENT_01);
    	
    	/* Mockito Standard - When */
    	Mockito.when(clientService.creerClient(any())).thenReturn(clientDto01);
    	
    	/* Mockito Standard - Then */
    	mockMvc.perform(
    				MockMvcRequestBuilders.post(API_V1_FULL_URL)
    				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
    			)
    			.andExpect(status().isOk());
    	
    	verify(clientService, times(1)).creerClient(any());
    }
    
    
	
	/*
	DELETE /customers/{id}					Delete a customer
	PATCH /customers/{id}					Update a customer
	PUT /customers/{id}						Replace a customer by new data
	GET /customers/{id}/orders/				Get the orders of a customer
	POST /customers/{id}/orders/			Create an order for a customer
	*/
	

	
    // TODO
//    @Test
//    public void updateCustomer() throws Exception {
//    	
//    	clientService.majClientParId(null, null)
//    	
//		PATCH /customers/{id}					Update a customer
//    }
//    
    // TODO
//    @Test
//    public void replaceCustomer() throws Exception {
//    	
//    	clientService.remplacerClientParId(null, null)
//    	
//    	PUT /customers/{id}						Replace a customer by new data
//    }
//    
    
    // TODO
    @Test
    public void deleteCustomer() throws Exception {
    	
    	/* Mockito Standard - Given */
    	
     	/* Mockito Standard - When */
    	
    	/* Mockito Standard - Then */
    	mockMvc.perform(
    				MockMvcRequestBuilders.delete(API_V1_FULL_URL + "/1")
    				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
    			)
    			.andExpect(status().isOk());
    	
    	verify(clientService, times(1)).supprimerClientParId(anyLong());
    }
    
    
    
    // TODO
//    @Test
//    public void getOrderByCustomerId() throws Exception {
//    	
//    	clientService.recupererCommandeClientParId(null)
//    	
//    	GET /customers/{id}/orders/				Get the orders of a customer
//    }
//    
    // TODO
//    @Test
//    public void createOrderByCustomerId() throws Exception {
//    	
//    	clientService.creerCommandeClientParId(null)
//    	
//    	POST /customers/{id}/orders/			Create an order for a customer
//    }
    
}
