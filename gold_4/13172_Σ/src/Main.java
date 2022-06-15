import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long answer, primeBase = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long[] gcd = gcd(b, primeBase);
            gcd[1] = (gcd[1] + primeBase) % primeBase;

            long l = (a * gcd[1]) % primeBase;
            answer = (answer + l) % primeBase;

        }
        System.out.println(answer);

    }

    static long[] gcd(long a, long b) {
        long temp = 0;
        long q = 0;

        long s1 = 1, s2 = 0;
        long t1 = 0, t2 = 1;

        while (b != 0) {
            temp = b;
            q = a / b;
            b = a % b;
            a = temp;

            temp = s2;
            s2 = s1 - q * s2;
            s1 = temp;

            temp = t2;
            t2 = t1 - q * t2;
            t1 = temp;


        }
        return new long[]{a, s1, t1};
    }

}
