import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, l, res;
    static int[][] map1, map2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map1 = new int[n][n];
        map2 = new int[n][n];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map1[y][x] = Integer.parseInt(st.nextToken());
                map2[x][y] = map1[y][x];
            }
        }

        solve(map1);
        solve(map2);
        System.out.println(res);

    }

    static void solve(int[][] map) {
        for (int y = 0; y < map.length; y++) {
            int pre = map[y][0];
            boolean isRoad = true;
            int[] visited = new int[map.length];
            for (int x = 1; x < map.length; x++) {
                if (Math.abs(map[y][x] - pre) >= 2) {
                    isRoad = false;
                    pre = map[y][x];
                    break;
                } else if (map[y][x] - pre == 1) {
                    if (x - l < 0) {
                        isRoad = false;
                        pre = map[y][x];
                        break;
                    }

                    for (int i = x - l; i < x; i++) {
                        if (map[y][i] != map[y][x] - 1 || visited[i] == 1) {
                            isRoad = false;
                            pre = map[y][x];
                            break;
                        }
                        visited[i] = 1;
                    }

                } else if (pre - map[y][x] == 1) {
                    if (x + l - 1 >= map.length) {
                        isRoad = false;
                        pre = map[y][x];
                        break;
                    }

                    for (int i = x; i < x + l; i++) {
                        if (map[y][i] != map[y][x] || visited[i] == 1) {
                            isRoad = false;
                            pre = map[y][x];
                            break;
                        }
                        visited[i] = 1;
                    }
                }
                pre = map[y][x];
            }

            if (isRoad) {
                res++;
            }
        }


    }


}
