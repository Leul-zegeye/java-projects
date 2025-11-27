import java.util.Scanner;

class DivideByZeroException extends Exception {
    public DivideByZeroException() {
        super("DivideByZeroException: denominator is zero.");
    }
    public DivideByZeroException(String message) {
        super(message);
    }
}
public class DivideByZeroExceptionDemo {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            if (denominator == 0) {
                throw new DivideByZeroException();
            }

            double result = (double) numerator / denominator;
            System.out.println("Result: " + result);
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nProgram finished.");
    }
}
