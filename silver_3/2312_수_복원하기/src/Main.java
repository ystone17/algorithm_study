import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;
    static int[] primeNumber = new int[100_001];

    public static void main(String[] args) throws IOException {
        initPrimeNumber();

        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            solve();
        }

        System.out.println(sb);
    }

    private static void initPrimeNumber() {
        primeNumber[0] = 1;
        primeNumber[1] = 1;
        for (int i = 2; i < primeNumber.length; i++) {
            if (primeNumber[i] == 1) continue;
            for (int j = i * 2; j < primeNumber.length; j += i) {
                primeNumber[j] = 1;
            }
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int primeN = 1;
        int cnt;
        while (n > 1) {
            for (int i = primeN + 1; i < primeNumber.length; i++) {
                if (primeNumber[i] == 0) {
                    primeN = i;
                    break;
                }
            }

            cnt = 0;
            while (n % primeN == 0) {
                n /= primeN;
                cnt++;
            }

            if (cnt != 0) sb.append(primeN).append(" ").append(cnt).append("\n");
        }

    }
}
