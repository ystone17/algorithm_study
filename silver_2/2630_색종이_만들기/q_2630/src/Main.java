import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int blue = 1, white = 0;
    static int n, w, b;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                paper[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, n);

        System.out.println(w);
        System.out.println(b);
    }

    static void solve(int sy, int sx, int length) {
        if (isOneColor(sy, sx, length)) {
            if (paper[sy][sx] == white) {
                w++;
                return;
            }

            b++;
            return;
        }

        int nLength = length / 2;
        solve(sy, sx, nLength);
        solve(sy, sx + nLength, nLength);
        solve(sy + nLength, sx, nLength);
        solve(sy + nLength, sx + nLength, nLength);
    }

    private static boolean isOneColor(int sy, int sx, int length) {
        int firstBlock = paper[sy][sx];

        for (int y = sy; y < sy + length; y++) {
            for (int x = sx; x < sx + length; x++) {
                if (paper[y][x] != firstBlock) {
                    return false;
                }
            }
        }

        return true;
    }
}
