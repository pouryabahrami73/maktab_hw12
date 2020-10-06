package services.menu;

import domains.Employee;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CustomerCommands {
    private AlternativeMaker<String> alternativeMaker = new AlternativeMaker<>();
    private Employee employee = null;
    Scanner scanner = new Scanner(System.in);
    public String customerOptionsInBank() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        List<String> customerOptionsInBank = Arrays.asList("Open new account", "Deposit money", "Take cash",
                "Transfer money to another account");
        String choice = alternativeMaker.AlternativeMaker(customerOptionsInBank);
        return choice;
    }

    public String customerOptionsInATM() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        List<String> customerOptionsInBank = Arrays.asList("Take cash",
                "Transfer money to another card", "See my balance", "Change card password");
        String choice = alternativeMaker.AlternativeMaker(customerOptionsInBank);
        return choice;
    }
}
