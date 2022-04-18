import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int maxY, maxX;
    static char[][] map;
    static int[][] visited;
    static int[] alpha = new int[26];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        maxY = Integer.parseInt(s[0]);
        maxX = Integer.parseInt(s[1]);

        map = new char[maxY][maxX];
        visited = new int[maxY][maxX];

        for (int i = 0; i < maxY; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[0][0] = 1;
        alpha[map[0][0] - 'A'] = 1;
        System.out.println(dfs(0, 0, 1));
    }

    static int dfs(int y, int x, int count) {

        int res = count;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= maxY || nx < 0 || nx >= maxX) continue;
            if (visited[ny][nx] == 1) continue;
            if (alpha[map[ny][nx] - 'A'] == 1) continue;

            visited[ny][nx] = 1;
            alpha[map[ny][nx] - 'A'] = 1;
            res = Math.max(res, dfs(ny, nx, count + 1));
            visited[ny][nx] = 0;
            alpha[map[ny][nx] - 'A'] = 0;
        }
        return res;
    }


}
