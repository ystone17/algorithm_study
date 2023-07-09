import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int h, m, s, taskTime;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        taskTime = Integer.parseInt(br.readLine());
        h += taskTime / 3600;
        taskTime %= 3600;

        m += taskTime / 60;
        taskTime %= 60;

        s += taskTime;

        m += s / 60;
        s %= 60;

        h += m / 60;
        m %= 60;

        h %= 24;

        System.out.printf("%d %d %d", h, m, s);
    }
}
