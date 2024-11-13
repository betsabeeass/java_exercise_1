import java.util.Scanner;

public class Fibo implements Command{
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.print("Enter an integer n for Fibonacci calculation: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        int result = fibonacci(n);
        System.out.println(result);
        return false;
    }
    private int fibonacci(int n) {
        if(n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
        }
}
