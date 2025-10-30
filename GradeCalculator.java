import java.util.*; 
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter test score: ");
        int score = scanner.nextInt();

        if (score < 0 || score > 100) {
            System.out.println("Invalid score.");
        } else if (score >= 90) {
            System.out.println("your grade is: A");
        } else if (score >= 80) {
            System.out.println("your grade is: B");
        } else if (score >= 70) {
            System.out.println("your grade is: C");
        } else if (score >= 60) {
            System.out.println("your grade is: D");
        } else {
            System.out.println("your grade is: F");
        }
    }
}
    
