import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, l, x;
    static int[] partSum = new int[101];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 100; i++) {
            partSum[i] = partSum[i - 1] + i;
        }

        sb.append(-1);
        for (int i = l; i <= 100; i++) {
            if (n - partSum[i - 1] < 0) break;
            if ((n - partSum[i - 1]) % i != 0) continue;
            x = (n - partSum[i - 1]) / i;
            sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append(x + j).append(" ");
            }
            break;
        }

        System.out.println(sb);


    }
}
