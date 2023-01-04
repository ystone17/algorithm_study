import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int gcm, lcd;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        gcm = Integer.parseInt(st.nextToken());
        lcd = Integer.parseInt(st.nextToken());

        int common = lcd / gcm;

        for (int i = (int) Math.sqrt(common); i > 0; i--) {
            if (common % i == 0 && gcm(i, common / i) == 1) {
                sb.append(i * gcm).append(" ").append(common / i * gcm);
                break;
            }
        }

        System.out.println(sb);
    }

    static int gcm(int a, int b) {
        if (a < b) {
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
