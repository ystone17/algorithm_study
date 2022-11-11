import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, a, minPackage = 987654321, minSingle = 987654321, res;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            minPackage = Math.min(minPackage, a);
            a = Integer.parseInt(st.nextToken());
            minSingle = Math.min(minSingle, a);
        }

        while (n > 0) {
            if (n >= 6) {
                res += Math.min(minPackage, minSingle * 6);
                n -= 6;
            } else {
                res += Math.min(minPackage, minSingle * n);
                n -= 6;
            }
        }

        System.out.println(res);
    }
}
