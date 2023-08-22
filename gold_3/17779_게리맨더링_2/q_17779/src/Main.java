import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[][] peopleNumbers;

    public static void main(String[] args) throws IOException {
//        n = Integer.parseInt(br.readLine());
//
//        peopleNumbers = new int[n + 1][n + 1];
//        for (int y = 1; y < n + 1; y++) {
//            st = new StringTokenizer(br.readLine());
//            for (int x = 1; x < n + 1; x++) {
//                peopleNumbers[y][x] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int y = 1; y < n + 1; y++) {
//            for (int x = 1; x < n + 1; x++) {
//                solve(y, x);
//            }
//        }
        n = 7;
        simulation(new TestCase(4, 2, 2, 2));


    }

    static void solve(int y, int x) {
        checkAllDistPair(y, x);
    }

    private static void checkAllDistPair(int y, int x) {
        for (int d1 = 1; d1 < n; d1++) {
            for (int d2 = 1; d2 < n; d2++) {
                if (d1 + d2 > n - x) {
                    continue;
                }

                if (d1 > y - 1) {
                    continue;
                }

                if (d2 > n - y) {
                    continue;
                }

                simulation(new TestCase(y, x, d1, d2));

            }
        }
    }

    private static void simulation(TestCase tc) {
        int[][] peopleGroupNumber = new int[n + 1][n + 1];

        fill5group(peopleGroupNumber, tc);
        System.out.println(" ");

    }

    private static void fill5group(int[][] peopleGroupNumber, TestCase tc) {
        Position up = new Position(tc.y - tc.d1, tc.x + tc.d1);
        Position down = new Position(tc.y + tc.d2, tc.x + tc.d2);
        Position left = new Position(tc.y, tc.x);
        Position right = new Position(tc.y - tc.d1 + tc.d2, tc.x + tc.d1 + tc.d2);

        for (int y = 1; y < n + 1; y++) {
            for (int x = 1; x < n + 1; x++) {
                if (up.isUp(y) && down.isDown(y) && left.isLeft(x) && right.isRight(x)) {
                    peopleGroupNumber[y][x] = 5;
                }
            }
        }
    }


    private static class TestCase {
        int y;
        int x;
        int d1;
        int d2;

        public TestCase(int y, int x, int d1, int d2) {
            this.y = y;
            this.x = x;
            this.d1 = d1;
            this.d2 = d2;
        }
    }

    private static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public boolean isUp(int y) {
            return this.y <= y;
        }

        public boolean isDown(int y) {
            return this.y >= y;
        }

        public boolean isLeft(int x) {
            return this.x <= x;
        }

        public boolean isRight(int x) {
            return this.x >= x;
        }

    }


/*
    d1 > 1, d2 > 1;

    d1 + d2 <= n - x;
    0 < d1 <= y -1
    0 < d2 ≤ n -y
*/


}
