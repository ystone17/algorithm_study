import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int[][] points;
    static double answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        int n, y, x;

        for (int t = 0; t < tc; t++) {
            n = Integer.parseInt(br.readLine());
            y = 0;
            x = 0;
            points = new int[n][2];
            answer = Double.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
                y += points[i][0];
                x += points[i][1];
            }

            solve(0, 0, y, x);
            sb.append(Math.sqrt(answer)).append("\n");
        }
        System.out.println(sb);

    }

    static void solve(int index, int count, int y, int x) {
        if (count == points.length / 2) {
            answer = Math.min(answer, (double) y * y + (double) x * x);
            return;
        }

        for (int i = index; i < points.length; i++) {
            solve(index + 1, count + 1, y - 2 * points[i][0], x - 2 * points[i][1]);
        }
    }

}