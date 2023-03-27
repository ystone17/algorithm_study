import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Knapsack {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] l, j;
    static int n, res;
    static int[][] knapsack;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        l = new int[n + 1];
        j = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            j[i + 1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            l[i + 1] = Integer.parseInt(st.nextToken());
        }

        knapsack = new int[n + 1][101];

        for (int z = 1; z <= n; z++) {
            for (int x = 0; x <= 100; x++) {
                if (x - j[z] <= 0) {
                    knapsack[z][x] = knapsack[z - 1][x];
                } else {
                    knapsack[z][x] = Math.max(knapsack[z - 1][x - j[z]] + l[z], knapsack[z - 1][x]);
                }
            }
        }


        System.out.println(knapsack[n][100]);
    }
}
