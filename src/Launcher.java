import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("Welcome! Type a command:");

        Scanner scanner = new Scanner(System.in);
        List<Command> commands = Arrays.asList (
                new Quit(),
                new Fibo(),
                new Freq(),
                new Predict()
        );

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            Command command = commands.stream()
                    .filter(cmd -> cmd.name().equalsIgnoreCase(input))
                    .findFirst()
                    .orElse(null);

            if (command == null) {
                System.out.println("Unknown command");
                continue;
            }

            boolean shouldExit = command.run(scanner);

            if (shouldExit) {
                break;
            }
        }

        scanner.close();
    }
}

