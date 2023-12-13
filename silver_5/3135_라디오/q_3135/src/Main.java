import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int a, b, n;

    public static void main(String[] args) throws IOException {
        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        min = Math.min(min, Math.abs(a - b));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            min = Math.min(min, Math.abs(temp - b) + 1);
        }

        System.out.println(min);
    }
}
