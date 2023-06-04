package guru.springframework.custom.v001.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import guru.springframework.custom.v001.domains.Customer;
import guru.springframework.custom.v001.mappers.CustomerMapper;
import guru.springframework.custom.v001.models.CustomerDto;
import guru.springframework.custom.v001.models.OrderDto;
import guru.springframework.custom.v001.repositories.CustomerRepository;
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
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvee - id : " + id));
		return customerMapper.customerToCustomerDto(customer);
	}

	@Override
	public CustomerDto creerClient(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDto majClientParId(Long id, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDto remplacerClientParId(Long id, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerClientParId(Long id) {
		// TODO Auto-generated method stub
		
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

}
