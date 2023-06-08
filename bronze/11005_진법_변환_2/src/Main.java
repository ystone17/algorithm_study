import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, b;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        while (n >= b) {
            int num = n % b;
            sb.append(convert(num));
            n /= b;
        }

        sb.append(convert(n));
        System.out.println(sb.reverse());
    }

    private static Object convert(int num) {
        return num < 10 ? num : Character.toString(num - 10 + 65);
    }
}
