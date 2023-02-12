import javax.xml.transform.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static List<List<Integer>> tree = new ArrayList<>();
    static int n;
    static int[] g;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        g = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            g[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        List<Integer> containRoute = new ArrayList<>();
        int containRes = req(-1, 1, true, containRoute);

        List<Integer> notContainRoute = new ArrayList<>();
        int notContainRes = req(-1, 1, false, notContainRoute);


        if(containRes > notContainRes) {
            Collections.sort(containRoute);
            sb.append(containRes).append("\n");
            for (Integer i : containRoute) {
                sb.append(i).append(" ");
            }
        } else {
            Collections.sort(notContainRoute);
            sb.append(containRes).append("\n");
            for (Integer i : notContainRoute) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static int req(int parent, int me, boolean isContain, List<Integer> route) {
        int res = isContain ? g[me] : 0;
        if (isContain) route.add(me);

        for (Integer child : tree.get(me)) {
            if (child == parent) continue;

            List<Integer> notContainRoute = new ArrayList<>();
            int subRes = req(me, child, false, notContainRoute);


            if (!isContain) {
                List<Integer> containRoute = new ArrayList<>();
                int subContainRes = req(me, child, true, containRoute);

                if (subContainRes >= subRes) {
                    subRes = subContainRes;
                    route.addAll(containRoute);
                } else {
                    route.addAll(notContainRoute);
                }
            } else {
                route.addAll(notContainRoute);
            }

            res += subRes;
        }

        return res;
    }

}
