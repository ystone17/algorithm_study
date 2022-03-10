import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0;
        int total = 0;
        int answer = 0;

        while (e <= n){
            if(total < m){
                if(e == n ) break;
                total += arr[e++];
                continue;
            }

            if(total == m) {
                answer++;
            }

            total -= arr[s++];
        }

        System.out.println(answer);

    }
}
