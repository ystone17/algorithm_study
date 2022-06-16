import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int me, u, time = Integer.MAX_VALUE;
    static int[] visited = new int[100_000 + 1];
    static Queue<Integer> q = new LinkedList<>();
    static Queue<Pos> addQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        me = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());

        if (me == u) {
            System.out.printf("0\n1");
            return;
        }


        q.add(me);

        int t = 1;
        int cnt = 0;
        while (!q.isEmpty()) {
            if (t > time) break;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer cur = q.poll();
                visited[cur] = 1;

                if (cur + 1 <= 100_000 && visited[cur + 1] == 0) {
                    q.add(cur + 1);
                    if (cur + 1 == u) {
                        time = t;
                        cnt++;
                    }
                }

                if (cur - 1 >= 0 && visited[cur - 1] == 0) {
                    q.add(cur - 1);
                    if (cur - 1 == u) {
                        time = t;
                        cnt++;
                    }
                }

                if (cur * 2 <= 100_000 && visited[cur * 2] == 0) {
                    q.add(cur * 2);
                    if (cur * 2 == u) {
                        time = t;
                        cnt++;
                    }
                }
            }

            t++;
        }

        System.out.println(t-1);
        System.out.println(cnt);

    }

    private static class Pos {
        int idx;
        int value;

        public Pos(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
