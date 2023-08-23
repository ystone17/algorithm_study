import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, res = Integer.MAX_VALUE;
    static int[][] peopleNumbers;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        peopleNumbers = new int[n + 1][n + 1];
        for (int y = 1; y < n + 1; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x < n + 1; x++) {
                peopleNumbers[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 1; y < n + 1; y++) {
            for (int x = 1; x < n + 1; x++) {
                solve(y, x);
            }
        }
        System.out.println(res);
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

        draw5Boarder(peopleGroupNumber, tc);
        fillGroup(tc, peopleGroupNumber);

        int[] totalByGroup = new int[6];
        for (int y = 1; y < n + 1; y++) {
            for (int x = 1; x < n + 1; x++) {
                if (peopleGroupNumber[y][x] == 1) {
                    totalByGroup[1] += peopleNumbers[y][x];
                }

                if (peopleGroupNumber[y][x] == 2) {
                    totalByGroup[2] += peopleNumbers[y][x];
                }

                if (peopleGroupNumber[y][x] == 3) {
                    totalByGroup[3] += peopleNumbers[y][x];
                }

                if (peopleGroupNumber[y][x] == 4) {
                    totalByGroup[4] += peopleNumbers[y][x];
                }

                if (peopleGroupNumber[y][x] == 5) {
                    totalByGroup[5] += peopleNumbers[y][x];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < totalByGroup.length; i++) {
            max = Math.max(max, totalByGroup[i]);
            min = Math.min(min, totalByGroup[i]);
        }

        res = Math.min(res, max - min);
    }

    private static void fillGroup(TestCase tc, int[][] peopleGroupNumber) {
        for (int y = 1; y < n + 1; y++) {
            boolean isFive = false;
            for (int x = 1; x < n + 1; x++) {
                if (peopleGroupNumber[y][x] == 5) {
                    isFive = !isFive;
                    continue;
                }

                if (isFive && y != tc.y - tc.d1 && y != tc.y + tc.d2) {
                    peopleGroupNumber[y][x] = 5;
                    continue;
                }

                if (is1Block(peopleGroupNumber, tc, y, x)) {
                    peopleGroupNumber[y][x] = 1;
                    continue;
                }

                if (is2Block(peopleGroupNumber, tc, y, x)) {
                    peopleGroupNumber[y][x] = 2;
                    continue;
                }

                if (is3Block(peopleGroupNumber, tc, y, x)) {
                    peopleGroupNumber[y][x] = 3;
                    continue;
                }

                if (is4Block(peopleGroupNumber, tc, y, x)) {
                    peopleGroupNumber[y][x] = 4;
                    continue;
                }
            }
        }
    }

    private static void draw5Boarder(int[][] peopleGroupNumber, TestCase tc) {
        Position up = new Position(tc.y - tc.d1, tc.x + tc.d1);
        Position down = new Position(tc.y + tc.d2, tc.x + tc.d2);
        Position left = new Position(tc.y, tc.x);
        Position right = new Position(tc.y - tc.d1 + tc.d2, tc.x + tc.d1 + tc.d2);

        drawBoarder(peopleGroupNumber, up, left, 1, -1);
        drawBoarder(peopleGroupNumber, up, right, 1, 1);
        drawBoarder(peopleGroupNumber, down, left, -1, -1);
        drawBoarder(peopleGroupNumber, down, right, -1, 1);
    }

    private static boolean is1Block(int[][] peopleGroupNumber, TestCase tc, int y, int x) {
        return y < tc.y && x <= tc.x + tc.d1 && peopleGroupNumber[y][x] == 0;
    }

    private static boolean is2Block(int[][] peopleGroupNumber, TestCase tc, int y, int x) {
        return y <= tc.y - tc.d1 + tc.d2 && x > tc.x + tc.d1 && peopleGroupNumber[y][x] == 0;
    }

    private static boolean is3Block(int[][] peopleGroupNumber, TestCase tc, int y, int x) {
        return y >= tc.y && x < tc.x + tc.d2 && peopleGroupNumber[y][x] == 0;
    }

    private static boolean is4Block(int[][] peopleGroupNumber, TestCase tc, int y, int x) {
        return y >= tc.y - tc.d1 + tc.d2 && x >= tc.x + tc.d2 && peopleGroupNumber[y][x] == 0;
    }

    private static void drawBoarder(int[][] peopleGroupNumber, Position start, Position end, int dy, int dx) {
        int y = start.y;
        int x = start.x;

        peopleGroupNumber[end.y][end.x] = 5;

        while (!(end.y == y && end.x == x)) {
            peopleGroupNumber[y][x] = 5;
            y += dy;
            x += dx;
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
    }
}
