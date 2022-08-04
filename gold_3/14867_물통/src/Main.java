import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int a, b, c, d;
    static Set<String> visitedSet = new HashSet<>();
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        q.add(new Pos(0, 0));
        visitedSet.add(0 + "" + 0);

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pos cur = q.poll();

                if (cur.y == c && cur.x == d) {
                    System.out.println(cnt);
                    return;
                }

                int ny = 0;
                int nx = 0;

                if (cur.y != a) {
                    ny = a;
                    nx = cur.x;
                    if (!visitedSet.contains(ny + "_" + nx)) {
                        visitedSet.add(ny + "_" + nx);
                        q.add(new Pos(ny, nx));
                    }
                }

                if (cur.x != b) {
                    ny = cur.y;
                    nx = b;
                    if (!visitedSet.contains(ny + "_" + nx)) {
                        visitedSet.add(ny + "_" + nx);
                        q.add(new Pos(ny, nx));
                    }
                }

                if (cur.y != 0) {
                    ny = 0;
                    nx = cur.x;
                    if (!visitedSet.contains(ny + "_" + nx)) {
                        visitedSet.add(ny + "_" + nx);
                        q.add(new Pos(ny, nx));
                    }
                }

                if (cur.x != 0) {
                    ny = cur.y;
                    nx = 0;
                    if (!visitedSet.contains(ny + "_" + nx)) {
                        visitedSet.add(ny + "_" + nx);
                        q.add(new Pos(ny, nx));
                    }
                }

                if (cur.y != 0 && cur.x != b) {
                    if (cur.y <= b - cur.x) {
                        ny = 0;
                        nx = cur.x + cur.y;
                    } else {
                        ny = cur.y - (b - cur.x);
                        nx = b;
                    }
                    if (!visitedSet.contains(ny + "_" + nx)) {
                        visitedSet.add(ny + "_" + nx);
                        q.add(new Pos(ny, nx));
                    }
                }

                if (cur.y != a && cur.x != 0) {
                    if (cur.x <= a - cur.y) {
                        ny = cur.x + cur.y;
                        nx = 0;
                    } else {
                        ny = a;
                        nx = cur.x - (a - cur.y);
                    }
                    if (!visitedSet.contains(ny + "_" + nx)) {
                        visitedSet.add(ny + "_" + nx);
                        q.add(new Pos(ny, nx));
                    }
                }
            }

            cnt++;
        }

        System.out.println(-1);

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
