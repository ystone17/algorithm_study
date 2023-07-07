import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static String[][] map;
    static List<Pos> emptyList = new ArrayList<>();
    static List<Pos> teacherList = new ArrayList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("X")) {
                    emptyList.add(new Pos(i, j));
                }

                if (map[i][j].equals("T")) {
                    teacherList.add(new Pos(i, j));
                }
            }
        }

        for (int a = 0; a < emptyList.size(); a++) {
            for (int b = a + 1; b < emptyList.size(); b++) {
                for (int c = b + 1; c < emptyList.size(); c++) {
                    boolean res = solve(a, b, c);
                    if (res) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }

        System.out.println("NO");

    }

    static boolean solve(int a, int b, int c) {
        Pos emptyA = emptyList.get(a);
        Pos emptyB = emptyList.get(b);
        Pos emptyC = emptyList.get(c);

        map[emptyA.y][emptyA.x] = "O";
        map[emptyB.y][emptyB.x] = "O";
        map[emptyC.y][emptyC.x] = "O";

        boolean res = search();

        map[emptyA.y][emptyA.x] = "X";
        map[emptyB.y][emptyB.x] = "X";
        map[emptyC.y][emptyC.x] = "X";
        return res;
    }

    static boolean search() {
        for (Pos teacher : teacherList) {
            for (int i = 0; i < 4; i++) {
                int y = teacher.y + dy[i];
                int x = teacher.x + dx[i];

                while (!(y < 0 || y >= n || x < 0 || x >= n)) {
                    if (map[y][x].equals("O")) {
                        break;
                    }

                    if (map[y][x].equals("S")) {
                        return false;
                    }
                    y += dy[i];
                    x += dx[i];
                }
            }
        }

        return true;
    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
