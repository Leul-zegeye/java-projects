import java.util.*;
public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String[] words = sentence.trim().split("\\s+");
        int wordCount = (sentence.trim().isEmpty()) ? 0 : words.length;

        System.out.println("Number of words: " + wordCount);

    }
}
