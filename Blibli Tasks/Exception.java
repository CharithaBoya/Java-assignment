import java.util.Scanner;

class MoreThanOneDigitException extends Exception {
    public MoreThanOneDigitException(String message) {
        super(message);
    }
}

public class Main {

    public static void checkNumber(int number) throws MoreThanOneDigitException {
        if (number < 10 && number > -10) {
            System.out.println("The number is a single-digit number.");
        } else {
            throw new MoreThanOneDigitException("The number has more than one digit!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Enter a number: ");
        int number = scanner.nextInt(); 

        try {
            checkNumber(number);
        } catch (MoreThanOneDigitException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        scanner.close(); 
    }
}
