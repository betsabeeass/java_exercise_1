import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Freq implements Command {
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Entre le nom du fichier: ");
        String input = scanner.nextLine();
        Path filePath = Paths.get(input);

        try {
            String content = Files.readString(filePath);
            String ThreeWord = findThreeWord(content);
            System.out.println(" " + ThreeWord);


        } catch (Exception e) {
            System.out.println("Unreadable file");

        }
        return false;
    }
    private static String findThreeWord(String content) {
            String[] words = content.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");
            Map<String, Long> wordCount = Arrays.stream(words).filter(word -> !word.isBlank()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            return wordCount.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())).limit(3).map(Map.Entry::getKey).collect(Collectors.joining(" "));
        };
}
