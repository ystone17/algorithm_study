import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

//        parent = new int[n + 1];
//        rank = new int[n + 1];
//        for (int i = 0; i <= n; i++) {
//            parent[i] = i;
//            rank[i] = 1;
//        }

        //Weighted union-find
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        // union by rank
        if (rank[a] > rank[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        parent[a] = b;

        if (rank[a] == rank[b])
            ++rank[b];


        parent[a] = b;
    }

    static int find(int n) {
        if (n == parent[n]) {
            return n;
        } else {
            // path compression 경로 압축
            parent[n] = find(parent[n]);
            return parent[n];
        }
    }

    static int w_find(int a) {
        if (parent[a] < 0) {
            return a;
        } else {
            // path compression 경로 압축
            return parent[a] = find(parent[a]);
        }
    }

    static void w_union(int a, int b) {
        a = w_find(a);
        b = w_find(b);

        if (a == b) return;

        // a 가 더 큰 트리
        if (parent[a] < parent[b]) {
            parent[a] += parent[b];
            parent[b] = a;
        } else {
            parent[b] += parent[a];
            parent[a] = b;
        }


    }


}
