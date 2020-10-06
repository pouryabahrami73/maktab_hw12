package domains;

import base.domians.BaseEntity2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class BankBranch extends BaseEntity2<Long> {
    @ManyToMany
    private List<Customer> customers;
    @OneToMany
    @JoinColumn(name = "fk_bank_branch")
    private List<Employee> employees;
    @Column
    private String name;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
