import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n,  res = Integer.MAX_VALUE, total;
    static int[] hNum;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] aBound;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        hNum = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        aBound = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hNum[i + 1] = Integer.parseInt(st.nextToken());
            total += hNum[i + 1];
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int j = Integer.parseInt(st.nextToken());
            for (int k = 0; k < j; k++) {
                int v = Integer.parseInt(st.nextToken());
                graph.get(i + 1).add(v);
                graph.get(v).add(i + 1);
            }
        }

        for (int i = 0; i <= n/2; i++) {
            comb(1, i, 0, 0 );
        }


        if(res == Integer.MAX_VALUE){
            System.out.println(-1);
        } else{
            System.out.println(res);
        }
    }

    static void comb(int start, int r, int sum, int cnt){
        if(r == 0){
            if(bfs(true, cnt) && bfs(false, n - cnt)){
                res = Math.min(res, Math.abs(sum - (total - sum)));
            }

        }

        for (int i = start; i <= n; i++) {
            if(aBound[i]) continue;
            aBound[i] = true;
            comb(i + 1, r - 1, sum + hNum[i], cnt + 1);
            aBound[i] = false;
        }

    }

    static boolean bfs(boolean check, int cnt){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < aBound.length; i++) {
            if(aBound[i] == check) {
                visited[i] = true;
                cnt--;
                q.add(i);
                break;
            }
        }

        while (!q.isEmpty()){
            Integer cur = q.poll();

            for (Integer next : graph.get(cur)) {
                if(aBound[next] != check || visited[next]) continue;
                cnt--;
                visited[next] = true;
                q.add(next);
            }
        }

        return cnt == 0;
    }


}
