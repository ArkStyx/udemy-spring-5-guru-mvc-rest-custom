package guru.springframework.custom.v001.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import guru.springframework.custom.v001.domains.Category;
import guru.springframework.custom.v001.mappers.CategoryMapper;
import guru.springframework.custom.v001.models.CategoryDto;
import guru.springframework.custom.v001.repositories.CategoryRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    
    private final CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryDto> recupererListeDesCategories() {
		List<CategoryDto> listeCategoryDto = categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDto)
                .collect(Collectors.toList());
		return listeCategoryDto;
	}

	@Override
	public CategoryDto recupererCategorieParId(Long id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Categorie non trouvee - id : " + id));
		return categoryMapper.categoryToCategoryDto(category);
	}

}
