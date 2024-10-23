import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome to Java Programming");
        Scanner scanner = new Scanner(System.in);

        for (; ;){

            String input = scanner.nextLine();
            if (input.equals("quit"))
                break;
            else{

                System.out.println("Unknown command");
            }

        }
    }

}



