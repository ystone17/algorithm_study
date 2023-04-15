import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static boolean[] prime = new boolean[10000001];
    static int n;

    public static void main(String[] args) throws IOException {
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) continue;
            prime[i] = true;

            for (int j = i * 2; j < prime.length; j += i) {
                prime[j] = false;
            }
        }

        n = Integer.parseInt(br.readLine());

        int primeNumber = 2;

        while (n != 1) {
            while (n % primeNumber == 0) {
                n /= primeNumber;
                sb.append(primeNumber).append("\n");
            }

            for (int i = primeNumber + 1; i < prime.length; i++) {
                if (prime[primeNumber]) {
                    primeNumber = i;
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
