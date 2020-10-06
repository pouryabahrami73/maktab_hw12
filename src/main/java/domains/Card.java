package domains;

import base.domians.BaseEntity2;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.time.LocalDate;

public class Card extends BaseEntity2<Long> {

    private int cvv2;
    private LocalDate expireDate;
    private boolean isActive;
    private long cardNumber;
    private long password;
    @OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
    private Account account;

    public int getCvv2() {
        return cvv2;
    }

    public void setCvv2(int cvv2) {
        this.cvv2 = cvv2;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }
}
