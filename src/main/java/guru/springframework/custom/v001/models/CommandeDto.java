package guru.springframework.custom.v001.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommandeDto {

    private Long id;
	private String numeroDeCommande;
    private Long quantiteArticle;
    private String codeBarre;
}
