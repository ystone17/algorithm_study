import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int g, p, res;
    static boolean[] used;

    static int[] parent;

    public static void main(String[] args) throws IOException {
        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());

        parent = new int[g + 1];

        for (int i = 1; i <= g; i++) {
            parent[i] = i;
        }

        int g1;

        for (int i = 0; i < p; i++) {
            g1 = Integer.parseInt(br.readLine());

            int emptyGate = find(g1);
            if(emptyGate == 0) break;

            res++;
            union(emptyGate - 1, emptyGate);
        }

        System.out.println(res);
    }

    static int find(int k) {
        if (k == parent[k]) return k;
        return parent[k] = find(parent[k]);
    }

    static void union(int low, int high){
        low = find(low);
        high = find(high);

        if(low == high) return;

        parent[high] = low;
    }


}
