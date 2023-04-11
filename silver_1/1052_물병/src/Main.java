import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        for (int i = 0; i <= n; i++) {
            char[] binary = Integer.toBinaryString(n + i).toCharArray();
            int cnt = 0;
            for (char c : binary) {
                if (c == '1') cnt++;
            }

            if (cnt <= k) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);

    }
}
