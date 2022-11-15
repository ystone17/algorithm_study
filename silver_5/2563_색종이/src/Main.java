import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int n;
    static int[][] map = new int[120][120];
    static int res;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    if (map[j][k] == 0) {
                        map[j][k] = 1;
                        res++;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
