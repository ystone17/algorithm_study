import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, dir, idx;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            move();

            sb.append(idx + 1).append(" ");

            dir = arr[idx];
            arr[idx] = 0;
        }
        System.out.println(sb);
    }

    private static void move() {
        while (dir != 0) {
            if (dir > 0) {
                idx = (idx + 1) % n;
                if (arr[idx] == 0) continue;
                dir--;

            } else {
                idx = idx == 0 ? n - 1 : idx - 1;
                if (arr[idx] == 0) continue;
                dir++;
            }
        }
    }


}
