import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int tc, h, w, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        tc = Integer.parseInt(br.readLine());


        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());

            int x = (num - 1) / h + 1;
            int y = (num - 1) % h + 1;

            sb.append(String.format("%d%02d\n", y, x));
        }

        System.out.println(sb);


    }
}
