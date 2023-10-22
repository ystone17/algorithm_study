import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;
    static String format = "(10(0+1+)|01)+";


    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s = br.readLine();
            sb.append(s.matches(format) ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
