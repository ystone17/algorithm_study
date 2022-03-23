import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int mode, vNum, eNum, max_expo;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] parents;
    static int[][] parentsExponential;
    static int[] depths;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        mode = Integer.parseInt(st.nextToken());
        vNum = Integer.parseInt(st.nextToken());
        eNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i < vNum + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < eNum; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l != -1) {
                graph.get(p).add(l);
                graph.get(l).add(p);
            }
            if (r != -1) {
                graph.get(p).add(r);
                graph.get(r).add(p);
            }
        }
        depths = new int[vNum + 1];

        switch (mode) {
            case 1:
                parents = new int[vNum + 1];
                getParentAndDepthLinear(1, 0);

                while (true) {
                    System.out.print("입력 : ");
                    st = new StringTokenizer(br.readLine());

                    int lca = LCA(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    System.out.println(lca);
                }
            case 2:
                max_expo = (int) (Math.log(vNum) / Math.log(2));
                parentsExponential = new int[vNum + 1][max_expo + 1];
//                getParentAndDepthExponential(1, 0);
//                setParents();
                setParentsDp(1, 0);

                while (true) {
                    System.out.print("입력 : ");
                    st = new StringTokenizer(br.readLine());

                    int lca = LCAExponential(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    System.out.println(lca);
                }
        }


    }

    static void getParentAndDepthLinear(int parent, int depth) {
        depths[parent] = depth;

        for (int child : graph.get(parent)) {
            if (parents[parent] == child) continue;
            parents[child] = parent;
            getParentAndDepthLinear(child, depth + 1);
        }
    }

    static int LCA(int u, int v) {
        // depths[u] >=  depth[v]
        if (depths[u] < depths[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int sub = depths[u] - depths[v];

        while (sub != 0) {
            u = parents[u];
            sub--;
        }

        while (u != v) {
            u = parents[u];
            v = parents[v];
        }

        return u;
    }

    static void getParentAndDepthExponential(int parent, int depth) {
        depths[parent] = depth;

        for (int child : graph.get(parent)) {
            if (parentsExponential[parent][0] == child) continue;
            parentsExponential[child][0] = parent;
            getParentAndDepthExponential(child, depth + 1);
        }
    }

    static void setParents() {
        for (int i = 1; i <= max_expo; i++) {
            for (int vertex = 1; vertex <= vNum; vertex++) {
                if (parentsExponential[vertex][i - 1] == 0) continue;
                parentsExponential[vertex][i] = parentsExponential[parentsExponential[vertex][i - 1]][i - 1];
            }
        }
    }

    static void setParentsDp(int vertex, int parent){
        depths[vertex] = depths[parent] + 1;

        parentsExponential[vertex][0] = parent;

        for (int i = 1; i <= max_expo; i++) {
            parentsExponential[vertex][i] = parentsExponential[parentsExponential[vertex][i - 1]][i - 1];
        }

        for (int child : graph.get(vertex)) {
            if(child == parent) continue;
            setParentsDp(child, vertex);
        }

    }


    static int LCAExponential(int u, int v) {

        if (depths[u] < depths[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int sub = depths[u] - depths[v];
        int pos = 0;

        while (sub != 0) {
            if ((sub & 1) == 1) {
                u = parentsExponential[u][pos];
            }

            sub = sub >> 1;
            pos++;
        }

        if (u == v) {

            return u;


        }
        for (int i = max_expo; i >= 0; i--) {
            if (parentsExponential[u][i] != parentsExponential[v][i]) {
                u = parentsExponential[u][i];
                v = parentsExponential[v][i];
            }
        }

        return parentsExponential[u][0];
    }


}


//tc 1

/*
2 15 7
1 2 3
2 4 5
3 6 7
4 8 9
5 10 11
6 12 13
7 14 15
 */

//tc 2
/*
2 15 15
1 2 -1
2 3 -1
3 4 -1
4 5 -1
5 6 -1
6 7 -1
7 8 -1
8 9 -1
9 10 -1
10 11 -1
11 12 -1
12 13 -1
13 14 -1
14 15 -1
15 -1 -1
 */