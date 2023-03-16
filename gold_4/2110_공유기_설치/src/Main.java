import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, c;
    static int[] house;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken()) - 1;

        house = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        for (int i = n; i >= 1; i--) {
            house[i] -= house[1];
        }


        int left = 0;
        int right = house[n] + 1;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (ok(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left - 1);

    }

    static boolean ok(int minSize) {
        int cnt = 0;
        int lastHouse = 0;

        for (int i = 1; i < n + 1; i++) {
            if (house[i] - house[lastHouse] >= minSize) {
                cnt++;
                lastHouse = i;
            }

            if (cnt >= c) return true;
        }

        return false;
    }
}
