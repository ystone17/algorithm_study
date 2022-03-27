import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] pn = new long[101];
        pn[1] = 1;
        pn[2] = 1;
        pn[3] = 1;
        pn[4] = 2;
        pn[5] = 2;

        for (int i = 6; i <= 100; i++) {
            pn[i] = pn[i - 1] + pn[i - 5];
        }

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            sb.append(pn[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}
