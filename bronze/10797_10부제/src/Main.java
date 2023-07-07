import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int res;
    static String day;

    public static void main(String[] args) throws IOException {
        day = br.readLine();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if (day.equals(st.nextToken())) {
                res++;
            }
        }
        System.out.println(res);
    }
}
