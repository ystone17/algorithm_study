import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[][] map;
    static int[][][] visited;

    static Queue<Tree> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        Tree bTree = new Tree();
        Tree eTree = new Tree();

        for (int y = 0; y < n; y++) {
            char[] row = br.readLine().toCharArray();

            for (int x = 0; x < n; x++) {
                char cell = row[x];
                if (cell == 'B') {
                    bTree.addPos(new Pos(y, x));
                    continue;
                }

                if (cell == 'E') {
                    eTree.addPos(new Pos(y, x));
                    continue;
                }

                map[y][x] = cell - '0';
            }
        }

        visited = new int[2][n][n];
        for (int dir = 0; dir < 2; dir++) {
            for (int y = 0; y < n; y++) {
                Arrays.fill(visited[dir][y], 123_456_789);
            }
        }

        int cnt = 0;
        bTree.checkDir();
        eTree.checkDir();
        Pos middleCell = bTree.middleCell();
        q.add(bTree);
        visited[bTree.dir][middleCell.y][middleCell.x] = cnt;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Tree cur = q.poll();

                if (cur.isSame(eTree)) {
                    System.out.println(cnt);
                    return;
                }

                if (cur.canDown()) {
                    Tree down = cur.down();
                    Pos mid = down.middleCell();
                    if (cnt < visited[down.dir][mid.y][mid.x]) {
                        q.add(down);
                        visited[down.dir][mid.y][mid.x] = cnt;
                    }
                }

                if (cur.canLeft()) {
                    Tree left = cur.left();
                    Pos mid = left.middleCell();
                    if (cnt < visited[left.dir][mid.y][mid.x]) {
                        q.add(left);
                        visited[left.dir][mid.y][mid.x] = cnt;
                    }
                }

                if (cur.canRight()) {
                    Tree right = cur.right();
                    Pos mid = right.middleCell();
                    if (cnt < visited[right.dir][mid.y][mid.x]) {
                        q.add(right);
                        visited[right.dir][mid.y][mid.x] = cnt;
                    }
                }
                if (cur.canUp()) {
                    Tree up = cur.up();
                    Pos mid = up.middleCell();
                    if (cnt < visited[up.dir][mid.y][mid.x]) {
                        q.add(up);
                        visited[up.dir][mid.y][mid.x] = cnt;
                    }
                }
                if (cur.canRotate()) {
                    Tree rotate = cur.rotate();
                    Pos mid = rotate.middleCell();
                    if (cnt < visited[rotate.dir][mid.y][mid.x]) {
                        q.add(rotate);
                        visited[rotate.dir][mid.y][mid.x] = cnt;
                    }
                }
            }

            cnt++;
        }

        System.out.println(0);


    }

    static class Tree {
        private static int[] rotateDy = {0, 1, 1, 1, 0, -1, -1, -1};
        private static int[] rotateDx = {1, 1, 0, -1, -1, -1, 0, 1};

        private int dir;
        private List<Pos> posList = new ArrayList<>();

        private Pos middleCell() {
            return posList.get(1);
        }

        private void checkDir() {
            if (posList.get(0).y == posList.get(1).y) {
                this.dir = 0;
                return;
            }

            this.dir = 1;
        }

        private void addPos(Pos pos) {
            posList.add(pos);
        }

        private boolean canUp() {
            for (Pos pos : posList) {
                if (pos.y - 1 < 0) {
                    return false;
                }

                if (map[pos.y - 1][pos.x] == 1) {
                    return false;
                }
            }

            return true;
        }

        private Tree up() {
            Tree tree = new Tree();
            tree.dir = this.dir;

            for (Pos pos : this.posList) {
                tree.addPos(new Pos(pos.y - 1, pos.x));
            }

            return tree;
        }

        private boolean canDown() {
            for (Pos pos : posList) {
                if (pos.y + 1 >= n) {
                    return false;
                }

                if (map[pos.y + 1][pos.x] == 1) {
                    return false;
                }
            }

            return true;
        }

        private Tree down() {
            Tree tree = new Tree();
            tree.dir = this.dir;

            for (Pos pos : this.posList) {
                tree.addPos(new Pos(pos.y + 1, pos.x));
            }

            return tree;
        }

        private boolean canLeft() {
            for (Pos pos : posList) {
                if (pos.x - 1 < 0) {
                    return false;
                }

                if (map[pos.y][pos.x - 1] == 1) {
                    return false;
                }
            }

            return true;
        }

        private Tree left() {
            Tree tree = new Tree();
            tree.dir = this.dir;

            for (Pos pos : this.posList) {
                tree.addPos(new Pos(pos.y, pos.x - 1));
            }

            return tree;
        }

        private boolean canRight() {
            for (Pos pos : posList) {
                if (pos.x + 1 >= n) {
                    return false;
                }

                if (map[pos.y][pos.x + 1] == 1) {
                    return false;
                }
            }

            return true;
        }

        private Tree right() {
            Tree tree = new Tree();
            tree.dir = this.dir;

            for (Pos pos : this.posList) {
                tree.addPos(new Pos(pos.y, pos.x + 1));
            }

            return tree;
        }

        private boolean canRotate() {
            Pos mid = this.middleCell();

            for (int dir = 0; dir < 8; dir++) {
                int ny = mid.y + rotateDy[dir];
                int nx = mid.x + rotateDx[dir];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                    return false;
                }
                if (map[ny][nx] == 1) {
                    return false;
                }
            }

            return true;
        }

        private Tree rotate() {
            Tree tree = new Tree();
            Pos mid = this.middleCell();

            if (this.dir == 0) {
                tree.addPos(new Pos(mid.y - 1, mid.x));
                tree.addPos(new Pos(mid.y, mid.x));
                tree.addPos(new Pos(mid.y + 1, mid.x));
            } else {
                tree.addPos(new Pos(mid.y, mid.x - 1));
                tree.addPos(new Pos(mid.y, mid.x));
                tree.addPos(new Pos(mid.y, mid.x + 1));
            }

            tree.checkDir();
            return tree;
        }

        private boolean isSame(Tree tree) {
            if (this.dir != tree.dir) {
                return false;
            }

            for (int i = 0; i < 3; i++) {
                Pos pos = this.posList.get(0);
                Pos inputPos = tree.posList.get(0);

                if (pos.y != inputPos.y || pos.x != inputPos.x) {
                    return false;
                }
            }

            return true;
        }
    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
