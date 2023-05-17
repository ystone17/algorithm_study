import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[][] board = new char[5][15];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            int x = 0;
            for (char c : br.readLine().toCharArray()) {
                board[i][x++] = c;
            }
        }

        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 5; y++) {
                if ((int) board[y][x] == 0) continue;
                sb.append(board[y][x]);
            }
        }

        System.out.println(sb);
    }
}
