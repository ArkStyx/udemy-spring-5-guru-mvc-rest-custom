package guru.springframework.custom.v001.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import guru.springframework.custom.v001.domains.Commande;
import guru.springframework.custom.v001.models.CommandeDto;

@Mapper
public interface CommandeMapper {

	CommandeMapper INSTANCE = Mappers.getMapper(CommandeMapper.class);
	
	CommandeDto commandeVersCommandeDto(Commande commande);
	
	Commande commandeDtoVersCommande(CommandeDto commandeDto);
}
