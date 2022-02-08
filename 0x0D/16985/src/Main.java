import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dx = {1, 0, -1, 0, 0, 0};


    public static void main(String[] args) throws IOException {
        int[][][] map = new int[5][5][5];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 25; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i / 5][i % 5][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] tempMap = new int[5][5][5];
        int temp;
        int min = Integer.MAX_VALUE;


        for (int i = 0; i < 1 << 10; i++) {
            temp = i;

            for (int floorNum = 0; floorNum < 5; floorNum++) {

                for (int y = 0; y < 5; y++) {
                    System.arraycopy(map[floorNum][y], 0, tempMap[floorNum][y], 0, map[floorNum][y].length);
                }

                for (int j = 0; j < temp % 4; j++) {
                    tempMap[floorNum] = rotate(tempMap[floorNum]);
                }

                temp /= 4;
            }

            int[][][] realMap = new int[5][5][5];
            int[] used = new int[5];
            for (int a = 0; a < 5; a++) {
                used[a] = 1;
                for (int b = 0; b < 5; b++) {
                    if(used[b] == 1) continue;
                    used[b] = 1;
                    for (int c = 0; c < 5; c++) {
                        if(used[c] == 1) continue;
                        used[c] = 1;
                        for (int d = 0; d < 5; d++) {
                            if(used[d] == 1) continue;
                            used[d] = 1;
                            for (int e = 0; e < 5; e++) {
                                if(used[e] == 1) continue;
                                realMap[0] = tempMap[a];
                                realMap[1] = tempMap[b];
                                realMap[2] = tempMap[c];
                                realMap[3] = tempMap[d];
                                realMap[4] = tempMap[e];
                                for (int gy = 0; gy <= 4; gy += 4) {
                                    for (int gx = 0; gx <= 4; gx += 4) {
                                        if (realMap[0][gy][gx] == 1 && realMap[4][4 - gy][4 - gx] == 1) {
                                            int tempMin = bfs(0, gy, gx, realMap);
                                            if (tempMin == -1) continue;
                                            min = Math.min(min, tempMin);
                                        }
                                    }
                                }
                            }
                            used[d] = 0;
                        }
                        used[c] = 0;
                    }
                    used[b] = 0;
                }
                used[a] = 0;
            }





        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);


    }

    static int[][] rotate(int[][] floor) {
        int[][] temp = new int[5][5];

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                temp[x][4 - y] = floor[y][x];
            }
        }
        return temp;
    }

    static int bfs(int z, int y, int x, int[][][] map) {
        int[] goal = {4 - z, 4 - y, 4 - x};

        boolean[][][] visited = new boolean[5][5][5];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{z, y, x, 0});
        visited[z][y][x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 6; i++) {
                int nz = now[0] + dz[i];
                int ny = now[1] + dy[i];
                int nx = now[2] + dx[i];
                int distance = now[3];

                if (nz < 0 || nz >= 5 || ny < 0 || ny >= 5 || nx < 0 || nx >= 5 || visited[nz][ny][nx]) continue;
                if (map[nz][ny][nx] != 1) continue;
                if (goal[0] == nz && goal[1] == ny && goal[2] == nx) {
                    return distance + 1;
                }

                visited[nz][ny][nx] = true;
                q.add(new int[]{nz, ny, nx, distance + 1});
            }
        }
        return -1;
    }


}
