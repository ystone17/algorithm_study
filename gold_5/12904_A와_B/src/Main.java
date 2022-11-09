import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String a;

    public static void main(String[] args) throws IOException {
        a = br.readLine();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken());
        }

        while (sb.length() != a.length()) {
            if (sb.toString().charAt(sb.length() - 1) == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }

        if (a.equals(sb.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
