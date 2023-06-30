import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int total, max;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            int minus = Integer.parseInt(st.nextToken());
            int plus = Integer.parseInt(st.nextToken());

            total -= minus;
            total += plus;

            max = Math.max(max, total);
        }

        System.out.println(max);
    }
}
