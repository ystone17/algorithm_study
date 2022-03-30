import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] prime = new boolean[10000 + 1];

        for (int i = 2; i < 10000; i++) {
            if(prime[i]) continue;

            for (int j = i * 2; j < 10000; j+=i) {
                prime[j] = true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int st = 0, en = 0;
            for (int i = 2; i <= n /2; i++) {
                if (!prime[i] && !prime[n - i]) {
                    st = i;
                    en = n - i;
                }
            }
            sb.append(st).append(" ").append(en).append("\n");
        }
        System.out.println(sb);

    }
}
