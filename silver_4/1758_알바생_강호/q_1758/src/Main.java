import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static long res;
    static int[] tips;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br. readLine());

        tips = new int[n];

        for (int i = 0; i < n; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tips);

        int rank = 0;
        for (int i = tips.length - 1; i >= 0; i--) {
            int newTip = tips[i] - rank++;
            res += Math.max(newTip, 0);
        }

        System.out.println(res);
    }
}
