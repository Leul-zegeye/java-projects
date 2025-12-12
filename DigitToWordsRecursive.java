import java.util.Scanner;

public class DigitToWordsRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number (0 to quit): ");
            int num = scanner.nextInt();
            if (num == 0) {
                System.out.println("Goodbye!");
                break;
            }
            displayAsWords(num);
            System.out.println();
        }
        scanner.close();
    }

    public static void displayAsWords(int n) {
        displayAsWords(n, true);
    }

    private static void displayAsWords(int n, boolean isFirstDigit) {
        if (n < 10) {
            // Base case prints the most significant remaining digit
            System.out.print((isFirstDigit ? "" : " ") + getWordFromDigit(n));
            return;
        }

        // Recurse toward the most significant digit to preserve internal zeros
        displayAsWords(n / 10, isFirstDigit);
        System.out.print(" " + getWordFromDigit(n % 10));
    }

    private static String getWordFromDigit(int d) {
        switch (d) {
            case 0: return "Zero";
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }
}
