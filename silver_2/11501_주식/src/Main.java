import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;
    static int n, high;
    static long total;
    static int[] price;
    static int[] highPrice;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- >0) {
            n = Integer.parseInt(br.readLine());
            price = new int[n];
            highPrice = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            high = price[n - 1];
            for (int i = price.length - 1; i >= 0; i--) {
                high = Math.max(high, price[i]);
                highPrice[i] = high;
            }

            total = 0;
            for (int i = 0; i < n; i++) {
                total += highPrice[i] - price[i];
            }

            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}
