import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static String[] pattern;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        pattern = br.readLine().split("\\*");

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            if (s.indexOf(pattern[0]) != 0) {
                sb.append("NE").append("\n");
                continue;
            }

            int i2 = s.lastIndexOf(pattern[1]);
            int i3 = s.length() - pattern[1].length();
            if (i3 < pattern[0].length() || i2 != i3) {
                sb.append("NE").append("\n");
                continue;
            }

            sb.append("DA").append("\n");
        }

        System.out.println(sb);
    }
}
