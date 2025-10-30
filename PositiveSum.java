import java.util.*;
public class PositiveSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (true) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            if (num < 0) {
                break;
            }
            sum += num;
        }
        System.out.println("Sum = " + sum);
    }
 }
