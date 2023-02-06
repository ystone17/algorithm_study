import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] tri = new int[31][31];

    public static void main(String[] args) throws IOException {
        for (int row = 1; row <= 30; row++) {
            tri[row][1] = 1;
            tri[row][row] = 1;
            for (int col = 2; col < row; col++) {
                tri[row][col] = tri[row - 1][col - 1] + tri[row - 1][col];
            }
        }

        st = new StringTokenizer(br.readLine());

        System.out.println(tri[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]);
    }
}
