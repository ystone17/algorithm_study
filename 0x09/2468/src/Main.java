import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] nextPos = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int[][] board = null;
        int maxHeight = -1;
        int res = -1;
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (maxHeight < board[i][j]) maxHeight = board[i][j];
            }
        }

        for (int i = 0; i <= maxHeight; i++) {
            int groundNum = getGroundNumber(board,i);
            if(res < groundNum) res = groundNum;
            printBoard(board, i);
            System.out.println(groundNum);
            System.out.println();
        }
        System.out.println(res);



    }

    static int getGroundNumber(int[][] board, int n) {
        int[][] visited = new int[board.length][board.length];
        int groundNumb = 0;
        Queue<xy> Q = new LinkedList<>();

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if(visited[x][y] == 1 || board[x][y] <= n){
                    continue;
                }

                groundNumb++;
                visited[x][y] = 1;
                Q.offer(new xy(x,y));
                while (!Q.isEmpty()){
                    xy cur = Q.poll();
                    int curX = cur.getX();
                    int curY = cur.getY();
                    for (int i = 0; i < 4; i++) {
                        int nextX = curX + nextPos[i][0];
                        int nextY = curY + nextPos[i][1];

                        if(nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board.length ){
                            continue;
                        }

                        if(visited[nextX][nextY] == 1){
                            continue;
                        }

                        if(board[nextX][nextY] <= n){
                            continue;
                        }

                        xy next = new xy(nextX, nextY);
                        visited[nextX][nextY] = 1;
                        Q.offer(next);
                    }
                }


            }
        }
        return groundNumb;
    }


    static void printBoard(int[][] board, int n) {
        System.out.println(n + "st board");
        for (int[] line : board) {
            for (int ele : line) {
                if (ele <= n) {
                    System.out.printf("%2s ", "=");
                } else {
                    System.out.printf("%2d ", ele);
                }
            }
            System.out.println();
        }
    }
}

class xy{
    private int x;
    private int y;

    public xy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}