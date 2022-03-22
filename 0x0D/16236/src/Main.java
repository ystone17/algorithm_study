import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] ocean, visited;
    static Queue<Coordinate> q = new LinkedList<>();
    static Queue<Coordinate> startQ = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ocean = new int[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                ocean[y][x] = Integer.parseInt(st.nextToken());
                if (ocean[y][x] == 9) {
                    startQ.add(new Coordinate(y, x, 0));
                }
            }
        }

        int minDist = Integer.MAX_VALUE;
        int sharkSize = 2;
        int feedingNum = 0;
        int res = 0;
        while (true) {
            visited = new int[N][N];
            Coordinate poll = startQ.poll();
            visited[poll.y][poll.x] = 1;
            ocean[poll.y][poll.x] = 0;
            q.add(poll);

            while (!q.isEmpty()) {
                Coordinate cur = q.poll();
                if (minDist == cur.dist) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                    if(visited[ny][nx] == 1 )continue;
                    if (ocean[ny][nx] > sharkSize) continue;
                    if (ocean[ny][nx] < sharkSize && ocean[ny][nx] != 0) {
                        if (startQ.isEmpty()) {
                            startQ.add(new Coordinate(ny, nx, 0));
                        } else {
                            startQ.add(findNear(startQ.poll(), ny, nx, 0));
                        }

                        minDist = cur.dist + 1;
                        continue;
                    }

                    q.add(new Coordinate(ny, nx, cur.dist + 1));
                    visited[ny][nx] = 1;
                }
            }
            if(startQ.isEmpty()) break;
            if (++feedingNum == sharkSize) {
                sharkSize++;
                feedingNum = 0;
            }
            res += minDist == Integer.MAX_VALUE ? 0 : minDist;
            minDist = Integer.MAX_VALUE;
        }

        System.out.println(res);
    }

    static Coordinate findNear(Coordinate c1, int y, int x, int dist) {
        if (c1.y > y) {
            return new Coordinate(y, x, dist);
        } else if (c1.y < y) {
            return c1;
        } else if (c1.x > x) {
            return new Coordinate(y, x, dist);
        } else {
            return c1;
        }
    }
}

class Coordinate {
    int y;
    int x;
    int dist;

    public Coordinate(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}
