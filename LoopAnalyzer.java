import java.util.*;

public class LoopAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (n <= 0) {
            System.out.print("Enter a positive integer: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.next(); // Consume invalid token
            }
        }

        int sum = 0;
        System.out.println();
        for (int i = 1; i <= n; i++) {
            sum += i;
            System.out.println("i = " + i + ", sum = " + sum);
        }
        System.out.println("\nFinal Sum = " + sum + "\n");

        int i = 1;
        int sumWhile = 0;
        while (i <= n) {
            sumWhile += i;
            System.out.println("i = " + i + ", sum = " + sumWhile);
            i++;
        }
        System.out.println("\nFinal Sum = " + sumWhile);

        if (sum == sumWhile) {
    
        } else {
            System.out.println("Error: Sums computed by for and while loops are different!");
        }
    }
}

