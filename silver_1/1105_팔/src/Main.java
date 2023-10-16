import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String l, r;
    static int cnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        l = st.nextToken();
        r = st.nextToken();

        if (l.length() != r.length()) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < l.length(); i++) {
            if (l.charAt(i) == r.charAt(i) && l.charAt(i) == '8') {
                cnt++;
                continue;
            }

            if (l.charAt(i) != r.charAt(i)) {
                break;
            }
        }

        System.out.println(cnt);
    }
}
