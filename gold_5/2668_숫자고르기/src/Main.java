import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] arr, visited, cycled;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        cycled = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < n + 1; i++) {
            if (cycled[i] == 1) continue;
            visited = new int[n + 1];
            dfs(i);
        }

        int size = 0;
        for (int i = 0; i < cycled.length; i++) {
            if(cycled[i] == 1) {
                sb.append(i).append("\n");
                size++;
            }
        }

        sb.insert(0, "\n");
        sb.insert(0, size);
        System.out.println(sb);

    }

    static void dfs(int k) {
        if (cycled[k] == 1) return;

        if (visited[k] == 1) {
            cycled[k] = 1;
            int temp = arr[k];

            while (temp != k) {
                cycled[temp] = 1;
                temp = arr[temp];
            }
        } else {
            visited[k] = 1;
            dfs(arr[k]);
        }
    }
}
