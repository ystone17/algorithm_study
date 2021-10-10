import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Queue<loc> q;
    static char[][][] building;
    static int[][][] dist;
    static int[][] nextPos = {
            {1, 0, 0},
            {-1, 0, 0},
            {0, -1, 0},
            {0, 1, 0},
            {0, 0, 1},
            {0, 0, -1}
    };

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int z = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (z == 0) {
                break;
            }

            bw.write(escape(x, y, z));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }


    private static String escape(int x, int y, int z) throws IOException {
        q = new LinkedList<>();
        building = new char[z][x][y];
        dist = new int[z][x][y];
        loc startLoc = null;
        loc endLoc = null;
        for (int Z = 0; Z < z; Z++) {
            for (int X = 0; X < x; X++) {
                char[] line = br.readLine().toCharArray();
                for (int Y = 0; Y < y; Y++) {
                    building[Z][X][Y] = line[Y];
                    if (line[Y] == 'S') {
                        startLoc = new loc(X, Y, Z);
                    } else if (line[Y] == 'E') {
                        endLoc = new loc(X, Y, Z);
                    }
                }
            }
            br.readLine();
        }

        dist[startLoc.getZ()][startLoc.getX()][startLoc.getY()] = 1;
        q.offer(startLoc);

        while (!q.isEmpty()) {
            loc now = q.poll();
            int nowZ = now.getZ();
            int nowX = now.getX();
            int nowY = now.getY();

            for (int i = 0; i < 6; i++) {
                int nextZ = nowZ + nextPos[i][0];
                int nextX = nowX + nextPos[i][1];
                int nextY = nowY + nextPos[i][2];

                if (nextZ < 0 || nextZ >= z || nextX < 0 || nextX >= x || nextY < 0 || nextY >= y) {
                    continue;
                }

                if (building[nextZ][nextX][nextY] == '#') {
                    continue;
                }

                if (dist[nextZ][nextX][nextY] > 0) {
                    continue;
                }

                dist[nextZ][nextX][nextY] = dist[nowZ][nowX][nowY] + 1;
                q.offer(new loc(nextX, nextY, nextZ));

                if (endLoc.getZ() == nextZ && endLoc.getX() == nextX && endLoc.getY() == nextY) {
                    return String.format("Escaped in %d minute(s).", dist[nextZ][nextX][nextY] - 1);
                }
            }
        }
        return "Trapped!";
    }

    private static void printBuilding(int x, int y, int z) {
        System.out.println();
        for (int Z = 0; Z < z; Z++) {
            for (int X = 0; X < x; X++) {
                for (int Y = 0; Y < y; Y++) {
                    System.out.printf("%2c", building[Z][X][Y]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

class loc {
    private final int x;
    private final int y;
    private final int z;

    public loc(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
