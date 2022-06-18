import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int horizontal = 0;
    static final int vertical = 1;
    static final int square = 2;

    static int[][] board = new int[9][9];
    static int[][][] used = new int[3][9][10];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < row.length; j++) {
                board[i][j] = Integer.parseInt(row[j]);
                used[horizontal][i][board[i][j]] = 1;
                used[vertical][j][board[i][j]] = 1;
                used[square][getSquareNum(i, j)][board[i][j]] = 1;
            }
        }

        sudoku(0, 0);

        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.printf("%d",anInt);
            }
            System.out.println();
        }
        System.out.println();

    }

    private static boolean sudoku(int y, int x) {
        if (y == 8 && x >= 9) {
            return true;
        }

        if (x >= 9) {
            return sudoku(y + 1, 0);
        }

        if (board[y][x] != 0) {
            return sudoku(y, x + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (used[horizontal][y][i] == 1) continue;
            if (used[vertical][x][i] == 1) continue;
            if (used[square][getSquareNum(y, x)][i] == 1) continue;

            used[horizontal][y][i] = 1;
            used[vertical][x][i] = 1;
            used[square][getSquareNum(y, x)][i] = 1;
            board[y][x] = i;
            boolean isSudoku = sudoku(y, x + 1);
            if(isSudoku) {
                return true;
            } else{
                used[horizontal][y][i] = 0;
                used[vertical][x][i] = 0;
                used[square][getSquareNum(y, x)][i] = 0;
                board[y][x] = 0;
            }
        }
        return false;
    }

    private static int getSquareNum(int y, int x) {
        return (y / 3) * 3 + (x / 3);
    }
}
