import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc, n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[3][n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[1][i + 1] = Integer.parseInt(st.nextToken());
                arr[0][i + 1] = i + 1;
            }

            int start, temp, idx, res = 0;
            for (int i = 1; i <= n; i++) {
                if (arr[2][i] == 1) continue;
                arr[2][i] = 1;
                start = arr[0][i];
                temp = arr[1][i];
                idx = 1;
                while (start != temp) {
                    idx = (idx + 1) % 2;
                    temp = arr[idx][temp];
                    arr[2][temp] = 1;
                }
                res++;
            }

            System.out.println(res);

        }
    }
}
