package guru.springframework.custom.v001.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.custom.ApiConnectionUtilities;
import guru.springframework.custom.v001.models.CategorieDto;
import guru.springframework.custom.v001.models.CategorieListeDto;
import guru.springframework.custom.v001.services.CategorieService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(CategorieController.FULL_URL)
public class CategorieController {

	public static final String FULL_URL = ApiConnectionUtilities.BASE_URL_API_V1 + "categories";
	
	private final CategorieService categoryService;
	
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
	public CategorieListeDto recupererListeDesCategories() {
		return new CategorieListeDto(categoryService.recupererListeDesCategories());
	}
	
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
	public CategorieDto recupererCategorieParId(@PathVariable Long id) {
		return categoryService.recupererCategorieParId(id);
	}
}
