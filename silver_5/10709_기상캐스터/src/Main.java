import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int y, x;
    static char[][] map;
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        answer = new int[y][x];
        for (int yIdx = 0; yIdx < y; yIdx++) {
            Arrays.fill(answer[yIdx], -1);
        }

        map = new char[y][x];

        for (int yIdx = 0; yIdx < y; yIdx++) {
            map[yIdx] = br.readLine().toCharArray();
        }

        for (int time = 0; time < x; time++) {
            check(time);
            move();
        }

        for (int yIdx = 0; yIdx < y; yIdx++) {
            for (int xIdx = 0; xIdx < x; xIdx++) {
                sb.append(answer[yIdx][xIdx]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void move() {
        for (int yIdx = 0; yIdx < y; yIdx++) {
            for (int xIdx = x - 2; xIdx >= 0; xIdx--) {
                map[yIdx][xIdx + 1] = map[yIdx][xIdx];
            }
        }
    }

    static void check(int time) {
        for (int yIdx = 0; yIdx < y; yIdx++) {
            for (int xIdx = 0; xIdx < x; xIdx++) {
                if (map[yIdx][xIdx] == 'c' && answer[yIdx][xIdx] == -1) {
                    answer[yIdx][xIdx] = time;
                }
            }
        }
    }
}
