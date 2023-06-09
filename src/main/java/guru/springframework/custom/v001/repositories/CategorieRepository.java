package guru.springframework.custom.v001.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.custom.v001.domains.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
