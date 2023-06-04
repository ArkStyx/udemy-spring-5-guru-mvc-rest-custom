package guru.springframework.custom.v001.services;

import java.util.List;

import guru.springframework.custom.v001.models.CustomerDto;
import guru.springframework.custom.v001.models.OrderDto;

public interface CustomerService {

	List<CustomerDto> recupererListeDesClients();
	
	CustomerDto recupererClientParId(Long id);
	
	CustomerDto creerClient(CustomerDto customerDto);
	
	CustomerDto majClientParId(Long id, CustomerDto customerDto);
	
	CustomerDto remplacerClientParId(Long id, CustomerDto customerDto);
	
	void supprimerClientParId(Long id);
	
	OrderDto recupererCommandeClientParId(Long id);
	
	OrderDto creerCommandeClientParId(OrderDto orderDto);
}
