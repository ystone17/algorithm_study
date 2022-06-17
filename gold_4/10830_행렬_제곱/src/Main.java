import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long b;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        if (b == 100000000000L){
            while (b != 0){
                System.out.printf("%d\n", b);
                b /= 2;
            }
            return;
        }
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] pow = pow(matrix, b);
        for (int[] ints : pow) {
            for (int anInt : ints) {
                System.out.printf("%d ",anInt);
            }
            System.out.println();
        }


    }

    public static int[][] pow(int[][] m, long b) {
        if (b == 1) {
            int[][] res = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j] = m[i][j] % 1000;
                }
            }
            return res;
        }


        int[][] pow = pow(m, b / 2);
        if (b % 2 == 0) {
            return mul(pow, pow);
        } else {
            return mul(mul(pow, pow), m);
        }
    }

    public static int[][] mul(int[][] a, int[][] b) {
        int[][] res = new int[n][n];
        int temp;

        for (int ay = 0; ay < n; ay++) {
            for (int bx = 0; bx < n; bx++) {
                temp = 0;
                for (int i = 0; i < n; i++) {
                    temp = (temp + a[ay][i] * b[i][bx]) % 1000;
                }
                res[ay][bx] = temp;
            }
        }

        return res;
    }
}
