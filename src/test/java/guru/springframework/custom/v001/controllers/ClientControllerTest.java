package guru.springframework.custom.v001.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ClientControllerTest {

	// TODO FIXME
	
   	/* Mockito Standard - Given */
	/* Mockito Standard - When */
	/* Mockito Standard - Then */
	
	/* BDD - Given */
	/* BDD - When */
	/* BDD - Then */

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
	
	GET /customers/							Lists all the customers
	POST /customers/						Create a customer
	DELETE /customers/{id}					Delete a customer
	GET /customers/{id}						Get a customer by id
	PATCH /customers/{id}					Update a customer
	PUT /customers/{id}						Replace a customer by new data
	GET /customers/{id}/orders/				Get the orders of a customer
	POST /customers/{id}/orders/			Create an order for a customer
}
