import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        long left = 0;
        for (int i : cost) {
            left = Math.max(left, i);
        }
        long right = 1_987_654_321;
        long mid;

        while (left < right){
            mid = (left  + right) / 2;

            if(ok(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);


    }

    private static boolean ok(long k) {
        int mCnt = 0;
        long wallet = 0;
        for (int i = 0; i < n; i++) {
            if (wallet < cost[i]) {
                wallet = k;
                mCnt++;
            }
            wallet -= cost[i];
            if(mCnt > m) {
                return false;
            }
        }

        return true;
    }
}
