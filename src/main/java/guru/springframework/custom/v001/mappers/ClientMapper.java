package guru.springframework.custom.v001.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import guru.springframework.custom.v001.domains.Client;
import guru.springframework.custom.v001.models.ClientDto;

@Mapper
public interface ClientMapper {

	ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
	
	ClientDto clientVersClientDto(Client client);
	
	Client clientDtoVersClient(ClientDto clientDto);
}
