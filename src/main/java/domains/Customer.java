package domains;

import base.domians.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Customer extends BaseEntity<Long> {

    public Customer(String firstName, String lastName, long nationalCode, LocalDate birthday
            /*,String address*/, String phoneNumber) {
        super(nationalCode);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
//        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(unique = true)
    private long nationalCode;
    @Column
    private LocalDate birthday;
    @Column
    private String address;
    @Column
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_account")
    private List<Account> accounts;
    @ManyToMany
    private BankBranch bankBranch;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
