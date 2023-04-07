import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] primeNum = new int[1000000 + 1];

    public static void main(String[] args) throws IOException {
        initPrime();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            gold(n);
        }

        System.out.println(sb);
    }

    static void gold(int n) {
        for (int i = 3; i <= n / 2; i += 2) {
            if (primeNum[i] == 1) continue;
            if (primeNum[n - i] == 1) continue;

            sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
            return;
        }
    }

    static void initPrime() {
        primeNum[1] = 1;
        for (int i = 2; i < primeNum.length; i++) {
            if (primeNum[i] == 1) continue;
            for (int j = i * 2; j < primeNum.length; j = j + i) {
                primeNum[j] = 1;
            }
        }
    }
}
