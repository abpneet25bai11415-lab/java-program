import java.util.Scanner;

public class TypingSpeedTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String sentence = "Java is a powerful programming language.";

        System.out.println("===== TYPING SPEED TEST =====");
        System.out.println();
        System.out.println("Type the following sentence:");
        System.out.println();
        System.out.println(sentence);
        System.out.println();

        System.out.println("Press ENTER when you are ready...");
        sc.nextLine();
        
        long startTime = System.currentTimeMillis();

        System.out.println("Start typing:");
        String typedText = sc.nextLine();

        long endTime = System.currentTimeMillis();

        double timeTaken = (endTime - startTime) / 1000.0;

        int words = typedText.trim().isEmpty()
                ? 0
                : typedText.trim().split("\\s+").length;

        double wpm = (words / timeTaken) * 60;

        int correctCharacters = 0;
        int minLength = Math.min(sentence.length(), typedText.length());

        for (int i = 0; i < minLength; i++) {
            if (sentence.charAt(i) == typedText.charAt(i)) {
                correctCharacters++;
            }
        }

        double accuracy =
                ((double) correctCharacters / sentence.length()) * 100;

        // Display results
        System.out.println();
        System.out.println("===== RESULTS =====");
        System.out.printf("Time Taken : %.2f seconds%n", timeTaken);
        System.out.printf("Typing Speed: %.2f WPM%n", wpm);
        System.out.printf("Accuracy    : %.2f%%%n", accuracy);

        sc.close();
    }
}

