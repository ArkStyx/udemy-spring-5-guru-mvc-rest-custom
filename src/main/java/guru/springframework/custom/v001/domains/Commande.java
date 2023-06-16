package guru.springframework.custom.v001.domains;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String numeroDeCommande;

	@ManyToOne
	private Client client;

	private Timestamp dateHeureAchat;
	
	private Timestamp dateHeureAnnulation;
	
	private List<Article> listeArticles;
}
