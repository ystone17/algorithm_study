import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    static int[] res = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int length = Integer.parseInt(br.readLine());
        int[][] paper = new int[length][length];

        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(paper, length, 0, 0);

        for (int r : res) {
            System.out.println(r);
        }

    }

    // i, j 는 이중배열인 색종이를 순회할떄 처음 시작하는 좌표

    static void cutPaper(int[][] paper, int length, int i, int j) {
        if (length == 1) {
            res[paper[i][j]]++;
            return;
        }

        int base = paper[i][j];

        for (int ii = 0; ii < length; ii++) {
            for (int jj = 0; jj < length; jj++) {
                if (paper[i + ii][j + jj] != base) {
                    int nextLen = length / 2;
                    for (int iii = 0; iii < length; iii += nextLen) {
                        for (int jjj = 0; jjj < length; jjj += nextLen) {
                            cutPaper(paper, nextLen, i + iii, j + jjj);
                        }
                    }
                    return;
                }
            }
        }

        res[base]++;

    }


}
