import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static List<List<Integer>> graph = new ArrayList<>();
    static int n;
    static boolean[] isParent;
    static int[] parentCounts;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        isParent = new boolean[n + 1];
        parentCounts = new int[n + 1];
        parentCounts[1] = 0;


        q.add(1);
        isParent[1] = true;
        while (!q.isEmpty()) {
            var parent = q.poll();
            var parentCount = parentCounts[parent];

            for (Integer child : graph.get(parent)) {
                if (isParent[child]) {
                    continue;
                }

                parentCounts[child] = parentCount + 1;
                q.add(child);
                isParent[parent] = true;
            }
        }

        var total = 0L;

        for (int i = 0; i < parentCounts.length; i++) {
            if (isParent[i]) {
                continue;
            }

            total += parentCounts[i];
        }

        System.out.println(total % 2 == 0 ? "No" : "Yes");
    }


}
