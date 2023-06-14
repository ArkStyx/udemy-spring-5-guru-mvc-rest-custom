package guru.springframework.custom.v001.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import guru.springframework.custom.v001.domains.Categorie;
import guru.springframework.custom.v001.mappers.CategorieMapper;
import guru.springframework.custom.v001.models.CategorieDto;
import guru.springframework.custom.v001.repositories.CategorieRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategorieServiceImpl implements CategorieService {

    private final CategorieMapper categorieMapper;
    
    private final CategorieRepository categorieRepository;

	@Override
	public List<CategorieDto> recupererListeDesCategories() {
		List<CategorieDto> listeCategoryDto = categorieRepository.findAll()
                .stream()
                .map(categorieMapper::categorieVersCategorieDto)
                .collect(Collectors.toList());
		return listeCategoryDto;
	}

	@Override
	public CategorieDto recupererCategorieParId(Long id) {
		Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Categorie non trouvee - id : " + id));
		return categorieMapper.categorieVersCategorieDto(categorie);
	}

}
