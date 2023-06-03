package guru.springframework.custom.v001.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.custom.v001.domains.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
