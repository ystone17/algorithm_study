import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] A = new int[1001];
    static int[] B = new int[1001];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a]++;
            B[b]++;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                sb.append(i).append(" ");
            }
        }
        for (int i = 0; i < B.length; i++) {
            if (B[i] == 1) {
                sb.append(i);
            }
        }

        System.out.println(sb);
    }
}
