import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] seq = new int[11];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        var res = 0;
        for (int i = 0; i < seq.length - 1; i++) {
            if (res + seq[i] <= 100) {
                res += seq[i];
                continue;
            }

            if (100 - res >= res + seq[i] - 100) {
                res += seq[i];
            }

            break;
        }

        System.out.println(res);
    }
}
