import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static jdk.jfr.consumer.EventStream.openFile;

public class Launcher {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Java Programming");
        Scanner scanner = new Scanner(System.in);

        for (; ;) {
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            if (input.equals("fibo")) {

                System.out.println("Enter the number: ");
                int number = scanner.nextInt();
                System.out.println(fibonacci(number));

            }
            if (input.equals("freq")) {
                System.out.println("Quel est le chemin du fichier: ");
                Path filePath = Paths.get(scanner.nextLine());

                try {
                    String content = Files.readString(filePath);
                    String ThreeWord = findTopThreeWord(content);
                    System.out.println(" " +ThreeWord);


                } catch (Exception e) {
                    System.out.println("Unreadable file");

                }

            } else {
                System.out.println("Unknown command");
            }
        }
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static String findTopThreeWord(String content) {
        String[] words = content.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");
        Map<String, Long> wordCount = Arrays.stream(words).filter(word -> !word.isBlank()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return wordCount.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())).limit(3).map(Map.Entry::getKey).collect(Collectors.joining(" "));
    }
}






