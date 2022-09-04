import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int a, b, A, B;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        a *= B;
        A *= b;

        a += A;
        b *= B;
        int gcd = gcd(a, b);

        a /= gcd;
        b /= gcd;

        System.out.printf("%d %d ", a, b);
    }

    static int gcd(int a, int b) {
        int temp;
        if (a < b) {
            temp = b;
            b = a;
            a = temp;
        }

        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
