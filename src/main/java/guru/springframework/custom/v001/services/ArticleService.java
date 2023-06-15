package guru.springframework.custom.v001.services;

import java.util.List;

import guru.springframework.custom.v001.models.ArticleDto;
import guru.springframework.custom.v001.models.PhotoArticleDto;

public interface ArticleService {

	List<ArticleDto> recupererListeDesArticles();
	
	ArticleDto recupererArticleParId(Long id);
	
	ArticleDto creerArticle(ArticleDto articleDto);
	
	ArticleDto majArticleParId(Long id, ArticleDto articleDto);
	
	ArticleDto remplacerArticleParId(Long id, ArticleDto articleDto);
	
	void supprimerArticleParId(Long id);
	
	PhotoArticleDto recupererPhotoArticleParId(Long id);
	
	PhotoArticleDto creerOuRemplacerPhotoArticleParId(Long id, PhotoArticleDto photoArticleDto);
	
	
	
	/*
	TODO FIXME CONTROLLER
	
	GET /products/					Lists all the products
	GET /products/{id}				Get a product by id
	
	POST /products/					Create a product
	PATCH /products/{id}			Update one or more properties of a product
	PUT /products/{id}				Replace a product by new data
	DELETE /products/{id}			Delete a product
	
	GET /products/{id}/photo		Get a photo of a product
	PUT /products/{id}/photo		Add or update the photo of a product
	 */

}
