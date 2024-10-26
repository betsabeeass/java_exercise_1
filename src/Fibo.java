import java.util.Scanner;
public class Fibo implements Command{
    @Override
    public String name() {
        return "Fibo";
    }
    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Enter number: ");
        int n = scanner.nextInt();
        int a = 0;
        int b = 1;
        int c = 0;
        if (n == 0)
            System.out.println("" + 0);
        if (n == 1)
            System.out.println("" + 1);
        for (int i = 1; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println("" + c);
        return false;
    }
}