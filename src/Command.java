import java.util.Scanner;

public interface Command {
    String name();
    boolean run(Scanner scanner);

    class Fibo implements Command{
        @Override
        public String name() {
            return "fibo";
        }

        @Override
        public boolean run(Scanner scanner) {
            System.out.println(fibonnacci(scanner.nextInt()));
            return false;
        }
        private int fibonnacci(int n) {
            if (n == 0)
                return 0;
            if (n == 1)
                return 1;
            else
                return fibonnacci(n - 1) + fibonnacci(n - 2);
        }
    }
}
