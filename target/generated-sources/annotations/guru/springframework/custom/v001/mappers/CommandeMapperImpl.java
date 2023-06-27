package guru.springframework.custom.v001.mappers;

import guru.springframework.custom.v001.domains.Commande;
import guru.springframework.custom.v001.models.CommandeDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-21T23:29:27+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class CommandeMapperImpl implements CommandeMapper {

    @Override
    public CommandeDto commandeVersCommandeDto(Commande commande) {
        if ( commande == null ) {
            return null;
        }

        CommandeDto commandeDto = new CommandeDto();

        commandeDto.setId( commande.getId() );
        commandeDto.setNumeroDeCommande( commande.getNumeroDeCommande() );

        return commandeDto;
    }

    @Override
    public Commande commandeDtoVersCommande(CommandeDto commandeDto) {
        if ( commandeDto == null ) {
            return null;
        }

        Commande commande = new Commande();

        commande.setId( commandeDto.getId() );
        commande.setNumeroDeCommande( commandeDto.getNumeroDeCommande() );

        return commande;
    }
}
