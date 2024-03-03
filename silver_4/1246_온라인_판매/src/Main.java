import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m ;
    static int[] prices;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        prices = new int[m];
        for (int i = 0; i < m; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(prices);

        var maxPrice = 0;
        var total = 0;
        for (int i = 0; i < prices.length; i++) {
            var price = prices[i];
            var tempTotal = 0;
            if(prices.length - i >= n) {
                tempTotal = price * n;
            } else {
                tempTotal = price * (prices.length - i) ;
            }

            if(tempTotal > total) {
                total = tempTotal;
                maxPrice = price;
            }
        }

        System.out.printf("%d %d", maxPrice, total);
    }
}
