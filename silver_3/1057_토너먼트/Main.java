import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, a, b;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int round = 1;
        while (true) {
            if (Math.abs(a - b) == 1 && ((a + b) - 3) % 4 == 0) {
                System.out.println(round);
                return;
            }

            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }
    }
}
