import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, answer;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] time;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        time = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            time[i] = t;

            int count = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count; j++) {
                int v = Integer.parseInt(st.nextToken());
                time[i] = Math.max(time[i], time[v] + t);
            }
            answer = Math.max(answer, time[i]);
        }

        System.out.println(answer);
    }

}
