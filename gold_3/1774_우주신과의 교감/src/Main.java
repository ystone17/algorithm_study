import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int vNum, zeroNum;
    static Pos[] PosArr;
    static Node[] nodes;
    static double answer;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        read();
        kruskal();
        System.out.printf("%.2f", answer);
    }

    private static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
        vNum = Integer.parseInt(st.nextToken());
        zeroNum = Integer.parseInt(st.nextToken());
        parent = new int[vNum];
        Arrays.fill(parent, -1);
        PosArr = new Pos[vNum];
        nodes = new Node[vNum * (vNum - 1)];
        for (int i = 0; i < vNum; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            PosArr[i] = new Pos(y, x);
        }

        int idx = 0;
        for (int u = 0; u < vNum; u++) {
            for (int v = 0; v < vNum; v++) {
                if (u == v) continue;
                double y = Math.pow(PosArr[u].y - PosArr[v].y, 2);
                double x = Math.pow(PosArr[u].x - PosArr[v].x, 2);
                nodes[idx++] = new Node(u, v, Math.sqrt(y + x));
            }
        }


        for (int i = 0; i < zeroNum; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u - 1, v - 1);
        }


    }

    private static void kruskal() {
        Arrays.sort(nodes);
        for (Node node : nodes) {
            if (find(node.to) == find(node.from)) continue;
            union(node.to, node.from);
            answer += node.weight;
        }
    }

    static int find(int k) {
        if (parent[k] < 0) return k;
        return parent[k] = find(parent[k]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        if (parent[a] < parent[b]) {
            parent[a] += parent[b];
            parent[b] = a;
        } else {
            parent[b] += parent[a];
            parent[a] = b;
        }

    }


    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int from;
        double weight;

        public Node(int to, int from, double weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(weight, o.weight);
        }
    }
}
