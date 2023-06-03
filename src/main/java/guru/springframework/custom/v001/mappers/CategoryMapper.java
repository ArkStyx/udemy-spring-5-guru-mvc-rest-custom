package guru.springframework.custom.v001.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import guru.springframework.custom.v001.domains.Category;
import guru.springframework.custom.v001.models.CategoryDto;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    
    CategoryDto categoryToCategoryDto(Category category);
}
