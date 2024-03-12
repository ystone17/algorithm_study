import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int tc;
    static char[] commands;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            commands = br.readLine().toCharArray();
            int y = 0;
            int x = 0;
            int sy = 0;
            int sx = 0;
            int by = 0;
            int bx = 0;
            int dir = 0;

            for (char command : commands) {
                if (command == 'R') {
                    dir = (dir + 1) % 4;
                    continue;
                }

                if (command == 'L') {
                    dir = (dir + 3) % 4;
                    continue;
                }

                if (command == 'F') {
                    y += dy[dir];
                    x += dx[dir];
                }

                if (command == 'B') {
                    y -= dy[dir];
                    x -= dx[dir];
                }

                sy = Math.min(sy, y);
                sx = Math.min(sx, x);
                by = Math.max(by, y);
                bx = Math.max(bx, x);
            }
            sb.append((by - sy) * (bx - sx)).append("\n");
        }

        System.out.println(sb);
    }
}
