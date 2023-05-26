import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, s, res;
    static int[] bro;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        bro = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bro[i] = Integer.parseInt(st.nextToken());
        }

        res = Math.abs(s - bro[0]);

        for (int b : bro) {
            res = mcd(res, Math.abs(s - b));
        }

        System.out.println(res);

    }

    static int mcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }
}
