import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] arr;
    static int n, k, cnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];


        for (int i = 2; i <= n; i++) {
            if (arr[i] == 1) continue;

            cnt++;
            if (cnt == k) {
                System.out.println(i);
                return;
            }

            for (int j = i * i; j <= n; j += i) {
                if(arr[j] == 1) continue;
                arr[j] = 1;
                cnt++;
                if (cnt == k) {
                    System.out.println(j);
                    return;
                }
            }
        }

    }
}
