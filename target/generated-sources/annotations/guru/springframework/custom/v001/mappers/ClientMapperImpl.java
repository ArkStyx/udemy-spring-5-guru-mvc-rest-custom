package guru.springframework.custom.v001.mappers;

import guru.springframework.custom.v001.domains.Client;
import guru.springframework.custom.v001.models.ClientDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-21T23:29:27+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto clientVersClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId( client.getId() );
        clientDto.setNomDeFamille( client.getNomDeFamille() );
        clientDto.setPrenom( client.getPrenom() );

        return clientDto;
    }

    @Override
    public Client clientDtoVersClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDto.getId() );
        client.setNomDeFamille( clientDto.getNomDeFamille() );
        client.setPrenom( clientDto.getPrenom() );

        return client;
    }
}
