import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] times = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        Arrays.sort(times);
        for (int i = 0; i < n; i++) {
            answer += times[i] * (n - i);
        }

        System.out.println(answer);
    }
}
