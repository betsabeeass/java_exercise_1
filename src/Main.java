import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        List<Command> commands = new ArrayList<>();
        commands.add(new Fibo());
        commands.add(new Freq());
        commands.add(new Quit());

        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            //System.out.print("Enter command: ");
            String command = scanner.nextLine().trim();
            Command command1 = commands.stream()
                    .filter(cmd -> cmd.name().equalsIgnoreCase(command))
                    .findFirst()
                    .orElse(null);

            if (command1 == null) {
                System.out.println("Unknown command");
            } else {
                if (command1.run(scanner)) {
                    break;

                }
            }
        }
    }
}
