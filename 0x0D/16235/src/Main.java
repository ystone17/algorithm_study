import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k;
    static int[][] a, board;
    static Map<Integer, List<Integer>> treeByYX = new HashMap<>();
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1,};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n + 1][n + 1];
        board = new int[n + 1][n + 1];

        for (int y = 1; y < n + 1; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x < n + 1; x++) {
                a[y][x] = Integer.parseInt(st.nextToken());
                board[y][x] = 5;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            List<Integer> orDefault = treeByYX.getOrDefault((y - 1) * n + x, new ArrayList<>());
            orDefault.add(z);
            treeByYX.put((y - 1) * n + x, orDefault);
        }

        for (int i = 0; i < k; i++) {
            springAndSummer();

            fall();
            winter();
        }

        int answer = 0;

        for (Integer yx : treeByYX.keySet()) {
            answer += treeByYX.get(yx).size();
        }

        System.out.println(answer);

    }

    static void springAndSummer() {
        for (Integer yx : treeByYX.keySet()) {
            int y = ((yx - 1) / n) + 1;
            int x = (yx - 1) % n + 1;

            List<Integer> trees = treeByYX.get(yx);
            if (trees.size() > 1) Collections.sort(trees);

            for (int i = 0; i < trees.size(); i++) {
                int tree = trees.get(i);
                if (board[y][x] < tree) {
                    int size = trees.size();
                    for (int j = 0; j < size - i; j++) {
                        board[y][x] += trees.get(trees.size() - 1) / 2;
                        trees.remove(trees.size() - 1);
                    }
                    break;
                } else {
                    board[y][x] -= tree;
                    trees.set(i, tree + 1);
                }
            }
        }
    }

    static void fall() {

        int[][] temp = new int[n + 1][n + 1];

        for (Integer yx : treeByYX.keySet()) {
            int y = ((yx - 1) / n) + 1;
            int x = (yx - 1) % n + 1;

            List<Integer> trees = treeByYX.get(yx);

            int cnt = 0;

            for (Integer tree : trees) {
                if (tree % 5 == 0) cnt++;
            }

            if (cnt == 0) continue;

            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 1 || ny > n || nx < 1 || nx > n) continue;

                temp[ny][nx] += cnt;
            }
        }

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                if(temp[y][x] == 0) continue;

                List<Integer> orDefault = treeByYX.getOrDefault((y - 1) * n + x, new ArrayList<>());
                for (int i = 0; i < temp[y][x]; i++) {
                    orDefault.add(1);
                }
                treeByYX.put((y - 1) * n + x, orDefault);
            }
        }


    }

    static void winter() {
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                board[y][x] += a[y][x];
            }
        }
    }

}
