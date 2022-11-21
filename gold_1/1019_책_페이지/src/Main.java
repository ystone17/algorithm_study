import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        System.out.println(LocalDateTime.now());

        int from = 0, temp;
        int[] res = new int[10];
        if (n >= 10) {
            res[0] = -1;
        }

        while (from + 10 <= n) {
            for (int i = 0; i < 10; i++) {
                res[i]++;
            }

            temp = from / 10;
            while (temp != 0) {
                res[temp % 10] += 10;
                temp /= 10;
            }
            from += 10;
        }

        for (int i = from; i <= n; i++) {
            temp = i;
            while (temp != 0) {
                res[temp % 10]++;
                temp /= 10;
            }
        }

        for (int re : res) {
            System.out.printf("%d ", re);
        }
        System.out.println(LocalDateTime.now());
    }
}
