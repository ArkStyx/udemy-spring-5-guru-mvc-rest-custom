package guru.springframework.custom.v001.mappers;

import guru.springframework.custom.v001.domains.Categorie;
import guru.springframework.custom.v001.models.CategorieDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-21T23:29:27+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class CategorieMapperImpl implements CategorieMapper {

    @Override
    public CategorieDto categorieVersCategorieDto(Categorie categorie) {
        if ( categorie == null ) {
            return null;
        }

        CategorieDto categorieDto = new CategorieDto();

        categorieDto.setId( categorie.getId() );

        return categorieDto;
    }
}
