import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc, n;
    static long total;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            total = 0;
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    total += gcd(arr[i], arr[j]);
                }
            }
            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }


        while (b != 0) {
            temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }
}
