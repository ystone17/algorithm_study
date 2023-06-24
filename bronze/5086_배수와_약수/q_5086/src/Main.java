import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int a, b;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) {
                break;
            }

            if (a > b) {
                if (a % b == 0) {
                    sb.append("multiple").append("\n");
                    continue;
                }
            } else {
                if (b % a == 0) {
                    sb.append("factor").append("\n");
                    continue;
                }
            }
            sb.append("neither").append("\n");
        }

        System.out.println(sb);
    }
}
