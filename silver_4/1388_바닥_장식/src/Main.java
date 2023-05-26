import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[][] board;
    static int y, x, res;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        board = new char[y][x];

        for (int yi = 0; yi < y; yi++) {
            board[yi] = br.readLine().toCharArray();
        }

        char base = '-';
        char before = ' ';
        for (int yi = 0; yi < y; yi++) {
            for (int xi = 0; xi < x; xi++) {
                if (board[yi][xi] == base && board[yi][xi] != before) {
                    res++;
                }

                before = board[yi][xi];
            }
            before = ' ';
        }


        base = '|';
        before = ' ';
        for (int xi = 0; xi < x; xi++) {
            for (int yi = 0; yi < y; yi++) {
                if (board[yi][xi] == base && board[yi][xi] != before) {
                    res++;
                }

                before = board[yi][xi];
            }
            before = ' ';
        }

        System.out.println(res);
    }
}
