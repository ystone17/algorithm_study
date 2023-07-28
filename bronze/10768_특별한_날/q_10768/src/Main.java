import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());

        if (month < 2) {
            System.out.println("Before");
            return;
        }

        if (month > 2) {
            System.out.println("After");
            return;
        }

        if (day < 18) {
            System.out.println("Before");
            return;
        }

        if (day > 18) {
            System.out.println("After");
            return;
        }

        System.out.println("Special");
    }
}
