import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, sum, idx, min, subSum;
    static int[] price;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        price = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(price);

        for (int i = 0; i < n % 3; i++) {
            sum += price[idx++];
        }

        while (idx < n) {
            min = Integer.MAX_VALUE;
            subSum = 0;
            for (int i = 0; i < 3; i++) {
                subSum += price[idx + i];
                min = Math.min(min, price[idx + i]);
            }
            sum += subSum - min;
            idx += 3;
        }

        System.out.println(sum);
    }
}
