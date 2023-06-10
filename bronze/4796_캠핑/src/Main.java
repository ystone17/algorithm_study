import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int l,p,v, quotient, remainder, idx = 1;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            if(l == 0 && p == 0 && v == 0) {
                break;
            }

            quotient = v / p;
            remainder = v % p;

            sb.append(String.format("Case %d: %d\n", idx++, l * quotient + Math.min(remainder, l)));
        }
        System.out.println(sb);
    }
}
