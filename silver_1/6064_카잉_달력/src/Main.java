import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int m, n, x, y, tc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int b = x % n;
            if(b == 0) b = n;
            int age = x;
            int lcm = lcm(m, n);
            while (true) {
                if (b == y) {
                    sb.append(age).append('\n');
                    break;
                }
                if (age >= lcm) {
                    sb.append(-1).append('\n');
                    break;
                }
                age += m;
                b = (b + m) % n;
                if (b == 0) b = n;
            }


        }
        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
