import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, j;
    static int start, end, sum;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        start = 1;
        end = start + m - 1;

        j = Integer.parseInt(br.readLine());

        for (int i = 0; i < j; i++) {
            int line = Integer.parseInt(br.readLine());
            sum += move(line);
        }

        System.out.println(sum);
    }

    private static int move(int line) {
        if (start <= line && line <= end) {
            return 0;
        }

        if (end < line) {
            int sub = line - end;

            start += sub;
            end += sub;

            return sub;
        }

        int sub = start - line;

        start -= sub;
        end -= sub;

        return sub;
    }
}
