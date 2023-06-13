package guru.springframework.custom.v001.domains;

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
	
	// TODO A SUPPRIMER -----------------------------------------------------------------------------------------------------------------------------
	// TODO A SUPPRIMER -----------------------------------------------------------------------------------------------------------------------------
	// TODO A SUPPRIMER -----------------------------------------------------------------------------------------------------------------------------
	@ManyToOne
	private Client client;
	// TODO A SUPPRIMER -----------------------------------------------------------------------------------------------------------------------------
	// TODO A SUPPRIMER -----------------------------------------------------------------------------------------------------------------------------
	// TODO A SUPPRIMER -----------------------------------------------------------------------------------------------------------------------------
	
}
