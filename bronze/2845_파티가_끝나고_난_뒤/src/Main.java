import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int l, p, temp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            temp = Integer.parseInt(st.nextToken());
            sb.append(temp - (l * p)).append(" ");
        }

        System.out.println(sb);
    }
}
