import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] apt = new int[15][14];
    static int tc, k, n;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < apt[0].length; i++) {
            apt[0][i] = i + 1;
        }

        for (int y = 1; y < 15; y++) {
            int temp = 0;
            for (int x = 0; x < 14; x++) {
                temp += apt[y - 1][x];
                apt[y][x] = temp;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            sb.append(apt[k][n-1]).append("\n");
        }
        System.out.println(sb);
    }
}
