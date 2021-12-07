import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] res = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        recursion(paper, n, 0, n, 0, n);
        for (int re : res) {
            System.out.println(re);
        }

    }

    static void recursion(int[][] paper, int length, int iStart, int iEnd, int jStart, int jEnd) {
        if (length == 1) {
            res[paper[iStart][jStart] + 1]++;
            return;
        }

        int nextLength = length / 3;

        int base = paper[iStart][jStart];

        for (int i = iStart; i < iEnd; i++) {
            for (int j = jStart; j < jEnd; j++) {

                if (paper[i][j] != base) {

                    recursion(paper, nextLength, iStart, iStart + nextLength, jStart, jStart + nextLength);
                    recursion(paper, nextLength, iStart, iStart + nextLength, jStart + nextLength, jStart + nextLength * 2);
                    recursion(paper, nextLength, iStart, iStart + nextLength, jStart + nextLength * 2, jStart + nextLength * 3);

                    recursion(paper, nextLength, iStart + nextLength, iStart + nextLength * 2, jStart, jStart + nextLength);
                    recursion(paper, nextLength, iStart + nextLength, iStart + nextLength * 2, jStart + nextLength, jStart + nextLength * 2);
                    recursion(paper, nextLength, iStart + nextLength, iStart + nextLength * 2, jStart + nextLength * 2, jStart + nextLength * 3);

                    recursion(paper, nextLength, iStart + nextLength * 2, iStart + nextLength * 3, jStart, jStart + nextLength);
                    recursion(paper, nextLength, iStart + nextLength * 2, iStart + nextLength * 3, jStart + nextLength, jStart + nextLength * 2);
                    recursion(paper, nextLength, iStart + nextLength * 2, iStart + nextLength * 3, jStart + nextLength * 2, jStart + nextLength * 3);

                    return;
                }

            }
        }

        res[base + 1]++;
    }

}

