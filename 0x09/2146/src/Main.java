import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int size;
    static int[][] board;
    static int[][] island;
    static int[][] dist;
    static Queue<xy> islandQ = new LinkedList<>();
    static Queue<xy> findQ = new LinkedList<>();
    static Queue<xy> bridgeQ = new LinkedList<>();
    static int[][] nextPos = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        size = Integer.parseInt(br.readLine());
        board = new int[size][size];
        island = new int[size][size];
        dist = new int[size][size];
        for (int[] line : board) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                line[i] = Integer.parseInt(st.nextToken());
            }
        }


        findIsland();
//        print();
        int res = Integer.MAX_VALUE;
        while (!findQ.isEmpty()) {
            xy cur = findQ.poll();
            int bridgeLength = getBridgeLength(cur);
            if(res > bridgeLength) {
                res = bridgeLength;
            }
        }
        System.out.println(res-1);

    }


    static void findIsland() {
        int islandNum = 1;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (board[x][y] == 0 || island[x][y] >= 1) {
                    continue;
                }

                island[x][y] = islandNum;
                islandQ.offer(new xy(x, y, islandNum));
                while (!islandQ.isEmpty()) {
                    xy cur = islandQ.poll();
                    int curX = cur.getX();
                    int curY = cur.getY();
                    for (int i = 0; i < 4; i++) {
                        int nextX = curX + nextPos[i][0];
                        int nextY = curY + nextPos[i][1];

                        if (nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) {
                            continue;
                        }

                        if (island[nextX][nextY] >= 1) {
                            continue;
                        }

                        if (board[nextX][nextY] == 0) {
                            if (dist[curX][curY] != 1) {
                                dist[curX][curY] = 1;
                                findQ.offer(new xy(curX, curY, islandNum));
                            }
                            continue;
                        }

                        island[nextX][nextY] = islandNum;
                        islandQ.offer(new xy(nextX, nextY, islandNum));
                    }

                }
                islandNum++;
            }
        }
    }

    static int getBridgeLength(xy start) {
        int length = Integer.MAX_VALUE;

        dist = new int[size][size];;

        dist[start.getX()][start.getY()] = 1;
        bridgeQ.offer(start);

        while (!bridgeQ.isEmpty()) {
            xy cur = bridgeQ.poll();
            int curX = cur.getX();
            int curY = cur.getY();
            for (int i = 0; i < 4; i++) {
                int nextX = curX + nextPos[i][0];
                int nextY = curY + nextPos[i][1];

                if (nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) {
                    continue;
                }

                if ( dist[nextX][nextY] >= 1) {
                    continue;
                }

                if (board[nextX][nextY] == 1) {
                    if (cur.getIsland() != island[nextX][nextY]) {
                        if (length > dist[curX][curY]) length = dist[curX][curY];
                    }
                    continue;
                }
                dist[nextX][nextY] = dist[curX][curY] + 1;
                bridgeQ.offer(new xy(nextX, nextY, cur.getIsland()));
            }
        }
        return length;
    }

    private static void print() {
        for (int[] ints : island) {
            for (int anInt : ints) {
                System.out.printf("%2d ", anInt);
            }
            System.out.println();
        }

        while (!findQ.isEmpty()) {
            xy now = findQ.poll();
            island[now.getX()][now.getY()] = 7;
        }
        System.out.println();
        for (int[] ints : island) {
            for (int anInt : ints) {
                System.out.printf("%2d ", anInt);
            }
            System.out.println();
        }
    }

}

class xy {
    private int x;
    private int y;
    private int island;

    public xy(int x, int y, int island) {
        this.x = x;
        this.y = y;
        this.island = island;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIsland() {
        return island;
    }
}
