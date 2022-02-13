import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, res = Integer.MAX_VALUE;
    static int[][] points;
    static int[] entry;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        points = new int[n][n];
        entry = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        req(0, 0);
        System.out.println(res);

    }

    static void req(int start, int num) {
        if (num == n / 2) {
            int a = 0, b = 0;

            for (int i = 0; i < entry.length; i++) {
                if (entry[i] == 0) {
                    for (int j = i + 1; j < entry.length; j++) {
                        if (entry[j] == 0) {
                            a += points[i][j];
                            a += points[j][i];
                        }
                    }
                }

                if (entry[i] == 1) {
                    for (int j = i + 1; j < entry.length; j++) {
                        if (entry[j] == 1) {
                            b += points[i][j];
                            b += points[j][i];
                        }
                    }
                }

            }

            int abs = Math.abs(a - b);
            res = Math.min(res, abs);

            return;
        }

        for (int i = start; i < n; i++) {
            entry[i] = 1;
            req(i + 1, num + 1);
            entry[i] = 0;
        }


    }

}
