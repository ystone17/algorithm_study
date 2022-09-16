import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int len, cnt;
    static int[] arr, visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        len = Integer.parseInt(br.readLine());
        arr = new int[len];
        visited = new int[len];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        q.add(0);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Integer cur = q.poll();
                if(cur == len - 1) {
                    System.out.println(cnt);
                    return;
                }

                for (int j = 1; j < arr[cur] + 1; j++) {
                    if (cur + j >= len) continue;
                    if (visited[cur + j] == 1) continue;
                    visited[cur + j] = 1;
                    q.add(cur + j);
                }
            }
            cnt++;
        }

        System.out.println(-1);
    }
}
