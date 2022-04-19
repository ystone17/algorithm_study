import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] sdk = new int[9][9];
    static int[][] vertical = new int[9][10];
    static int[][] horizontal = new int[9][10];
    /*
    0 1 2
    3 4 5
    6 7 8
     */
    static int[][] smallSquare = new int[9][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sdk[i][j] = Integer.parseInt(st.nextToken());
                if (sdk[i][j] != 0) {
                    vertical[j][sdk[i][j]] = 1;
                    horizontal[i][sdk[i][j]] = 1;
                    smallSquare[i / 3 * 3 + j / 3][sdk[i][j]] = 1;
                }
            }
        }
        backTracking(0, 0);
    }

    private static boolean backTracking(int y, int x) {
        if (y == 9 && x == 0) {
            printSdk();
            return true;
        }

        if (sdk[y][x] == 0) {
            for (int num = 1; num <= 9; num++) {
                if (vertical[x][num] == 0 && smallSquare[y / 3 * 3 + x / 3][num] == 0 && horizontal[y][num] == 0) {
                    horizontal[y][num] = 1;
                    vertical[x][num] = 1;
                    smallSquare[y / 3 * 3 + x / 3][num] = 1;
                    sdk[y][x] = num;
                    if (x != 8) {
                        if(backTracking(y, x + 1)) return true;
                    }
                    else {
                        if(backTracking(y + 1, 0)) return true;
                    }
                    horizontal[y][num] = 0;
                    vertical[x][num] = 0;
                    smallSquare[y / 3 * 3 + x / 3][num] = 0;
                    sdk[y][x] = 0;
                }
            }
        } else {
            if (x != 8) {
                return backTracking(y, x + 1);
            }
            else {
                return backTracking(y + 1, 0);
            }
        }

        return false;

    }

    private static void printSdk() {
        for (int[] row : sdk) {
            for (int i : row) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}
