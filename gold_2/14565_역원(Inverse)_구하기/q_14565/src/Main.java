import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static long n, a;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        a = Long.parseLong(st.nextToken());

        System.out.printf("%d %d", n - a, gcd(a, n) == 1 ? xgcd(a, n) : -1);
    }

    static long gcd(long a, long b) {
        if (a < b) {
            var temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            var temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }


    static long xgcd(long a, long n) {
        long q, r1, r2, r, s1, s2, s, t1, t2, t;

        r1 = a;
        r2 = n;
        s1 = 1;
        s2 = 0;
        t1 = 0;
        t2 = 1;

        while (r2 != 0) {
            q = r1 / r2;
            r = r1 - (q * r2);
            s = s1 - (q * s2);
            t = t1 - (q * t2);

            r1 = r2;
            r2 = r;

            s1 = s2;
            s2 = s;

            t1 = t2;
            t2 = t;
        }

        while (s1 < 0) {
            s1 += n;
        }

        return s1;
    }


}
