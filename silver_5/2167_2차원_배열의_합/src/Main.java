import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;
    static int[][] arr;
    static int i, j, x, y;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int l = 0; l < K; l++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            sb.append(solution(i, j, x, y)).append("\n");
        }
        System.out.println(sb);
    }

    private static int solution(int i, int j, int x, int y) {
        int sum = 0;
        for (int r = i - 1; r < x; r++) {
            for (int c = j - 1; c < y; c++) {
                sum += arr[r][c];
            }
        }
        return sum;
    }
}
