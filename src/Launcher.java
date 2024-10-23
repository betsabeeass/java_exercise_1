import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome to Java Programming");
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            if (input.equals("fibo")) {

                System.out.println("Enter the number: ");
                int number = scanner.nextInt();
                System.out.println(fibonacci(number));

            }
            else {
                System.out.println("Unknown command");
            }
        }
    }
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}






