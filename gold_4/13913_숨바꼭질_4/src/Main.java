import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int x, k;
    static Queue<Pos> q = new LinkedList<>();
    static int[] visitedTime = new int[100001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(x > k) {
            System.out.println(x - k);
            for (int i = x; i >= k; i--) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        Arrays.fill(visitedTime, -1);

        int time = 0;
        q.add(new Pos(x, new LinkedList<>()));
        visitedTime[x] = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pos cur = q.poll();

                if (cur.x == k) {
                    System.out.println(time);
                    for (Integer integer : cur.route) {
                        System.out.printf("%d ", integer);
                    }
                    return;
                }
                int nx;

                nx = cur.x + 1;
                if (nx <= 100000 && visitedTime[nx] == -1) {
                    q.add(new Pos(nx, cur.route));
                    visitedTime[nx] = time + 1;
                }

                nx = cur.x - 1;
                if (0 <= nx && visitedTime[nx] == -1) {
                    q.add(new Pos(nx, cur.route));
                    visitedTime[nx] = time + 1;
                }

                nx = cur.x * 2;
                if (nx <= 100000 && visitedTime[nx] == -1) {
                    q.add(new Pos(nx, cur.route));
                    visitedTime[nx] = time + 1;
                }
            }
            time++;
        }

    }

    static class Pos {
        int x;
        Queue<Integer> route = new LinkedList<>();

        public Pos(int x, Queue<Integer> q) {
            this.x = x;
            route.addAll(q);
            route.add(x);
        }
    }
}
