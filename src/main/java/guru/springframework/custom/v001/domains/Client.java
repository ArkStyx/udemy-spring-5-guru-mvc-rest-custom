package guru.springframework.custom.v001.domains;

import java.time.LocalDate;
import java.util.LinkedList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Client {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String prenom;
    private String NomDeFamille;
    private LocalDate dateDeNaissance;
    
    
	// TODO A SUPPRIMER -----------------------------------------------------------------------------------------------------------------------------
	// TODO A SUPPRIMER -----------------------------------------------------------------------------------------------------------------------------
	// TODO A SUPPRIMER -----------------------------------------------------------------------------------------------------------------------------
    @OneToMany
    private LinkedList<Commande> listeDeCommandes;
	// TODO A SUPPRIMER -----------------------------------------------------------------------------------------------------------------------------
	// TODO A SUPPRIMER -----------------------------------------------------------------------------------------------------------------------------
	// TODO A SUPPRIMER -----------------------------------------------------------------------------------------------------------------------------
}
