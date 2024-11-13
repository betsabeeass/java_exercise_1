import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Predict implements Command {
    @Override
    public String name() {
        return "predict";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.print("Entrez le chemin du fichier pour apprendre le lexique : ");
        String filePath = scanner.nextLine();
        Map<String, String> predictions = learnLexicon(filePath);

        if (predictions == null) return false;

        System.out.print("Entrez un mot de départ : ");
        String word = scanner.nextLine();

        if (!predictions.containsKey(word)) {
            System.out.println("Le mot n\'existe pas dans le texte analysé.");
            return false;
        }

        StringBuilder sentence = new StringBuilder(word);
        for (int i = 0; i < 19; i++) {
            String nextWord = predictions.get(word);
            if (nextWord == null) break;
            sentence.append(" ").append(nextWord);
            word = nextWord;
        }

        System.out.println("Phrase prédite : " + sentence);
        return false;
    }

    private Map<String, String> learnLexicon(String filePath) {
        try {
            Path path = Paths.get(filePath);
            String content = Files.readString(path).toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", " ");
            String[] words = content.split("\\s+");
            Map<String, Map<String, Long>> wordPairs = new HashMap<>();

            for (int i = 0; i < words.length - 1; i++) {
                String currentWord = words[i];
                String nextWord = words[i + 1];
                if (currentWord.isBlank() || nextWord.isBlank()) continue;

                wordPairs
                        .computeIfAbsent(currentWord, k -> new HashMap<>())
                        .merge(nextWord, 1L, Long::sum);
            }

            return wordPairs.entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> e.getValue().entrySet().stream()
                                    .max(Map.Entry.comparingByValue())
                                    .map(Map.Entry::getKey)
                                    .orElse(null)
                    ));
        } catch (IOException e) {
            System.out.println("Unreadable file: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            return null;
        }
    }
}