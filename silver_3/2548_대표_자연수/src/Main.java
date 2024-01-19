import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, sum, min, res;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        seq = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(seq);

        for (int i = 1; i < seq.length; i++) {
            sum += seq[i] - seq[0];
        }

        min = sum;
        res = seq[0];

        for (int i = 1; i < seq.length; i++) {
            int diff = seq[i] - seq[i - 1];

            sum += diff * (i - 1);
            sum -= diff * (seq.length - 1 - i);

            if (min > sum) {
                min = sum;
                res = seq[i];
            }
        }

        System.out.println(res);

    }
}
