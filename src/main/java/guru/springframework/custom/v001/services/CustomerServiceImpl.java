package guru.springframework.custom.v001.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import guru.springframework.custom.v001.controllers.CustomerController;
import guru.springframework.custom.v001.domains.Customer;
import guru.springframework.custom.v001.exceptions.ResourceNotFoundException;
import guru.springframework.custom.v001.mappers.CustomerMapper;
import guru.springframework.custom.v001.models.CustomerDto;
import guru.springframework.custom.v001.models.OrderDto;
import guru.springframework.custom.v001.repositories.CustomerRepository;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    
    private final CustomerRepository customerRepository;
	
	@Override
	public List<CustomerDto> recupererListeDesClients() {
		List<CustomerDto> listeCustomerDto = customerRepository.findAll()
				.stream()
				.map(customerMapper::customerToCustomerDto)
				.collect(Collectors.toList());
		return listeCustomerDto;
	}

	@Override
	public CustomerDto recupererClientParId(Long id) {
		Customer clientTrouve = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvee - id : " + id));
		return customerMapper.customerToCustomerDto(clientTrouve);
	}

	@Override
	public CustomerDto creerClient(CustomerDto customerDto) {
		Customer customer = customerMapper.customerDtoToCustomer(customerDto);
		return sauvegarderEtRetournerClientDto(customer);
	}

	@Override
	public CustomerDto majClientParId(Long id, CustomerDto customerDto) {
		Customer clientTrouve = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvee - id : " + id));
		clientTrouve.setId(id);
        return sauvegarderEtRetournerClientDto(clientTrouve);
	}

	@Override
	public CustomerDto remplacerClientParId(Long id, CustomerDto customerDto) {
		return customerRepository.findById(id).map(customer -> {
			String customerDtoFirstName = customerDto.getFirstName();
			if (StringUtils.isNotBlank(customerDtoFirstName)) {
				customer.setFirstName(customerDtoFirstName);
			}
			String customerDtoLastName = customerDto.getLastName();
			if (StringUtils.isNotBlank(customerDtoLastName)) {
				customer.setFirstName(customerDtoLastName);
			}
			
	        return sauvegarderEtRetournerClientDto(customer);
		}).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void supprimerClientParId(Long id) {
		Customer clientTrouve = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvee - id : " + id));
		customerRepository.delete(clientTrouve);
	}

	@Override
	public OrderDto recupererCommandeClientParId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDto creerCommandeClientParId(OrderDto orderDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
    private CustomerDto sauvegarderEtRetournerClientDto(Customer customer) {
        Customer clientPourSauvegarde = customerRepository.save(customer);
        CustomerDto clientSauvegarde = customerMapper.customerToCustomerDto(clientPourSauvegarde);
        clientSauvegarde.setCustomerUrl(recupererUrlClient(clientPourSauvegarde.getId()));
        return clientSauvegarde;
    }
    
    private String recupererUrlClient(Long id) {
        return CustomerController.FULL_URL + "/" + id;
    }

}
