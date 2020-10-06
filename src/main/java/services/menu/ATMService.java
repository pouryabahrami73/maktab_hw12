package services.menu;

import domains.Account;
import domains.Card;
import domains.Customer;
import repositories.CardRepository;
import repositories.impl.AccountRepositoryImpl;
import repositories.impl.CardRepositoryImpl;
import repositories.impl.CustomerRepositoryImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ATMService {
    private Customer customer = null;
    private CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    private long customerNationalCode = 0;
    private AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
    private Account account = null;
    private Card card = null;
    private CardRepositoryImpl cardRepository = new CardRepositoryImpl();

    private Card cardValidation() {
        Scanner longIn = new Scanner(System.in);
        System.out.print("Please enter your card number :");
        long cardNumber = longIn.nextLong();
//        String pattern = "^0+(?!$)";
//        customerNationalCodeStr = customerNationalCodeStr.replaceAll(pattern, "");
        card = cardRepository.findById(cardNumber);
        if(card != null && card.getExpireDate().isAfter(LocalDate.now())) {
            System.out.print("Please enter your password :");
            long password = longIn.nextLong();
            if (card.getPassword() != password) {
                card = null;
            }
        }
        account = card.getAccount();
        return card;
    }

    public void takeCash() {
        cardValidation();
        if (card != null) {
            Scanner longIn = new Scanner(System.in);
            System.out.print("Please enter the amount of money you want to take :");
            long money = longIn.nextLong();
            account = card.getAccount();
            if (account != null && account.getBalance() > money) {
                account.setBalance(account.getBalance() - money);
                accountRepository.save(account);
            }else {
                System.err.println("### SORRY YOUR BALANCE IS NOT ENOUGH ###");
            }
        }
    }

    public void seeMyBalance(){
        cardValidation();
        if (card != null) {
            account = card.getAccount();
            if (account != null) {
                System.out.println("Your balance is " + account.getBalance() + " tomans");
                account.setBalance(account.getBalance() - 113);
                accountRepository.save(account);
            }
        }
    }

    public void transferMoneyToAnotherAccount(){
        Scanner longIn = new Scanner(System.in);
        Scanner strIn = new Scanner(System.in);
        cardValidation();
        System.out.print("Please enter the amount of money you want to transfer :");
        long money = longIn.nextLong();
        System.out.println("Please enter the destination card number :");
        long cardNumber = longIn.nextLong();
        Card destCard = null;
        destCard = cardRepository.findById(cardNumber);
        if(destCard != null &&
                account.getBalance() > money){
            account.setBalance(account.getBalance() - money - 500L);
            destCard.getAccount().setBalance(destCard.getAccount().getBalance() + money);
        }
        accountRepository.save(account);
        accountRepository.save(destCard.getAccount());
    }

    public void changeCardPassword(){
        cardValidation();
        Scanner longIn = new Scanner(System.in);
        System.out.println("Please enter your new password :");
        long newPassword = longIn.nextLong();
        card.setPassword(newPassword);
        cardRepository.save(card);
    }
}
