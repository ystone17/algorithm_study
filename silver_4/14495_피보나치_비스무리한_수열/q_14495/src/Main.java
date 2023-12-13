import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long[] seq = new long[117];

    public static void main(String[] args) throws IOException {
        seq[1] = seq[2] = seq[3] = 1;

        for (int i = 4; i < 117; i++) {
            seq[i] = seq[i - 1] + seq[i - 3];
        }

        System.out.println(seq[Integer.parseInt(br.readLine())]);
    }
}
