package guru.springframework.custom.v001.services;

import java.util.List;

import guru.springframework.custom.v001.models.CategoryDto;

public interface CategoryService {

	List<CategoryDto> recupererListeDesCategories();
	CategoryDto recupererCategorieParId(Long id);
}
