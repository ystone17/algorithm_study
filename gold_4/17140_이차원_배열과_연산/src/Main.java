import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int r, c, k;
    static int[][] board = new int[100][100];
    static int xLen = 3, yLen = 3;
    static int[] cntSort = new int[101];
    static PriorityQueue<Pos> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (board[r][c] == k) {
            System.out.println(0);
            return;
        }

        for (int t = 0; t < 100; t++) {

            if (yLen >= xLen) {
                for (int y = 0; y < yLen; y++) {
                    cntSort = new int[101];
                    pq.clear();
                    for (int i = 0; i < xLen; i++) {
                        if (board[y][i] == 0) continue;
                        cntSort[board[y][i]]++;
                    }

                    for (int i = 1; i < cntSort.length; i++) {
                        if (cntSort[i] == 0) continue;
                        pq.add(new Pos(i, cntSort[i]));
                    }

                    int idx = 0;
                    Arrays.fill(board[y], 0);
                    while (!pq.isEmpty() && idx < 100) {
                        Pos cur = pq.poll();
                        board[y][idx] = cur.num;
                        board[y][idx + 1] = cur.cnt;
                        idx += 2;
                    }
                    xLen = Math.max(xLen, idx);
                }
            } else {

                for (int x = 0; x < xLen; x++) {
                    cntSort = new int[101];
                    pq.clear();
                    for (int i = 0; i < yLen; i++) {
                        if (board[i][x] == 0) continue;
                        cntSort[board[i][x]]++;
                    }

                    for (int i = 1; i < cntSort.length; i++) {
                        if (cntSort[i] == 0) continue;
                        pq.add(new Pos(i, cntSort[i]));
                    }

                    int idx = 0;
                    while (!pq.isEmpty() && idx < 100) {
                        Pos cur = pq.poll();
                        board[idx][x] = cur.num;
                        board[idx + 1][x] = cur.cnt;
                        idx += 2;
                    }

                    yLen = Math.max(yLen, idx);
                    for (int i = idx; i < yLen; i++) {
                        board[i][x] = 0;
                    }
                }

            }

            if (board[r][c] == k) {
                System.out.println(t + 1);
                return;
            }
        }

        System.out.println(-1);
    }

    static class Pos implements Comparable<Pos> {
        int num;
        int cnt;

        public Pos(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pos o) {
            if (cnt == o.cnt) {
                return Integer.compare(num, o.num);
            } else {
                return Integer.compare(cnt, o.cnt);
            }
        }
    }
}
