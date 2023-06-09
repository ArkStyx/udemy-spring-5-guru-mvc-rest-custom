package guru.springframework.custom.v001.services;

import java.util.List;

import guru.springframework.custom.v001.models.CategorieDto;

public interface CategorieService {

	List<CategorieDto> recupererListeDesCategories();
	CategorieDto recupererCategorieParId(Long id);
}
