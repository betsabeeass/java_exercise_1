import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
    public class Freq implements Command{
        @Override
        public String name() {
            return "Freq";
        }
        @Override
        public boolean run(Scanner scanner) {
            System.out.println("Quel est le chemin du fichier: ");
            Path filePath = Paths.get(scanner.nextLine());
            try {
                String content = Files.readString(filePath);
                Map<String, Long> wordCount = Arrays.stream(
                                content.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+"))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                String topWords = wordCount.entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                        .limit(3)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.joining(" "));
                System.out.println("" + topWords);
            } catch (Exception e) {
                System.out.println("Unreadable file");
            }
            return true;
        }
}
