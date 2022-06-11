import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] parent, xManParent;
    static int[][] party = new int[50][50];
    static int n, partyN, xManN, answer;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        partyN = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        st = new StringTokenizer(br.readLine());
        xManN = Integer.parseInt(st.nextToken());
        if (xManN == 0) {
            System.out.println(partyN);
            return;
        }

        xManParent = new int[xManN];
        for (int i = 0; i < xManN; i++) {
            xManParent[i] = Integer.parseInt(st.nextToken());
        }

        for (int[] ints : party) {
            Arrays.fill(ints, -1);
        }

        for (int i = 0; i < partyN; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
                if(j == 0) continue;
                union(party[i][j-1], party[i][j]);
            }
        }

        for (int i = 0; i < xManParent.length; i++) {
            xManParent[i] = find(xManParent[i]);
        }

        for (int i = 0; i < partyN; i++) {
            boolean ok = false;
            for (int xMan : xManParent) {
                if(find(party[i][0]) == xMan){
                    ok = true;
                    break;
                }
            }
            if(!ok){
                answer++;
            }
        }
        System.out.println(answer);

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

