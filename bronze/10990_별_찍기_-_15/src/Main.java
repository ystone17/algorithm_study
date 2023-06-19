import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, left, mid = 1;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        sb.append(" ".repeat(n - 1)).append("*").append("\n");

        left = n - 2;
        for (int i = 1; i < n; i++) {
            sb.append(" ".repeat(left)).append("*").append(" ".repeat(mid)).append("*").append("\n");
            mid += 2;
            left--;
        }

        System.out.println(sb);
    }
}
