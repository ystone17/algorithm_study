import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Map<Integer, Integer> countByBlockNumber = new HashMap<>();
    static Queue<Pos> q = new LinkedList<>();

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static int blockNumber = 1, yLen, xLen;
    static int[][] map, visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());

        map = new int[yLen][xLen];
        visited = new int[yLen][xLen];

        for (int y = 0; y < yLen; y++) {
            char[] row = br.readLine().toCharArray();
            for (int x = 0; x < xLen; x++) {
                map[y][x] = row[x] - '0';
            }
        }

        int count;
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (map[y][x] == 1 || visited[y][x] != 0) {
                    continue;
                }
                count = 0;
                visited[y][x] = blockNumber;

                q.add(new Pos(y, x));

                while (!q.isEmpty()) {
                    Pos cur = q.poll();
                    count++;

                    for (int dir = 0; dir < 4; dir++) {
                        int ny = cur.y + dy[dir];
                        int nx = cur.x + dx[dir];

                        if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) {
                            continue;
                        }

                        if (map[ny][nx] == 1 || visited[ny][nx] != 0) {
                            continue;
                        }

                        visited[ny][nx] = blockNumber;
                        q.add(new Pos(ny, nx));
                    }
                }

                countByBlockNumber.put(blockNumber++, count);
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (map[y][x] == 0) {
                    continue;
                }

                set.clear();

                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) {
                        continue;
                    }

                    if (visited[ny][nx] == 0) {
                        continue;
                    }

                    set.add(visited[ny][nx]);
                }

                map[y][x] = 1;
                for (Integer blockNumber : set) {
                    map[y][x] = (map[y][x] + countByBlockNumber.get(blockNumber)) % 10;
                }
            }
        }

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                sb.append(map[y][x]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
