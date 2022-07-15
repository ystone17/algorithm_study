import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        int left = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
        }

        int right = (int) 1e9;

        while (left < right) {
            int mid = (left + right) / 2;

            int bluRayCnt = getBluRayCnt(mid);
            if (bluRayCnt <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);

    }

    static int getBluRayCnt(int k) {
        int sum = 0;
        int cnt = 1;

        for (int i : arr) {
            if (sum + i > k) {
                sum = 0;
                cnt++;
            }
            sum += i;
        }

        return cnt;
    }
}
