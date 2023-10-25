import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        int n, k;
        int[][] colorBoard;
        List<List<List<Piece>>> pieceBoard = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        colorBoard = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            ArrayList<List<Piece>> row = new ArrayList<>();
            for (int j = 0; j < n + 1; j++) {
                row.add(new ArrayList<>());
            }
            pieceBoard.add(row);
        }

        for (int y = 1; y <= n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= n; x++) {
                colorBoard[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            pieceBoard.get(y).get(x).add(new Piece(i + 1, dir));
        }

        Game game = new Game(colorBoard, pieceBoard, n, k);
        System.out.println(game.play());
    }


}

class Game {
    private final int WHITE = 0, RED = 1, BLUE = 2;
    private final int[] dy = {0, -1, 0, 1};
    private final int[] dx = {1, 0, -1, 0};
    private final int n;
    private final int k;

    private int[][] colorBoard;
    private List<List<List<Piece>>> pieceBoard;
    private int maxSize;

    public Game(int[][] colorBoard, List<List<List<Piece>>> pieceBoard, int n, int k) {
        this.colorBoard = colorBoard;
        this.pieceBoard = pieceBoard;
        this.n = n;
        this.k = k;
    }

    public int play() {
        int turn;
        boolean done;
        maxSize = -1;

        for (turn = 1; turn <= 1000; turn++) {
            for (int cur = 1; cur <= k; cur++) {
                done = false;

                for (int y = 1; y <= n; y++) {
                    if (done) {
                        break;
                    }

                    for (int x = 1; x <= n; x++) {
                        List<Piece> spot = pieceBoard.get(y).get(x);
                        if (spot.isEmpty()) {
                            continue;
                        }

                        if (spot.get(0).getNum() != cur) {
                            continue;
                        }

                        Piece curPiece = spot.get(0);
                        int ny = y + dy[curPiece.getDir()];
                        int nx = x + dx[curPiece.getDir()];

                        if (ny <= 0 || ny > n || nx <= 0 || nx > n ||colorBoard[ny][nx] == BLUE) {
                            curPiece.reversDir();
                            ny = y + dy[curPiece.getDir()];
                            nx = x + dx[curPiece.getDir()];

                            if (ny > 0 && ny <= n && nx > 0 && nx <= n && colorBoard[ny][nx] != BLUE) {
                                if (colorBoard[ny][nx] == WHITE) {
                                    moveWhite(y, x, ny, nx, spot);
                                } else {
                                    moveRed(y, x, ny, nx, spot);
                                }
                            }

                            done = true;
                            break;
                        }

                        if (colorBoard[ny][nx] == WHITE) {
                            moveWhite(y, x, ny, nx, spot);

                            done = true;
                            break;
                        }

                        if (colorBoard[ny][nx] == RED) {
                            moveRed(y, x, ny, nx, spot);

                            done = true;
                            break;
                        }


                    }
                }
            }

            if (maxSize >= 4) {
                break;
            }
        }

        return turn == 1001 ? -1 : turn;
    }

    private void moveRed(int y, int x, int ny, int nx, List<Piece> spot) {
        for (int i = spot.size() - 1; i >= 0; i--) {
            pieceBoard.get(ny).get(nx).add(spot.get(i));
        }
        pieceBoard.get(y).get(x).clear();

        maxSize = Math.max(maxSize, pieceBoard.get(ny).get(nx).size());
    }

    private void moveWhite(int y, int x, int ny, int nx, List<Piece> spot) {
        pieceBoard.get(ny).get(nx).addAll(spot);
        pieceBoard.get(y).get(x).clear();

        maxSize = Math.max(maxSize, pieceBoard.get(ny).get(nx).size());
    }
}

class Piece {
    private int num;
    private int dir;

    public Piece(int num, int dir) {
        this.num = num;
        this.dir = convertDir(dir);
    }

    public void reversDir() {
        this.dir = (dir + 2) % 4;
    }

    public int getNum() {
        return num;
    }

    public int getDir() {
        return dir;
    }

    private int convertDir(int dir) {
        switch (dir) {
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 1;
            case 4:
                return 3;
        }

        return dir;
    }
}
