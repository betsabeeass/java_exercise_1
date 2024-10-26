import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;
public class Quit implements Command {
    @Override
    public boolean run(Scanner scanner) {
        return true;
    }
    @Override
    public String name() {
        return "Quit";
    }
}

