import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] knightSeq = new int[10];
    static int[][] scoreMap = {
            {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0},
            {0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 30, 35, 40, 0},
            {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 30, 35, 40, 0},
            {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 28, 27, 26, 25, 30, 35, 40, 0}};
    static int[][] map;

    static int[] dice = new int[10];
    static int res;
    static List<Knight> knights = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            knights.add(new Knight());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        req(0);

        System.out.println(res);
    }

    static void req(int cnt) {
        if (cnt >= 10) {
            int max = 0;
            knights.forEach(Knight::init);
            map = new int[4][30];
            for (int[] route : map) {
                Arrays.fill(route, -1);
            }

            for (int i = 0; i < 10; i++) {
                Knight knight = knights.get(knightSeq[i]);

                int nRouteNum = knight.routeNum == 0 && (knight.num == 5 || knight.num == 10 || knight.num == 15) ? knight.routeNum + 1 : knight.routeNum;
                int nNum = Math.min(knight.num + dice[i], scoreMap[nRouteNum].length - 1);

                if (scoreMap[nRouteNum].length != nNum + 1 && map[nRouteNum][nNum] != -1) {
                    return;
                }

                if (nNum == scoreMap[nRouteNum].length - 2) {
                    if (map[0][scoreMap[0].length - 2] != -1 ||
                            map[1][scoreMap[1].length - 2] != -1 ||
                            map[2][scoreMap[2].length - 2] != -1 ||
                            map[3][scoreMap[3].length - 2] != -1) {
                        return;
                    }
                }

                if (nRouteNum != 0 && scoreMap[nRouteNum].length - 4 <= nNum && nNum <= scoreMap[nRouteNum].length - 2) {
                    if (map[1][scoreMap[1].length - (scoreMap[nRouteNum].length - nNum)] != -1 ||
                            map[2][scoreMap[2].length - (scoreMap[nRouteNum].length - nNum)] != -1 ||
                            map[3][scoreMap[3].length - (scoreMap[nRouteNum].length - nNum)] != -1) {
                        return;
                    }
                }

                map[knight.routeNum][knight.num] = -1;
                map[nRouteNum][nNum] = knightSeq[i];
                knight.routeNum = nRouteNum;
                knight.num = nNum;


                max += scoreMap[knight.routeNum][knight.num];
            }

            res = Math.max(res, max);
            return;
        }

        for (int i = 0; i < 5; i++) {
            knightSeq[cnt] = i;
            req(cnt + 1);
        }
    }

    static class Knight {
        int routeNum;
        int num;

        public void init() {
            routeNum = 0;
            num = 0;
        }
    }
}
