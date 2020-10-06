package repositories;

import base.repositories.BaseRepository;
import domains.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends BaseRepository<Customer, Long> {
    Customer save(Customer e);

    Customer findById(Long id);

    Optional<Customer> findByTitle(String title);

    void deleteByTitle(String title);

    void deleteAll();

    List<Customer> findAll();
}
