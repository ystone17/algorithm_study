import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] nearXY = {
                {1, 0}, {0, 1}, {-1, 0}, {0, -1},
        };

        int[][] jumpXY = {
                {2, 1}, {1, 2},
                {-1, 2}, {-2, 1},
                {-2, -1}, {-1, -2},
                {1, -2}, {2, -1},
        };

        StringTokenizer st = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int jumpMax = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());
        int[][] board = new int[endY][endX];
        int[][][] dist = new int[endY][endX][jumpMax + 1];

        for (int y = 0; y < endY; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < endX; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }


        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            int jump = node.getJump();
            int nextJ = jump + 1;
            if (nextJ != jumpMax + 1) {
                for (int i = 0; i < 8; i++) {
                    int nextX = x + jumpXY[i][0];
                    int nextY = y + jumpXY[i][1];

                    if (nextX < 0 || nextX >= endX || nextY < 0 || nextY >= endY || board[nextY][nextX] == 1) {
                        continue;
                    }

                    if (dist[nextY][nextX][nextJ] > 0) {
                        continue;
                    }

                    q.offer(new Node(nextX, nextY, nextJ));
                    dist[nextY][nextX][nextJ] = dist[y][x][jump] + 1;
                }
            }


            for (int i = 0; i < 4; i++) {
                int nextX = x + nearXY[i][0];
                int nextY = y + nearXY[i][1];

                if (nextX < 0 || nextX >= endX || nextY < 0 || nextY >= endY || board[nextY][nextX] == 1) {
                    continue;
                }

                if (dist[nextY][nextX][jump] > 0) {
                    continue;
                }

                q.offer(new Node(nextX, nextY, jump));
                dist[nextY][nextX][jump] = dist[y][x][jump] + 1;
            }


        }
        int min = Integer.MAX_VALUE;
        for (int count : dist[endY - 1][endX - 1]) {
            if (min > count && count != 0) min = count;
        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min - 1);





    }


    static class Node {
        private int x;
        private int y;
        private int jump;

        public int getY() {
            return y;
        }

        public int getJump() {
            return jump;
        }

        public int getX() {
            return x;
        }

        public Node(int x, int y, int jump) {
            this.x = x;
            this.y = y;
            this.jump = jump;
        }
    }
}
