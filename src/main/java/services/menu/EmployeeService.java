package services.menu;

import domains.Account;
import domains.Customer;
import repositories.AccountRepository;
import repositories.impl.AccountRepositoryImpl;
import repositories.impl.CustomerRepositoryImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {

    private Customer customer = null;
    private CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    private long customerNationalCode = 0;
    private AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
    private Account account = null;

    private Customer customerNationalCode(){
        Scanner strIn = new Scanner(System.in);
        System.out.print("Please enter your national code name :");
        String customerNationalCodeStr = strIn.nextLine();
        String pattern = "^0+(?!$)";
        customerNationalCodeStr = customerNationalCodeStr.replaceAll(pattern, "");
        customerNationalCode = Long.parseLong(customerNationalCodeStr);
        customer = customerRepository.findById(customerNationalCode);
        return customer;
    }

    public void openNewAccount(){
        customer = customerNationalCode();
        if (customer == null) {
            defineNewCustomer();
        }
        newAccountDefiner();
    }
    private void defineNewCustomer() {
        Scanner strIn = new Scanner(System.in);
        Scanner longIn = new Scanner(System.in);
        System.err.println("### OPENING NEW ACCOUNT DIGITAL FORM ###\n");
        System.out.print("Please enter your first name :");
        String customerFirstName = strIn.nextLine();
        System.out.println();
        System.out.print("Please enter your last name :");
        String customerLastName = strIn.nextLine();
        System.out.println();
        System.out.print("Please enter your date of birth :");
        String customerDateOfBirthStr = strIn.nextLine();
        LocalDate customerDateOfBirth = LocalDate.parse(customerDateOfBirthStr);
        System.out.println();
        System.out.print("Please enter your phone number :");
        String customerPhoneNumberStr = strIn.nextLine();
        /*String pattern = "^0+(?!$)";
        customerPhoneNumberStr = customerPhoneNumberStr.replaceAll(pattern, "");
        long customerPhoneNumber = Long.parseLong(customerPhoneNumberStr);*/
        System.out.println();
        System.out.print("Enter the amount of money you want to deposit :");
        long firstMoney = longIn.nextLong();
        customer = new Customer(customerFirstName, customerLastName, customerNationalCode, customerDateOfBirth,
                customerPhoneNumberStr);
        customerRepository.save(customer);
    }

    private void newAccountDefiner(){
        Account account = new Account();
        customer.setAccounts((List<Account>) account);
        accountRepository.save(account);
    }

    private Account accountFinder(long accountNumber){
        Account account = accountRepository.findById(accountNumber);

        return account;
    }

    public void transferMoneyToAnotherAccount(){
        Scanner longIn = new Scanner(System.in);
        Scanner strIn = new Scanner(System.in);
        customer = customerNationalCode();
        System.out.print("Please enter the amount of money you want to transfer :");
        long money = longIn.nextLong();
        System.out.println("Please enter your account number :");
        Account customerAccount = accountFinder(longIn.nextLong());
        System.out.println("Please enter the account number :");
        long accountNumber = longIn.nextLong();
        account = accountFinder(accountNumber);
        System.out.println("Please enter the account's owner name :");
        String ownerName = strIn.nextLine();
        List<String> words = Arrays.asList(ownerName.split("\\s"));
        ownerName = words.get(0) + words.get(1);
        if((account.getCustomer().getFirstName() + account.getCustomer().getLastName()).equalsIgnoreCase(ownerName) &&
        customerAccount.getCustomer().getNationalCode() == customer.getNationalCode() &&
                customerAccount.getBalance() > money){
            account.setBalance(account.getBalance() + money);
            customerAccount.setBalance(customerAccount.getBalance() - money);
        }
    }

    public void depositMoney(){
        Scanner longIn = new Scanner(System.in);
        customer = customerNationalCode();
        System.out.print("Please enter the amount of money you want to deposit :");
        long money = longIn.nextLong();
        System.out.println("Please enter your account number :");
        account = accountFinder(longIn.nextLong());
        if (account != null) {
            account.setBalance(account.getBalance() + money);
        }
    }

    public void takeCash(){
        Scanner longIn = new Scanner(System.in);
        customer = customerNationalCode();
        System.out.print("Please enter the amount of money you want to take :");
        long money = longIn.nextLong();
        System.out.println("Please enter your account number :");
        account = accountFinder(longIn.nextLong());
        if (account != null && account.getBalance() > money) {
            account.setBalance(account.getBalance() - money);
        }
    }
}
