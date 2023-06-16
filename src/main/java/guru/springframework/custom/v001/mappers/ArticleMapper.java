package guru.springframework.custom.v001.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import guru.springframework.custom.v001.domains.Article;
import guru.springframework.custom.v001.models.ArticleDto;

@Mapper
public interface ArticleMapper {

	ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);
	
	List<ArticleDto> listeArticlesVersListeArticleDto(List<Article> listeArticles);

	Article articleDtoVersArticle(ArticleDto articleDto);

	ArticleDto articleVersArticleDto(Article article);
}
