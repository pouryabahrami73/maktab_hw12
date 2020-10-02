package services.menu;

import domains.Article;
import domains.Employee;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CustomerCommands {
    private AlternativeMaker<String> alternativeMaker = null;
    private List<String> adminAccessibleFields = Arrays.asList("Title", "Brief", "Content", "PublishedDate",
            "Writes", "CreateDate", "Published");
    private Employee admin = null;
    Scanner scanner = new Scanner(System.in);
    public void editFields() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        ArticleCommands articleCommands = new ArticleCommands();
        Article article = articleCommands.chooseOneArticle(admin);
        long choice = alternativeMaker.AlternativeMaker(adminAccessibleFields, "toString");
        System.out.println("Please write your new " + adminAccessibleFields.get((int) choice - 1) + " :");
        articleCommands.editArticle(article, adminAccessibleFields.get((int) choice - 1), scanner.nextLine());
    }
}
