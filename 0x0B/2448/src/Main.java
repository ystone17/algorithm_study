import java.io.*;

public class Main {

    static char[][] tri;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        tri = new char[n][2 * n - 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n-1; j++) {
                tri[i][j] = ' ';
            }
        }

        paint(n, 0, n - 1);
        for (char[] row : tri) {
            bw.write(row);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void paint(int n, int y, int x) {
        if (n == 3) {
            tri[y][x] = '*';
            tri[y + 1][x + 1] = '*';
            tri[y + 1][x - 1] = '*';
            for (int i = -2; i < 3; i++) {
                tri[y + 2][x + i] = '*';
            }
            return;
        }

        int nextSize = n / 2;
        paint(nextSize, y, x);
        paint(nextSize, y + nextSize, x - (nextSize));
        paint(nextSize, y + nextSize, x + (nextSize));
    }
}
