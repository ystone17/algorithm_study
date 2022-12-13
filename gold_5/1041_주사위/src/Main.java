import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] dice = new int[6];
    static long one = 10_000_000, two = 10_000_000, three = 10_000_000;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
            one = Math.min(one, dice[i]);
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == j || i + j == 5) continue;
                two = Math.min(two, dice[i] + dice[j]);
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == j || i + j == 5) continue;
                for (int k = 0; k < 6; k++) {
                    if (j == k || j + k == 5) continue;
                    if (k == i || k + i == 5) continue;
                    three = Math.min(three, dice[i] + dice[j] + dice[k]);
                }
            }
        }

        long sum = 0;

        if (n == 1) {
            int max = 0;
            for (int d : dice) {
                sum += d;
                max = Integer.max(max, d);
            }
            System.out.println(sum - max);
            return;
        }

        sum += three * 4;
        sum += two * (n - 2) * 4;
        sum += one * (n - 2) * (n - 2);

        sum += two * (n - 2) * 4;
        sum += one * (n - 2) * (n - 2) * 4;

        sum += two * 4;
        sum += one * (n - 2) * 4;

        System.out.println(sum);
    }
}
