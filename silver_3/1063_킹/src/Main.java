import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Map<String, Dir> dirMap = Map.of(
            "R", new Dir(0, 1),
            "L", new Dir(0, -1),
            "B", new Dir(-1, 0),
            "T", new Dir(1, 0),
            "RT", new Dir(1, 1),
            "LT", new Dir(1, -1),
            "RB", new Dir(-1, 1),
            "LB", new Dir(-1, -1)
    );
    static int sY, sX, kY, kX, n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        char[] king = st.nextToken().toCharArray();
        kX = king[0] - 'A' + 1;
        kY = king[1] - '1' + 1;

        char[] stone = st.nextToken().toCharArray();
        sX = stone[0] - 'A' + 1;
        sY = stone[1] - '1' + 1;

        n = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            move(br.readLine());
        }

        sb.append((char) (kX + 'A' - 1)).append(kY).append("\n").append((char) (sX + 'A' - 1)).append(sY);
        System.out.println(sb);
    }

    static void move(String command) {
        Dir dir = dirMap.get(command);

        int nKy = kY + dir.y;
        int nKx = kX + dir.x;
        int nSy = sY + dir.y;
        int nSx = sX + dir.x;

        if (invalid(nKy, nKx)) return;

        if (!(nKy == sY && nKx == sX)) {
            kY = nKy;
            kX = nKx;
            return;
        }

        if (invalid(nSy, nSx)) return;
        kY = nKy;
        kX = nKx;
        sY = nSy;
        sX = nSx;
    }

    static boolean invalid(int y, int x) {
        return y <= 0 || y > 8 || x <= 0 || x > 8;
    }

    static private class Dir {
        final int y;
        final int x;

        public Dir(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
