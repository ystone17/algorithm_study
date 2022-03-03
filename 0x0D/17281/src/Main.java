import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] rotation = new int[10];
    static int[] used = new int[10];
    static int n;
    static int[][] player;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        player = new int[n][10];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        used[1] = 1;
        rotation[4] = 1;
        System.out.print(solve(1));
    }

    static int solve(int position) {
        if (position == 10) {
            return baseball();
        }

        if (position == 4) {
            return solve(position + 1);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 2; i <= 9; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            rotation[position] = i;
            int nRes = solve(position + 1);
            res = Math.max(res, nRes);
            used[i] = 0;
        }

        return res;
    }

    static int baseball() {
        int round = 0;
        int out = 0;
        int point = 0;
        int nowPlayer = 1;
        int[] base = new int[3];
        while (round != n) {
            while (out != 3) {
                switch (player[round][rotation[nowPlayer]]) {
                    case 0:
                        out++;
                        break;
                    case 1:
                        point = goBase(point, base, 1);
                        base[0] = 1;
                        break;
                    case 2:
                        point = goBase(point, base, 2);
                        base[1] = 1;
                        break;
                    case 3:
                        point = goBase(point, base, 3);
                        base[2] = 1;
                        break;
                    case 4:
                        point = goBase(point, base, 3);
                        point++;
                        break;
                }

                nowPlayer = (nowPlayer + 1) % 10;
                if( nowPlayer == 0) nowPlayer = 1;
            }
            out = 0;
            base = new int[4];
            round++;
        }

        return point;
    }

    private static int goBase(int point, int[] base, int t) {
        for (int i = 2; i > 2 - t; i--) {
            if (base[i] == 1) {
                point++;
                base[i] = 0;
            }
        }
        for (int i = 2 - t; i >= 0; i--) {
            if (base[i] == 1) {
                base[i + t] = 1;
                base[i] = 0;
            }
        }
        return point;
    }


}
