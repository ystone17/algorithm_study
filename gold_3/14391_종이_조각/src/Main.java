import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int Y, X;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        paper = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            int j = 0;
            for (String s : br.readLine().split("")) {
                paper[i][j++] = Integer.parseInt(s);
            }
        }

        int res = solve(0, 0, Y - 1, X - 1, 0);
        System.out.println(res);
    }

    private static int solve(int sy, int sx, int ey, int ex, int sum) {
        if (sy == ey || sx == ex) {
            return sum + getLength(sy, sx, ey, ex);
        }

        int res = 0;
        int length = 0;
        int solve = 0;

        // 가로 1줄
        length = getLength(sy, sx, sy, ex);
        solve = solve(sy + 1, sx, ey, ex, sum + length);
        res = Math.max(res, solve);

        //가로 끝줄
        length = getLength(ey, sx, ey, ex);
        solve = solve(sy, sx, ey - 1, ex, sum + length);
        res = Math.max(res, solve);

        // 세로 1줄
        length = getLength(sy, sx, ey, sx);
        solve = solve(sy, sx + 1, ey, ex, sum + length);
        res = Math.max(res, solve);

        // 세로 끝줄
        length = getLength(sy, ex, ey, ex);
        solve = solve(sy, sx, ey, ex - 1, sum + length);
        res = Math.max(res, solve);

        return res;
    }

    private static int getLength(int sy, int sx, int ey, int ex) {
        int sum = 0;
        int digit = 1;

        for (int i = ey; i >= sy; i--) {
            for (int j = ex; j >= sx; j--) {
                sum += paper[i][j] * digit;
                digit *= 10;
            }
        }

        return sum;
    }
}
