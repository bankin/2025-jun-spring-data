import java.util.Scanner;

public class InjectionMain {

    public static void main(String[] args) {
        String statement = "SELECT * FROM users WHERE username = '%s' AND password = '%s'";
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();

        System.out.printf(statement, username, password);
    }
}
