package guru.springframework.custom.v001.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.custom.v001.domains.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
