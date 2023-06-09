package guru.springframework.custom.v001.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.custom.v001.domains.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
