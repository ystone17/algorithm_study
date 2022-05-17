import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] weight = new int[40001];
    static int[] temp = new int[40001];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            temp = new int[40001];
            int w = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= 40000; j++) {
                if (weight[j] != 1) continue;
                temp[Math.abs(j - w)] = 1;
                temp[j + w] = 1;
            }
            for (int j = 1; j <= 40000; j++) {
                if (temp[j] == 1){
                    weight[j] = 1;
                }
            }
            weight[w] = 1;
        }

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (weight[Integer.parseInt(st.nextToken())] == 1) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb);

    }

}
