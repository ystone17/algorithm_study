import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int mapLen, guestNum, fuel;
    static int[][] map;
    static int[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Queue<Pos> q;
    static List<Route> routes = new ArrayList<>();
    static Pos now;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        mapLen = Integer.parseInt(st.nextToken());
        guestNum = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[mapLen + 1][mapLen + 1];
        for (int y = 0; y < mapLen; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < mapLen; x++) {
                map[y + 1][x + 1] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int cy = Integer.parseInt(st.nextToken());
        int cx = Integer.parseInt(st.nextToken());
        now = new Pos(cy, cx);

        for (int i = 0; i < guestNum; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            routes.add(new Route(new Pos(sy, sx), new Pos(ey, ex)));
        }

        for (int i = 0; i < guestNum; i++) {
            if (!drive()) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(fuel);

    }

    private static boolean drive() {
        if (routes.isEmpty()) return false;
        int dist = 1000;
        Route next = null;

        findPos(now);
        for (Route route : routes) {
            int min = visited[route.start.y][route.start.x] - 1;
            if (dist > min) {
                dist = min;
                next = route;
            } else if (dist == min) {
                if (next.start.y > route.start.y || (next.start.y == route.start.y && next.start.x > route.start.x)) {
                    next = route;
                }
            }
        }
        if(dist == -1) return false;
        fuel -= dist;
        now = next.start;

        if (fuel < 0) return false;

        dist = minDist(now, next.end);
        if(dist == -1) return false;
        fuel -= dist;
        if (fuel < 0) return false;
        fuel += dist * 2;
        now = next.end;

        routes.remove(next);

        return true;
    }

    static int minDist(Pos start, Pos end) {
        visited = new int[mapLen + 1][mapLen + 1];

        q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = 1;

        int dist = -1;

        while (!q.isEmpty()) {
            dist++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pos cur = q.poll();

                if (cur.y == end.y && cur.x == end.x) return dist;

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny <= 0 || ny > mapLen || nx <= 0 || nx > mapLen) continue;
                    if (map[ny][nx] == 0 && visited[ny][nx] == 0) {
                        visited[ny][nx] = 1;
                        q.add(new Pos(ny, nx));
                    }
                }
            }
        }
        return -1;
    }

    static void findPos(Pos start) {
        visited = new int[mapLen + 1][mapLen + 1];

        q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = 1;

        int dist = 1;

        while (!q.isEmpty()) {
            dist++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pos cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny <= 0 || ny > mapLen || nx <= 0 || nx > mapLen) continue;
                    if (map[ny][nx] == 0 && visited[ny][nx] == 0) {
                        visited[ny][nx] = dist;
                        q.add(new Pos(ny, nx));
                    }
                }
            }
        }
    }

    static class Route {
        Pos start;
        Pos end;

        public Route(Pos start, Pos end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
