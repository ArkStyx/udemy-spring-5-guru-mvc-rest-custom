package guru.springframework.custom.v001.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.custom.ApiConnectionUtilities;
import guru.springframework.custom.v001.models.CategoryDto;
import guru.springframework.custom.v001.models.CategoryListDto;
import guru.springframework.custom.v001.services.CategoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(CategoryController.FULL_URL)
public class CategoryController {

	public static final String FULL_URL = ApiConnectionUtilities.BASE_URL_API_V1 + "categories";
	
	private final CategoryService categoryService;
	
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
	public CategoryListDto recupererListeDesCategories() {
		return new CategoryListDto(categoryService.recupererListeDesCategories());
	}
	
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
	public CategoryDto recupererCategorieParId(@PathVariable Long id) {
		return categoryService.recupererCategorieParId(id);
	}
}
