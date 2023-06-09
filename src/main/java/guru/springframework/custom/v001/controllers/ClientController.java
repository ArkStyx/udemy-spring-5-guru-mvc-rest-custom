package guru.springframework.custom.v001.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.custom.ApiConnectionUtilities;
import guru.springframework.custom.v001.services.ClientService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(ClientController.FULL_URL)
public class ClientController {

	public static final String FULL_URL = ApiConnectionUtilities.BASE_URL_API_V1 + "customers";
	
	private final ClientService customerService;
}
