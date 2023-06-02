package guru.springframework.custom.v001.mappers;

import java.util.Locale.Category;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import guru.springframework.custom.v001.models.CategoryDto;

@Mapper
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	
	CategoryDto categoryToCategoryDTO(Category category);
}
