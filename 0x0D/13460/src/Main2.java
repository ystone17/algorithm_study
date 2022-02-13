import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    static int y, x;
    static Queue<Node> q = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        char[][] map = new char[y][x];
        visited = new int[y][x][y][x];

        Node initNode = new Node(0, 0, 0, 0, 0);
        q.offer(initNode);

        for (int yIdx = 0; yIdx < y; yIdx++) {
            st = new StringTokenizer(br.readLine());
            map[yIdx] = st.nextToken().toCharArray();
            for (int xIdx = 0; xIdx < map[yIdx].length; xIdx++) {
                if (map[yIdx][xIdx] == 'R') {
                    initNode.ry = yIdx;
                    initNode.rx = xIdx;
                    map[yIdx][xIdx] = '.';
                } else if (map[yIdx][xIdx] == 'B') {
                    initNode.by = yIdx;
                    initNode.bx = xIdx;
                    map[yIdx][xIdx] = '.';
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.ry][node.rx][node.by][node.bx] = 1;

            if (node.count >= 10) continue;

            for (int i = 0; i < 4; i++) {

                int by = node.by;
                int bx = node.bx;
                int ry = node.ry;
                int rx = node.rx;

                while (map[by + dy[i]][bx + dx[i]] != '#') {
                    by += dy[i];
                    bx += dx[i];
                    if (map[by][bx] == 'O') break;
                }

                if (map[by][bx] == 'O') continue;

                while (map[ry + dy[i]][rx + dx[i]] != '#') {
                    ry += dy[i];
                    rx += dx[i];
                    if (map[ry][rx] == 'O') break;
                }

                if (map[ry][rx] == 'O') {
                    System.out.println(node.count+1);
                    return;
                }

                if (ry == by && rx == bx) {
                    switch (i) {
                        case 0:
                            if (node.rx > node.bx) {
                                bx -= 1;
                            } else {
                                rx -= 1;
                            }
                            break;
                        case 1:
                            if (node.ry > node.by) {
                                by -= 1;
                            } else {
                                ry -= 1;
                            }
                            break;
                        case 2:
                            if (node.rx > node.bx) {
                                rx += 1;
                            } else {
                                bx += 1;
                            }
                            break;
                        case 3:
                            if (node.ry > node.by) {
                                ry += 1;
                            } else {
                                by += 1;
                            }
                            break;
                    }
                }

                if (visited[ry][rx][by][bx] != 1)
                    q.offer(new Node(ry, rx, by, bx, node.count + 1));


            }

        }

        System.out.println(-1);


    }
}

class Node {
    int ry;
    int rx;
    int by;
    int bx;
    int count;

    public Node(int ry, int rx, int by, int bx, int count) {
        this.ry = ry;
        this.rx = rx;
        this.by = by;
        this.bx = bx;
        this.count = count;
    }
}

