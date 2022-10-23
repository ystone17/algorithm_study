import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[] board;

    public static void main(String[] args) throws IOException {
        board = br.readLine().toCharArray();

        int cnt = 0;
        for (char cell : board) {
            if (cell == '.') {
                if (cnt % 2 == 1) {
                    System.out.println(-1);
                    return;
                }

                while (cnt > 0) {
                    if (cnt >= 4) {
                        sb.append("AAAA");
                        cnt -= 4;
                    } else {
                        sb.append("BB");
                        cnt -= 2;
                    }
                }
                sb.append(".");
            } else {
                cnt++;
            }
        }

        while (cnt > 0) {
            if (cnt % 2 == 1) {
                System.out.println(-1);
                return;
            }

            if (cnt >= 4) {
                sb.append("AAAA");
                cnt -= 4;
            } else {
                sb.append("BB");
                cnt -= 2;
            }
        }
        System.out.println(sb);
    }
}
