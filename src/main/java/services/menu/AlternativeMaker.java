package services.menu;



import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AlternativeMaker<E> {

    public String AlternativeMaker (List<E> objects) throws NoSuchMethodException {
        long choice = 0;
        /*long lastAlt = up + 1;*/
        String alternatives = "";

        int i = 0;
        for(E object : objects) {
            ++i;
            String alt = String.format("%d. " + object + "\n", i);
            alternatives += alt;
        }
        do {
            System.out.println("Please choose one of the alternatives :");
            System.out.println(alternatives);
            try {
                Scanner in = new Scanner(System.in);
                choice = in.nextLong();
                new AlternativesBound(choice, 1, objects.size());
                in.close();
            } catch (InputMismatchException exception) {
                System.err.println("sorry please try again");
                continue;
            } catch (BigInputException ex) {
                System.err.println("give a number between " + 1 + " to " + objects.size());
                continue;
            }
            break;
        } while (true);
        /*if (choice == lastAlt) {
            choice = 0;
        }*/
        List<String> wordsOfChoice = Arrays.asList(((String) objects.get((int) choice - 1)).split("\\s"));
        String trueChoice = wordsOfChoice.get(0).toLowerCase();
        wordsOfChoice = wordsOfChoice.subList(1, wordsOfChoice.size());
        for (String word : wordsOfChoice){
            String upperCase = word.toUpperCase();
            String newWord = word.replace(word.charAt(0), upperCase.charAt(0));
            trueChoice = trueChoice + newWord;
        }
        return trueChoice;
    }

    public long AlternativeMaker (List<E> objects, String methodName) throws NoSuchMethodException {
        long choice = 0;
        /*long lastAlt = up + 1;*/
        String alternatives = "";

        int i = 0;
        for(E object : objects) {
            ++i;
            String alt = String.format("%d. " + object.getClass().getMethod(methodName) + "\n", i);
            alternatives += alt;
        }
        do {
            System.out.println("Please choose one of the alternatives :");
            System.out.println(alternatives);
            try {
                Scanner in = new Scanner(System.in);
                choice = in.nextLong();
                new AlternativesBound(choice, 1, objects.size());
                in.close();
            } catch (InputMismatchException exception) {
                System.err.println("sorry please try again");
                continue;
            } catch (BigInputException ex) {
                System.err.println("give a number between " + 1 + " to " + objects.size());
                continue;
            }
            break;
        } while (true);
        /*if (choice == lastAlt) {
            choice = 0;
        }*/
        return choice;
    }

    public static class BigInputException extends Exception {
        public BigInputException() {
            super("YOUR CHOICE IS OUT OF THE TRUE BOUND!!!");
        }
    }

    private static class AlternativesBound {
        public AlternativesBound(long choice, long low, long up) throws BigInputException {
            if (choice > up || choice < low) {
                throw new BigInputException();
            }
        }
    }
}
