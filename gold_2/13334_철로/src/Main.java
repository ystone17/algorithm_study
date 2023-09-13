import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, d;
    static List<Pos> posList = new ArrayList<>();
    static Queue<Pos> q = new LinkedList<>();
    static PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
        @Override
        public int compare(Pos o1, Pos o2) {
            return 0;
        }
    });
    static int res;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            posList.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        d = Integer.parseInt(br.readLine());

        posList = posList.stream()
                .filter(pos -> (pos.right - pos.left) <= d)
                .collect(Collectors.toList());

        Collections.sort(posList);

        for (Pos pos : posList) {
            if (q.isEmpty()) {
                q.add(pos);
                res = Math.max(res, q.size());
                continue;
            }

            if (pos.right - d <= q.peek().left) {
                q.add(pos);
                res = Math.max(res, q.size());
                continue;
            }

            while (!q.isEmpty() && pos.right - d > q.peek().left) {
                q.poll();
            }
            q.add(pos);
            res = Math.max(res, q.size());
        }

        System.out.println(res);
    }

    private static class Pos implements Comparable<Pos> {
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

        @Override
        public int compareTo(Pos o) {
            if (this.right != o.right) {
                return Integer.compare(this.right, o.right);
            }

            return Integer.compare(this.left, o.left);
        }
    }
}
