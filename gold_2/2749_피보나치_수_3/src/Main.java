import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long n;
    static long[][] fib = {
            {1, 1},
            {1, 0}
    };

    public static void main(String[] args) throws IOException {
        n = Long.parseLong(br.readLine());

        long[][] fibonacci = fibonacci(n);
        System.out.println(fibonacci[0][1]);

    }

    static long[][] fibonacci(long n) {

        if (n == 1) {
            return fib;
        }

        long[][] fibonacci = fibonacci(n / 2);
        long[][] mul = mul(fibonacci, fibonacci);

        if (n % 2 == 0) {
            return mul;
        } else {
            return mul(mul, fib);
        }
    }

    static long[][] mul(long[][] m, long[][] n) {
        long[][] res = new long[2][2];

        res[0][0] = (m[0][0] * n[0][0] + m[0][1] * n[1][0]) % 1000000;
        res[0][1] = (m[0][0] * n[0][1] + m[0][1] * n[1][1]) % 1000000;
        res[1][0] = (m[1][0] * n[0][0] + m[1][1] * n[1][0]) % 1000000;
        res[1][1] = (m[1][0] * n[0][1] + m[1][1] * n[1][1]) % 1000000;

        return res;
    }


}
