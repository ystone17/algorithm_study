import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, goal, maxLen;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());

        trees = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(maxLen, trees[i]);
        }

        int binary = binary();
        System.out.println(binary - 1);

    }

    static int binary() {
        int left = 0;
        int right = maxLen;

        while (left < right) {
            int mid = (left + right) / 2;
            if (calcLen(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static boolean calcLen(int len) {
        long res = 0;
        for (int tree : trees) {
            if (tree <= len) continue;
            res += tree - len;
            if(res >= goal) return true;
        }

        return false;
    }


}
