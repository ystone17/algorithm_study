import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, d;
    static List<Pos> posList = new ArrayList<>();
    static PriorityQueue<Pos> pq;
    static int res;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            posList.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        d = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.left));
        posList.sort(Comparator.comparingInt(o -> o.right));
        for (Pos pos : posList) {
            if (pos.right - pos.left > d) {
                continue;
            }

            while (!pq.isEmpty() && pos.right - d > pq.peek().left) {
                pq.poll();
            }

            pq.add(pos);
            res = Math.max(res, pq.size());
        }

        System.out.println(res);
    }

    private static class Pos {
        int left;
        int right;

        public Pos(int a, int b) {
            if (a < b) {
                this.left = a;
                this.right = b;
            } else {
                this.left = b;
                this.right = a;
            }
        }
    }
}
