import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int ySize, xSize;
        st = new StringTokenizer(br.readLine());
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        char[][] map = new char[ySize][xSize];
        for (int y = 0; y < ySize; y++) {
            map[y] = br.readLine().toCharArray();
        }

        int res = 1;
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                int i = 0;
                while (y + i < ySize && x + i < xSize) {
                    if (map[y][x] == map[y + i][x + i] && map[y][x] == map[y + i][x] && map[y][x] == map[y][x + i]) {
                        res = Math.max(res, (i + 1) * (i + 1));
                    }
                    i++;
                }
            }
        }

        System.out.println(res);
    }
}
