import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        seq = new int[100001];
        seq[1] = Integer.MAX_VALUE;
        seq[2] = 1;
        seq[3] = Integer.MAX_VALUE;
        seq[4] = 2;
        seq[5] = 1;
        for (int i = 6; i <= 100000; i++) {
            int min = Math.min(seq[i - 5], seq[i - 2]);
            if (min != Integer.MAX_VALUE) {
                min++;
            }
            seq[i] = min;
        }
        if (seq[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(seq[n]);
        }
    }


}
