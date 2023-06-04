package guru.springframework.custom.v001.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.custom.v001.domains.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
