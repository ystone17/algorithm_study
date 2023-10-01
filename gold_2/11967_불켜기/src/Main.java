import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final List<Position> emptyList = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, res;
    static Queue<Position> q = new LinkedList<>();
    static int[][] lightOnMap, visited;
    static Map<Position, List<Position>> switchMap = new HashMap<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lightOnMap = new int[n + 1][n + 1];
        visited = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Position position = new Position(y, x);
            List<Position> switchList = switchMap.getOrDefault(position, new ArrayList<>());
            switchList.add(new Position(a, b));
            switchMap.put(position, switchList);
        }

        q.add(new Position(1, 1));
        lightOnMap[1][1] = 1;
        while (!q.isEmpty()) {
            Position curPos = q.poll();
            if(visited[curPos.y][curPos.x] == 1) {
                continue;

            }

            visited[curPos.y][curPos.x] = 1;

            for (Position position : switchMap.getOrDefault(curPos, emptyList)) {
                lightOnMap[position.y][position.x] = 1;
                if (visited[position.y][position.x] == 1) {
                    continue;
                }
                if (canAddQueue(position)) {
                    q.add(position);
                }
            }

            for (int dir = 0; dir < 4; dir++) {
                int ny = curPos.y + dy[dir];
                int nx = curPos.x + dx[dir];

                if (ny < 1 || ny > n || nx < 1 || nx > n) {
                    continue;
                }

                if (visited[ny][nx] == 1) {
                    continue;
                }

                if (lightOnMap[ny][nx] != 1) {
                    continue;
                }

                q.add(new Position(ny, nx));
            }
        }

        for (int[] row : lightOnMap) {
            for (int i : row) {
                if(i == 1) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    private static boolean canAddQueue(Position position) {
        for (int dir = 0; dir < 4; dir++) {
            int ny = position.y + dy[dir];
            int nx = position.x + dx[dir];

            if (ny < 1 || ny > n || nx < 1 || nx > n) {
                continue;
            }

            if (lightOnMap[ny][nx] == 1) {
                return true;
            }
        }

        return false;
    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return y == position.y && x == position.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
