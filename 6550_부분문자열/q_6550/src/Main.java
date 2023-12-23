import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String s, t, input;

    public static void main(String[] args) throws IOException {
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            if (!st.hasMoreTokens()) {
                break;
            }
            s = st.nextToken();
            t = st.nextToken();

            var sIdx = 0;
            var tIdx = 0;

            while (sIdx < s.length() && tIdx < t.length()) {
                if (s.charAt(sIdx) == t.charAt(tIdx)) {
                    sIdx++;
                }

                tIdx++;
            }

            if (sIdx == s.length()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
