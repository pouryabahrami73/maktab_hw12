package domains;


import base.domians.BaseEntity2;

import javax.persistence.*;

public class Account extends BaseEntity2<Long> {

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn()
    private Card card;
    @Column
    private String passWord;
    @Column
    private long balance;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_customer")
    private Customer customer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_branch")
    private BankBranch bankBranch;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}