import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static boolean[] notPrime = new boolean[1000001];
    static int tc;
    public static void main(String[] args) throws IOException {
        for (int i = 2; i < 1000001; i++) {
            if(notPrime[i]) continue;
            for (int j = i + i; j < 1000001; j+=i) {
                notPrime[j] = true;
            }
        }

        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 2; i <= n / 2; i++) {
                if (!notPrime[i] && !notPrime[n - i]) count++;
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }
}
