import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int x, y, z;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = (int) ((long) y * 100 / x);

        if (z >= 99) {
            System.out.println(-1);
            return;
        }


        int left = 0;
        int right = (int) 1e9;

        while (left < right) {
            int mid = (left + right) / 2;

            int nz = (int) ((long) (y + mid) * 100 / (x + mid));

            if (nz >= z + 1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);

    }
}
