package guru.springframework.custom.v001.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.custom.ApiConnectionUtilities;
import guru.springframework.custom.v001.services.CustomerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(CustomerController.FULL_URL)
public class CustomerController {

	public static final String FULL_URL = ApiConnectionUtilities.BASE_URL_API_V1 + "customers";
	
	private final CustomerService customerService;
}
