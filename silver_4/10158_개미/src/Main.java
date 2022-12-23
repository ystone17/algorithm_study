import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int w, h, p, q, t;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        sb.append(getP()).append(" ").append(getQ());
        System.out.println(sb);
    }

    private static int getP() {
        return (p + t) / w % 2 == 0 ? (p + t) % w : w - (p + t) % w;
    }

    private static int getQ() {
        return (q + t) / h % 2 == 0 ? (q + t) % h : h - (q + t) % h;
    }
}
