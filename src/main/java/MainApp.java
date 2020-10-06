import services.menu.ATMService;
import services.menu.CustomerCommands;
import services.menu.EmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            ClassNotFoundException, IllegalAccessException {
        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("### PLEASE CHOOSE ONE OF THE FOLLOWINGS ###\n");
        System.out.println("1. In bank\n2. On an ATM");
        int choice = scanner.nextInt();
        CustomerCommands customerCommands = new CustomerCommands();
        if(choice == 1){
            String methodName = customerCommands.customerOptionsInBank();
            EmployeeService.class.getMethod(methodName);
        }else if (choice == 2){
            String methodName = customerCommands.customerOptionsInATM();
            ATMService atmService = new ATMService();
            atmService.getClass().getMethod(methodName);
            System.err.println("ATM");
        }
    }
}
