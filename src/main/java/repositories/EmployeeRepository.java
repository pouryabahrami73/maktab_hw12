package repositories;

import base.repositories.BaseRepository;
import domains.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends BaseRepository<Employee, Long> {
    Employee save(Employee e);

    Employee findById (Long id);
    Optional<Employee> findByTitle(String title);

    void deleteByTitle(String title);

    void deleteAll();

    List<Employee> findAll();
}
