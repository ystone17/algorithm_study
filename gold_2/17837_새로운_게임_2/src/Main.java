import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k;
    static int[][] map;
    static List<List<Deque<Integer>>> pieceMap = new ArrayList<>();
    static piece[] pieces;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            pieceMap.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                pieceMap.get(i).add(new LinkedList<>());
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int row, col, dir;
        pieces = new piece[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken()) - 1;
            col = Integer.parseInt(st.nextToken()) - 1;
            dir = Integer.parseInt(st.nextToken());
            if (dir == 2) {
                dir = 3;
            } else if (dir == 3) {
                dir = 2;
            }

            piece piece = new piece(row, col, dir - 1);
            pieces[i] = piece;
            pieceMap.get(row).get(col).add(i);
        }

        Deque<Integer> temp;
        for (int cnt = 1; cnt <= 1000; cnt++) {
            for (int i = 0; i < pieces.length; i++) {
                piece cur = pieces[i];

                int ny = cur.y + dy[cur.dir];
                int nx = cur.x + dx[cur.dir];
                int nDir = cur.dir;

                if ((ny < 0 || ny >= n || nx < 0 || nx >= n) || map[ny][nx] == 2) {
                    nDir = (nDir + 2) % 4;
                    ny = cur.y + dy[nDir];
                    nx = cur.x + dx[nDir];

                    if ((ny < 0 || ny >= n || nx < 0 || nx >= n) || map[ny][nx] == 2) {
                        cur.dir = nDir;
                        continue;
                    }
                }

                temp = new LinkedList<>();
                Deque<Integer> curDeque = pieceMap.get(cur.y).get(cur.x);
                while (true) {
                    temp.addFirst(curDeque.pollLast());
                    if (temp.peekFirst() == i) break;
                }

                Deque<Integer> nextPos = pieceMap.get(ny).get(nx);
                cur.dir = nDir;
                if (map[ny][nx] == 1) {
                    while (!temp.isEmpty()) {
                        nextPos.addLast(temp.pollLast());
                        pieces[nextPos.peekLast()].y = ny;
                        pieces[nextPos.peekLast()].x = nx;
                    }
                } else {
                    while (!temp.isEmpty()) {
                        nextPos.addLast(temp.pollFirst());
                        pieces[nextPos.peekLast()].y = ny;
                        pieces[nextPos.peekLast()].x = nx;
                    }
                }

                if (nextPos.size() >= 4) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    static class piece {
        int y;
        int x;
        int dir;

        public piece(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "piece{" + "y=" + y + ", x=" + x + ", dir=" + dir + '}';
        }
    }
}
