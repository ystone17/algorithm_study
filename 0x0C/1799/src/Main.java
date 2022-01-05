import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[][][] vertex = new int[2][11][11];
    static int dx[] = {1, 1}, dy[] = {-1, 1};
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    static int N, n, m;
    static int[][] board;
    static boolean[] visit;
    static int[] bMatched;
    static int[] cnt = {1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int dir = 0; dir < 2; dir++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (board[x][y] == 1 && vertex[dir][x][y] == 0) {
                        int nx = x;
                        int ny = y;
                        while (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                            //같은 대각선에 대해 같은 번호를 갖는다.
                            if (board[nx][ny] == 1)
                                vertex[dir][nx][ny] = cnt[dir];
                            nx += dx[dir];
                            ny += dy[dir];
                        }
                        cnt[dir]++;
                    }
                }
            }
        }

        n = cnt[0]; //left
        m = cnt[1]; //right
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    //left와 right사이의 간선을 연결한다.
                    adj.get(vertex[0][i][j]).add(vertex[1][i][j]);
                }
            }
        }

        int ret = bipartite();
        System.out.println(ret);

    }

    static int bipartite() {
        visit = new boolean[n];
        bMatched = new int[m];
        int ret = 0;
        for (int i = 1; i < n; i++) {
            Arrays.fill(visit, false);
            if (dfs(i)) ret++;
        }
        return ret;


    }

    static boolean dfs(int left) {
        if (visit[left]) return false;
        visit[left] = true;
        for (int i = 0; i < adj.get(left).size(); i++) {
            int right = adj.get(left).get(i);
            if (bMatched[right] == 0 || dfs(bMatched[right])) {
                bMatched[right] = left;
                return true;
            }
        }
        return false;
    }
}
