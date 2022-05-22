import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][][] sweep = {
            {
                    {0, 0, 2, 0, 0},
                    {0, 10, 7, 1, 0},
                    {5, -1, 0, 0, 0},
                    {0, 10, 7, 1, 0},
                    {0, 0, 2, 0, 0}
            },
            {
                    {0, 0, 0, 0, 0},
                    {0, 1, 0, 1, 0},
                    {2, 7, 0, 7, 2},
                    {0, 10, -1, 10, 0},
                    {0, 0, 5, 0, 0}
            },
            {
                    {0, 0, 2, 0, 0},
                    {0, 1, 7, 10, 0},
                    {0, 0, 0, -1, 5},
                    {0, 1, 7, 10, 0},
                    {0, 0, 2, 0, 0}
            },
            {
                    {0, 0, 5, 0, 0},
                    {0, 10, -1, 10, 0},
                    {2, 7, 0, 7, 2},
                    {0, 1, 0, 1, 0},
                    {0, 0, 0, 0, 0}
            }
    };
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int n, answer;
    static int[][] map;


    public static void main(String[] args) throws IOException {
        read();
        tornado();
        System.out.println(answer);
    }

    private static void read() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void tornado() {
        int dir = 0;
        int y = n / 2;
        int x = n / 2;

        int idx = 2;
        while (!(y == 0 && x == 0)) {

            for (int i = 0; i < idx / 2; i++) {
                y = y + dy[dir];
                x = x + dx[dir];
                sweep(y, x, dir);
//                print();
                if (y == 0 && x == 0) break;
            }
            dir = (dir + 1) % 4;
            idx++;
        }

    }

    static void print(){
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.printf("%2d ",anInt);
            }
            System.out.println();
        }
        System.out.println("answer = "+answer);
        System.out.println();
    }

    private static void sweep(int y, int x, int dir) {
        int[][] s = sweep[dir];

        int ori = map[y][x];
        int rTotal = 0;
        int ay = 0, ax = 0;

        for (int Y = 0; Y < s.length; Y++) {
            for (int X = 0; X < s.length; X++) {
                if (s[Y][X] == 0) continue;
                if (s[Y][X] == -1) {
                    ay = y + (Y - s.length / 2);
                    ax = x + (X - s.length / 2);
                    continue;
                }

                int ny = y + (Y - s.length / 2);
                int nx = x + (X - s.length / 2);
                double r = ori / 100.0 * s[Y][X];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                    answer += r;
                    rTotal += r;
                } else {
                    rTotal += r;
                    map[ny][nx] += r;
                }
            }
        }
        if (ay < 0 || ay >= n || ax < 0 || ax >= n) {
            answer += map[y][x] - rTotal;
        } else {
            map[ay][ax] += map[y][x] - rTotal;
        }

        map[y][x] = 0;
    }

}
