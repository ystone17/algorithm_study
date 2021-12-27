import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int ySize, xSize, g, r;
    static int[][] map;
    static ArrayList<Integer> ground = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < xSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2)
                    ground.add(i * xSize + j);
            }
        }


        System.out.println(seed(0, 0, g, r, new int[ground.size()]));

    }

    static int seed(int gStart, int rStart, int gCount, int rCount, int[] used) {
        // 배치 할 곳 다 정함
        if (gCount == 0 && rCount == 0) {
            // dfs
            int[][] flowerMap = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
            for (int i = 0; i < used.length; i++) {
                if (used[i] == 1) {
                    int yx = ground.get(i);
                    flowerMap[yx / xSize][yx % xSize] = 3;
                } else if (used[i] == 2) {
                    int yx = ground.get(i);
                    flowerMap[yx / xSize][yx % xSize] = 4;
                }
            }
            return bfs(flowerMap, used);
        }

        int res = -1;
        int flower = 0;
        if (gCount != 0) {
            for (int i = gStart; i < used.length; i++) {
                if (used[i] != 0) continue;
                used[i] = 1;
                flower = seed(i + 1, rStart, gCount - 1, rCount, used);
                res = Math.max(res, flower);
                used[i] = 0;
            }

        } else {
            for (int i = rStart; i < used.length; i++) {
                if (used[i] != 0) continue;
                used[i] = 2;
                flower = seed(gStart, i + 1, gCount, rCount - 1, used);
                res = Math.max(res, flower);
                used[i] = 0;
            }
        }

        return res;
    }

    static int bfs(int[][] flowerMap, int[] flower) {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int[][] used = new int[flowerMap.length][flowerMap[0].length];
        Queue<Integer> startQ = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < flower.length; i++) {
            if (flower[i] != 0) {
                int yx = ground.get(i);
                startQ.offer(yx);
                used[yx / xSize][yx % xSize] = 1;
            }
        }

        int time = 1;

        while (!startQ.isEmpty()) {
            time++;
            q.addAll(startQ);
            startQ.clear();
            while (!q.isEmpty()) {
                int now = q.poll();
                int y = now / xSize;
                int x = now % xSize;
                int seed = flowerMap[y][x];
                if (flowerMap[y][x] == 5) continue;
                for (int i = 0; i < 4; i++) {
                    int nY = y + dy[i];
                    int nX = x + dx[i];

                    if (nY < 0 || nY >= ySize || nX < 0 || nX >= xSize) continue;
                    if (flowerMap[nY][nX] == 0 || flowerMap[nY][nX] == 5 || flowerMap[nY][nX] == seed) continue;
                    if (flowerMap[nY][nX] + seed == 7 && used[nY][nX] != time) continue;

                    used[nY][nX] = time;
                    if (flowerMap[nY][nX] + seed == 7) {
                        flowerMap[nY][nX] = 5;
                        res++;
                    } else {
                        flowerMap[nY][nX] = seed;
                        startQ.offer(nY * xSize + nX);
                    }


                }

            }

        }

        return res;


    }

}
