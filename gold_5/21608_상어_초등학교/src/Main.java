import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, ny, nx;
    static long result;
    static int[] fanSeq;
    static int[][] map;
    static Block[][] blockMap;
    static List<List<Integer>> fanListOfStar = new ArrayList<>();

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        read();
        play();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                result += blockMap[y][x].happy(map[y][x]);
            }
        }

        System.out.print(result);
    }

    private static void play() {
        for (int fan : fanSeq) {
            ny = -1;
            nx = -1;
            for (int y = n - 1; y >= 0; y--) {
                for (int x = n - 1; x >= 0; x--) {
                    if (map[y][x] != 0) {
                        continue;
                    }
                    ny = y;
                    nx = x;
                    break;
                }
                if (ny != -1) {
                    break;
                }
            }

            for (int y = n - 1; y >= 0; y--) {
                for (int x = n - 1; x >= 0; x--) {
                    if (map[y][x] != 0) {
                        continue;
                    }

                    int compare = blockMap[ny][nx].compare(blockMap[y][x], fan);
                    if (compare <= 0) {
                        ny = y;
                        nx = x;
                    }
                }
            }

            map[ny][nx] = fan;

            for (int i = 0; i < 4; i++) {
                int my = ny + dy[i];
                int mx = nx + dx[i];

                if (my < 0 || my >= n || mx < 0 || mx >= n) continue;
                blockMap[my][mx].sign(fan);
            }
        }
    }

    private static void read() throws IOException {
        n = Integer.parseInt(br.readLine());
        fanSeq = new int[n * n];
        map = new int[n][n];

        blockMap = new Block[n][n];

        for (int i = 0; i < n * n + 1; i++) {
            fanListOfStar.add(new ArrayList<>());
        }

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int fan = Integer.parseInt(st.nextToken());
            fanSeq[i] = fan;
            for (int j = 0; j < 4; j++) {
                int star = Integer.parseInt(st.nextToken());
                fanListOfStar.get(star).add(fan);
            }
        }

        blockMap = new Block[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (y == 0 || y == n - 1) {
                    if (x == 0 || x == n - 1) {
                        blockMap[y][x] = new Block(2);
                        continue;
                    }
                    blockMap[y][x] = new Block(3);
                    continue;
                }

                if (x == 0 || x == n - 1) {
                    blockMap[y][x] = new Block(3);
                    continue;
                }

                blockMap[y][x] = new Block(4);
            }
        }
    }

    static class Block {
        int[] starCount;
        int emptyCnt;


        public Block(int emptyCnt) {
            this.emptyCnt = emptyCnt;
            this.starCount = new int[n * n + 1];
        }

        void sign(int star) {
            for (Integer fan : fanListOfStar.get(star)) {
                starCount[fan]++;
            }
            emptyCnt--;
        }

        int compare(Block block, int fan) {
            if (this.starCount[fan] != block.starCount[fan]) {
                return Integer.compare(this.starCount[fan], block.starCount[fan]);
            }

            if (this.emptyCnt != block.emptyCnt) {
                return Integer.compare(this.emptyCnt, block.emptyCnt);
            }

            return 0;
        }

        int happy(int fan) {
            if (this.starCount[fan] == 0) {
                return 0;
            }
            int pow = (int) Math.pow(10, this.starCount[fan] - 1);
            return pow;
        }
    }
}
