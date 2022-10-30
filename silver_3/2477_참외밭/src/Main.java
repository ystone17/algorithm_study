import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static Deque<Edge> dq = new LinkedList<>();
    static int[] counting = new int[5];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            dq.addLast(new Edge(dir, len));
            counting[dir]++;
        }


        while (counting[dq.peekFirst().dir] == 2) {
            dq.addLast(dq.pollFirst());
        }

        while (counting[dq.peekFirst().dir] == 1) {
            dq.addLast(dq.pollFirst());
        }

        int a = 1;
        int b = 1;

        dq.addLast(dq.pollFirst());
        b *= dq.pollFirst().len;
        b *= dq.pollFirst().len;

        dq.pollFirst();

        a *= dq.pollFirst().len;
        a *= dq.pollFirst().len;

        System.out.println((a - b) * n);

    }

    static class Edge {
        int dir;
        int len;

        public Edge(int dir, int len) {
            this.dir = dir;
            this.len = len;
        }
    }
}
