import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, count;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            count = 0;
            seq = new int[20];
            for (int j = 0; j < 20; j++) {
                seq[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < 20; j++) {
                for (int k = 0; k < j; k++) {
                    if (seq[k] > seq[j]) {
                        count++;
                    }
                }
            }

            sb.append(i + 1).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }
}
