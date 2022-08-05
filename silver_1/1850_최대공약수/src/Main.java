import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long a, b, temp;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        if (a < b) {
            temp = b;
            b = a;
            a = temp;
        }

        while (b > 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        for (int i = 0; i < a; i++) {
            sb.append("1");
        }


        System.out.println(sb);
    }
}
