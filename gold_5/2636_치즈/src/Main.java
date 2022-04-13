import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int y, x;
    static int[][] map, visited;
    static Queue<Node> q = new LinkedList<>();
    static Queue<Node> melt = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = -1;
        int count = 0;

        while (true) {

            time++;
            visited = new int[y][x];

            q.add(new Node(0, 0));
            visited[0][0] = 1;
            map[0][0] = 2;
            int airCount = 1;
            while (!q.isEmpty()) {
                Node curNode = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = curNode.y + dy[i];
                    int nx = curNode.x + dx[i];

                    if (ny < 0 || ny >= y || nx < 0 || nx >= x) continue;
                    if (visited[ny][nx] == 1 || map[ny][nx] == 1) continue;

                    visited[ny][nx] = 1;
                    map[ny][nx] = 2;
                    airCount++;
                    q.add(new Node(ny, nx));
                }
            }

            if (airCount == y * x) break;
            count = 0;
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (visited[i][j] == 1 || map[i][j] != 1) continue;
                    q.add(new Node(i, j));
                    visited[i][j] = 1;
                    count++;

                    while (!q.isEmpty()) {
                        Node curNode = q.poll();
                        boolean isMelt = false;

                        for (int k = 0; k < 4; k++) {
                            int ny = curNode.y + dy[k];
                            int nx = curNode.x + dx[k];

                            if (ny < 0 || ny >= y || nx < 0 || nx >= x) continue;
                            if (map[ny][nx] == 2) isMelt = true;
                            if (visited[ny][nx] == 1 || map[ny][nx] == 0) continue;

                            visited[ny][nx] = 1;
                            count++;

                            q.add(new Node(ny, nx));

                        }
                        if (isMelt) melt.add(curNode);
                    }
                }
            }

            while (!melt.isEmpty()) {
                Node poll = melt.poll();
                map[poll.y][poll.x] = 2;
            }

        }

        System.out.println(time);
        System.out.println(count);

    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
