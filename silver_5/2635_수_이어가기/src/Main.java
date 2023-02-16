import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, max;
    static String s;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = n; i > 0; i--) {
            int a = n;
            int b = i;
            int cnt = 1;
            sb = new StringBuilder();
            sb.append(a).append(" ");
            while (b >= 0) {
                cnt++;
                sb.append(b).append(" ");
                int temp = b;
                b = a - b;
                a = temp;
            }

            if (max < cnt) {
                max = cnt;
                s = sb.toString();
            }
        }
        System.out.println(max);
        System.out.println(s);
    }
}
