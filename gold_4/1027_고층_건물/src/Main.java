import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, max;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        heights = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        boolean canSee;
        int temp;
        int dy;
        int dx;
        for (int me = 1; me <= n; me++) {
            temp = 0;
            for (int u = 1; u <= n; u++) {
                if (me == u) {
                    continue;
                }

                canSee = true;

                dx = me - u;
                dy = heights[me] - heights[u];

                for (int mid = Math.min(me, u) + 1; mid < Math.max(me, u); mid++) {

                    if (!isSee(dy, dx, mid, heights[mid])) {
                        canSee = false;
                        break;
                    }
                }

                if (canSee) {
                    temp++;
                }
            }
            max = Math.max(max, temp);
        }

        System.out.println(max);
    }

    private static boolean isSee(int dy, int dx, int my, int mx) {
        if (dx < 0) {
            dx = -dx;
            dy = -dy;
        }

        return dy * mx > my * dx;
    }
}
