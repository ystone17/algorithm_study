import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long a, b;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        System.out.println(lcm(a, b));
    }

    static long gcd(long a, long b) {
        if( a < b) {
            long temp = b;
            b = a;
            a = temp;
        }

        while (b > 0 ) {
            long temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
