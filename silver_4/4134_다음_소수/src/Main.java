import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int cnt = Integer.parseInt(br.readLine());

        while (cnt-- > 0) {
            long n = Long.parseLong(br.readLine());
            for (long i = n; i <= 5000000000L; i++) {
                if (isPrime(i)) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    private static boolean isPrime(long n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
