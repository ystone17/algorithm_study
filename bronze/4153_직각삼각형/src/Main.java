import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 0) {
                break;
            }

            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }

            if (a < c) {
                int temp = a;
                a = c;
                c = temp;
            }

            if (a * a == b * b + c * c) {
                sb.append("right").append("\n");
            } else{
                sb.append("wrong").append("\n");
            }

        }

        System.out.println(sb);

    }
}
