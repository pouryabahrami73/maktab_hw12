package repositories.impl;

import base.repositories.impl.BaseRepositoryImpl;
import domains.Customer;
import repositories.CustomerRepository;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> implements CustomerRepository {
    @Override
    public Customer findById(Long id) {
        super.entityManager.getTransaction().begin();
        Customer customer = null;
        customer = super.entityManager.find(Customer.class, id);
        return customer;
    }
}
