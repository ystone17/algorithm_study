import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc, x1, y1, r1, x2, y2, r2;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());

            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            if(r1 == 0 || r2 == 0) {
                sb.append(1).append("\n");
                continue;
            }

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append(-1).append("\n");
                continue;
            }

            double d = dist(x1, y1, x2, y2);
            int rPlus = r1 + r2;
            int rMinus = Math.abs(r1 - r2);

            if (d < rMinus) {
                sb.append(0).append("\n");
                continue;
            }

            if (d == rMinus) {
                sb.append(1).append("\n");
                continue;
            }

            if (d < rPlus) {
                sb.append(2).append("\n");
                continue;
            }

            if (d == rPlus) {
                sb.append(1).append("\n");
                continue;
            }

            sb.append(0).append("\n");
        }

        System.out.println(sb);

    }

    public static double dist(int x1, int y1, int x2, int y2) {
        double xP = Math.pow(x1 - x2, 2);
        double yP = Math.pow(y1 - y2, 2);


        return Math.sqrt(xP + yP);
    }
}
