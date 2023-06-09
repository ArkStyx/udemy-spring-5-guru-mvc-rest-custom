package guru.springframework.custom.v001.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import guru.springframework.custom.v001.domains.Categorie;
import guru.springframework.custom.v001.models.CategorieDto;

@Mapper
public interface CategorieMapper {

    CategorieMapper INSTANCE = Mappers.getMapper(CategorieMapper.class);
    
    CategorieDto categorieVersCategorieDto(Categorie categorie);
}
