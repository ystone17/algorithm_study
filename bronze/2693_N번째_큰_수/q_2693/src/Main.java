import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] seq;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            seq = new int[10];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                seq[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(seq);
            sb.append(seq[7]).append("\n");
        }

        System.out.println(sb);
    }
}
