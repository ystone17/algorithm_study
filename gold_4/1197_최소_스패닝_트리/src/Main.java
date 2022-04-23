import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Node[] nodes;
    static int vNum, eNum;


    public static void main(String[] args) throws IOException {
//        kruskal();
//        prim_arr();
        prim_pq();
    }

    static int[] dist, selected;
    static List<List<Node>> graph = new ArrayList<>();


    private static void prim_arr() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        vNum = Integer.parseInt(st.nextToken());
        eNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= vNum; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < eNum; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(from, to, value));
            graph.get(to).add(new Node(to, from, value));
        }

        dist = new int[vNum + 1];
        selected = new int[vNum + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        int answer = 0;
        dist[1] = 0;
        for (int i = 1; i <= vNum; i++) {
            int now = -1;
            int d = Integer.MAX_VALUE;
            for (int j = 1; j <= vNum; j++) {
                if (selected[j] == 0 && d > dist[j]) {
                    now = j;
                    d = dist[j];
                }
            }
            selected[now] = 1;
            answer += d;
            for (Node node : graph.get(now)) {
                dist[node.to] = Math.min(dist[node.to], node.value);
            }
        }
        System.out.println(answer);
    }

    private static void prim_pq() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        vNum = Integer.parseInt(st.nextToken());
        eNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= vNum; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < eNum; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(from, to, value));
            graph.get(to).add(new Node(to, from, value));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        selected = new int[vNum + 1];

        int answer = 0;
        pq.add(new Node(1, 1, 0));
        for (int i = 1; i <= vNum; i++) {
            int now = -1;
            int d = Integer.MAX_VALUE;
            while (!pq.isEmpty()){
                Node poll = pq.poll();
                if(selected[poll.from] == 0){
                    selected[poll.from] = 1;
                    now = poll.from;
                    d = poll.value;
                    break;
                }
            }
            answer += d;
            for (Node node : graph.get(now)) {
                pq.add(new Node(node.to, node.from, node.value));
            }
        }
        System.out.println(answer);
    }

    static int[] parent;

    private static void kruskal() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        vNum = Integer.parseInt(st.nextToken());
        eNum = Integer.parseInt(st.nextToken());
        nodes = new Node[eNum];
        parent = new int[vNum + 1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < eNum; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(from, to, value);
        }

        Arrays.sort(nodes);

        int total = 0;
        int size = vNum - 1;
        for (Node node : nodes) {
            if (size == 0) break;
            if (find(node.from) == find(node.to)) continue;
            merge(node.from, node.to);
            size--;
            total += node.value;
        }

        System.out.println(total);
    }

    static int find(int a) {
        if (parent[a] < 0) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static void merge(int a, int b) {
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


    static class Node implements Comparable<Node> {
        int from;
        int to;
        int value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(value, o.value);
        }

    }
}
