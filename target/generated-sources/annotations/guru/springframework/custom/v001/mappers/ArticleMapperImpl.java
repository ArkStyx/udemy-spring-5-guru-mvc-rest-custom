package guru.springframework.custom.v001.mappers;

import guru.springframework.custom.v001.domains.Article;
import guru.springframework.custom.v001.models.ArticleDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-17T00:17:10+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ArticleMapperImpl implements ArticleMapper {

    @Override
    public List<ArticleDto> listeArticlesVersListeArticleDto(List<Article> listeArticles) {
        if ( listeArticles == null ) {
            return null;
        }

        List<ArticleDto> list = new ArrayList<ArticleDto>( listeArticles.size() );
        for ( Article article : listeArticles ) {
            list.add( articleVersArticleDto( article ) );
        }

        return list;
    }

    @Override
    public Article articleDtoVersArticle(ArticleDto articleDto) {
        if ( articleDto == null ) {
            return null;
        }

        Article article = new Article();

        article.setCodeBarre( articleDto.getCodeBarre() );
        article.setDescription( articleDto.getDescription() );
        article.setId( articleDto.getId() );

        return article;
    }

    @Override
    public ArticleDto articleVersArticleDto(Article article) {
        if ( article == null ) {
            return null;
        }

        ArticleDto articleDto = new ArticleDto();

        articleDto.setCodeBarre( article.getCodeBarre() );
        articleDto.setDescription( article.getDescription() );
        articleDto.setId( article.getId() );

        return articleDto;
    }
}
