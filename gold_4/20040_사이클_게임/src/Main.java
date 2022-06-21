import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int v, gameNum;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        gameNum = Integer.parseInt(st.nextToken());

        parent = new int[v];
        Arrays.fill(parent, -1);


        for (int i = 0; i < gameNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) == find(b)){
                System.out.println(i + 1);
                return;
            }

            union(a, b);
        }

        System.out.println(0);

    }

    static int find(int k) {
        if (parent[k] < 0) {
            return k;
        } else {
            return parent[k] = find(parent[k]);
        }
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


}
