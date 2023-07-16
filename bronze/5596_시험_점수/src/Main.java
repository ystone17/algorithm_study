import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int a, b;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            a += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            b += Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(a, b));
    }
}
