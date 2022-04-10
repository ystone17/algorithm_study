import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int y, x;
    static char[][] map;
    static char[] wb = {'W', 'B'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new char[y][x];

        for (int cy = 0; cy < y; cy++) {
            map[cy] = br.readLine().toCharArray();
        }

        int res = Integer.MAX_VALUE;
        for (int cy = 0; cy <= y - 8; cy++) {
            for (int cx = 0; cx <= x - 8; cx++) {
                res = Math.min(res, getCount(cy, cx, 0));
                res = Math.min(res, getCount(cy, cx, 1));
            }
        }

        System.out.println(res);
    }

    private static int getCount(int cy, int cx, int index) {
        int count = 0;
        for (int ny = cy; ny < cy + 8; ny++) {
            for (int nx = cx; nx < cx + 8; nx++) {
                if (map[ny][nx] != wb[index]) count++;
                index = (index + 1) % 2;
            }
            index = (index + 1) % 2;
        }
        return count;
    }
}
