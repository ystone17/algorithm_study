import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int y, x, answer;
    static int[][] a, b;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        a = new int[y][x];
        b = new int[y][x];

        for (int i = 0; i < y; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < x; j++) {
                a[i][j] = row[j] - '0';
            }
        }

        for (int i = 0; i < y; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < x; j++) {
                b[i][j] = row[j] - '0';
            }
        }

        for (int i = 0; i <= y - 3; i++) {
            for (int j = 0; j <= x - 3; j++) {
                if (a[i][j] != b[i][j]) {
                    swap(i, j);
                    answer++;
                }
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(a[i][j] != b[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer);
    }

    static void swap(int y, int x) {
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                b[i][j] = (b[i][j] + 1) % 2;
            }
        }
    }
}


//gcd lcm