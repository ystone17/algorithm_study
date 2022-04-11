import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int start, end;
    static int[] map = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Arrays.fill(map, Integer.MAX_VALUE);
        map[start] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == end) {
                System.out.println(map[cur]);
                return;
            }

            if (cur - 1 >= 0 && map[cur] + 1 < map[cur - 1]) {
                q.add(cur - 1);
                map[cur - 1] = map[cur] + 1;
            }

            if (cur + 1 <= 100000 && cur < end && map[cur] + 1 < map[cur + 1]) {
                q.add(cur + 1);
                map[cur + 1] = map[cur] + 1;
            }

            if (cur * 2 <= 100000 && cur < end && map[cur] < map[cur * 2]) {
                q.add(cur * 2);
                map[cur * 2] = map[cur];
            }
        }


    }
}
