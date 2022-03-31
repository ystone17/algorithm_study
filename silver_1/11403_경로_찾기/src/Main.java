import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] answer;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph.add(new ArrayList<>());
        answer = new int[n][n];


        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int vertex = Integer.parseInt(st.nextToken());
                if(vertex ==1){
                    temp.add(j + 1);
                }
            }
            graph.add(temp);
        }
        //입력

        for (int i = 1; i <= n; i++) {
            visited = new int[n + 1];
            bfs(i, i);
        }


        // 출력
        for (int[] ints : answer) {
            for (int anInt : ints) {
                System.out.printf("%d ",anInt);
            }
            System.out.println();
        }

    }

    static void bfs(int root, int vertex){

        for (int v : graph.get(vertex)) {
            if(visited[v] == 1)continue;
            visited[v] = 1;
            answer[root - 1][v - 1] = 1;
            bfs(root, v);
        }
    }
}
