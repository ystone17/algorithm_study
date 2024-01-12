import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int x, y, d, t;
    static double dist, reminder, res;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        reminder = dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        if ((double) d / t <= 1) {
            System.out.println(reminder);
            return;
        }

        while (reminder > d * 2) {
            res += t;
            reminder -= d;
        }

        double doubleJump = t * 2;
        double jumpAndWalk = t + (Math.abs(d - reminder));
        double walk = reminder;

        System.out.println(res + Math.min(doubleJump, Math.min(jumpAndWalk, walk)));
    }
}
