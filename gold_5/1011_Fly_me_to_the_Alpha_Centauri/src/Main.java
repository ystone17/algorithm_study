import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int tc, x, y, dist, move, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            dist = y - x - 2;
            if (dist == -1) {
                sb.append(1).append("\n");
                continue;
            }
            move = 2;
            count = 0;

            while (true) {
                if (!moving()) break;
                if (!moving()) break;
                move++;
            }
            sb.append(count + 2).append("\n");
        }
        System.out.println(sb);
    }

    static boolean moving() {
        if (dist == 0) {
            return false;
        } else if (dist - move < 0) {
            count++;
            return false;
        } else {
            count++;
            dist -= move;
            return true;
        }
    }
}
