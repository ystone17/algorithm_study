import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int h, m, time;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(br.readLine());

        h += (m + time) / 60;
        m = (m + time) % 60;
        h = h % 24;

        System.out.printf("%d %d", h, m);
    }
}
