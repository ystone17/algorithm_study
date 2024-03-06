import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[][] map;

    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve(0, 0, n));
    }

    public static int solve(int y, int x, int size) {
        if (size == 2) {
            var list = new ArrayList<Integer>();
            for (int i = y; i < y + 2; i++) {
                for (int j = x; j < x + 2; j++) {
                    list.add(map[i][j]);
                }
            }

            Collections.sort(list);
            return list.get(2);
        }

        var nextSize = size / 2;
        var list = new ArrayList<Integer>();
        for (int i = y; i < y + size; i += nextSize) {
            for (int j = x; j < x + size; j += nextSize) {
                var solve = solve(i, j, nextSize);
                list.add(solve);
            }
        }

        Collections.sort(list);
        return list.get(2);
    }
}
