import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, minTime = Integer.MAX_VALUE;
    static int[][] originMap, simulationMap, visited;
    static int[] activeViruses;
    static List<Position> virusPositions = new ArrayList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Queue<Position> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        originMap = new int[n][n];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                originMap[y][x] = Integer.parseInt(st.nextToken());
                if (originMap[y][x] == 2) {
                    virusPositions.add(new Position(y, x));
                }
            }
        }

        activeViruses = new int[virusPositions.size()];
        chooseActiveVirus(0, 0);
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    private static void chooseActiveVirus(int startIdx, int count) {
        if (count >= m) {
            int time = simulation();
            minTime = Math.min(minTime, time);
            return;
        }

        for (int i = startIdx; i < activeViruses.length; i++) {
            activeViruses[i] = 1;
            chooseActiveVirus(i + 1, count + 1);
            activeViruses[i] = 0;
        }
    }

    private static int simulation() {
        initSimulationMap();
        activeVirus();


        int time = 0;
        while (!isFullVirus()) {
            if (q.isEmpty()) {
                break;
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Position cur = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int ny = cur.y + dy[dir];
                    int nx = cur.x + dx[dir];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                        continue;
                    }
                    if (visited[ny][nx] == 1) {
                        continue;
                    }
                    if (simulationMap[ny][nx] == 1 || simulationMap[ny][nx] == 3) {
                        continue;
                    }

                    visited[ny][nx] = 1;
                    simulationMap[ny][nx] = 3;
                    q.add(new Position(ny, nx));
                }
            }
            time++;
        }

        return isFullVirus() ? time : Integer.MAX_VALUE;
    }

    private static void initSimulationMap() {
        simulationMap = new int[n][n];
        for (int y = 0; y < n; y++) {
            System.arraycopy(originMap[y], 0, simulationMap[y], 0, n);
        }


    }

    private static void activeVirus() {
        visited = new int[n][n];
        q.clear();

        for (int i = 0; i < activeViruses.length; i++) {
            if (activeViruses[i] == 1) {
                Position cur = virusPositions.get(i);
                simulationMap[cur.y][cur.x] = 3;
                q.add(new Position(cur.y, cur.x));
                visited[cur.y][cur.x] = 1;
            }
        }
    }

    private static boolean isFullVirus() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (simulationMap[y][x] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
