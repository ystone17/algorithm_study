import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] map = new int[9][9];

    static int max, y, x;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (max < map[i][j]) {
                    max = map[i][j];
                    y = i;
                    x = j;
                }
            }
        }

        sb.append(max).append("\n").append(y + 1).append(" ").append(x + 1);
        System.out.println(sb);
    }
}
