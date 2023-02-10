import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String[] s;

    public static void main(String[] args) throws IOException {
        s = br.readLine().split(":");

        int gcd = gcd(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

        System.out.printf("%d:%d", Integer.parseInt(s[0]) / gcd, Integer.parseInt(s[1]) / gcd);
    }

    static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
