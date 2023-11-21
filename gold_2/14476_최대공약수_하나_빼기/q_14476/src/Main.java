import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int k= -1;
        int kGcd = -1;

        for (int del = 0; del < n; del++) {
            int gcd = del == 0 ? seq[1] : seq[0];
            for (int i = 0; i < n; i++) {
                if(i == del) {
                    continue;
                }

                gcd = gcd(gcd, seq[i]);
            }

            if(seq[del] % gcd == 0) {
                continue;
            }

            if(gcd > kGcd) {
                k = del;
                kGcd = gcd;
            }
        }
        if(k == -1) {
            System.out.println(-1);
        } else {
            System.out.printf("%d %d", kGcd, seq[k]);
        }
    }

    private static int gcd(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }
}
