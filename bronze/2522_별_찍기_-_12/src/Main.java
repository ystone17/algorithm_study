import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i++) {
            sb.append(" ".repeat(n - i)).append("*".repeat(i)).append("\n");
        }
        sb.append("*".repeat(n)).append("\n");
        for (int i = 1; i < n; i++) {
            sb.append(" ".repeat(i)).append("*".repeat(n - i)).append("\n");
        }

        System.out.println(sb);
    }
}
