import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String a, b;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = st.nextToken();
        b = st.nextToken();

        int res = 987654321;
        for (int i = 0; i <= b.length() - a.length(); i++) {
            int sub = 0;
            for (int j = 0; j < a.length(); j++) {
                if (b.charAt(i + j) != a.charAt(j)) sub++;
            }

            res = Math.min(res, sub);
        }

        System.out.println(res);
    }
}

