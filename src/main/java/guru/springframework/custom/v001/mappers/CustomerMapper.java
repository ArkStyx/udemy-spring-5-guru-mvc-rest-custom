package guru.springframework.custom.v001.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import guru.springframework.custom.v001.domains.Customer;
import guru.springframework.custom.v001.models.CustomerDto;

@Mapper
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	CustomerDto customerToCustomerDto(Customer customer);
}
