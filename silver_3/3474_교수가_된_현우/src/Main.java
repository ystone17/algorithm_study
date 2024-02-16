import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int i = 5;
            int count = 0;
            while (i > 0 && i <= n) {
                count += n / i;
                i *= 5;
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
