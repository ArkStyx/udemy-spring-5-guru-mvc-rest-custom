package guru.springframework.custom.v001.services;

import java.util.List;

import org.springframework.stereotype.Service;

import guru.springframework.custom.v001.mappers.CategoryMapper;
import guru.springframework.custom.v001.models.CategoryDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    
    // TODO A IMPLEMENTER
//    private final CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryDto> recupererListeDesCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto recupererCategorieParId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
