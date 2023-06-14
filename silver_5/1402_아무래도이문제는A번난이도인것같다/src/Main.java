import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            sb.append("yes").append("\n");
        }
        System.out.println(sb);
    }
}
